package com.liberate.automation.core;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestActions {
	public String classVersion = "0.3.1";

	Boolean retry = false;
	int retryCount = 3;
	int executionCount = 0;

	int screenshotCount = 0;

	WebDriver driver = null;

	Select select = null;

	/**
	 * Default constructor, which will also create and instance of WebDriver
	 * inside class
	 */
	public TestActions() {
		screenshotCount = 0;

		System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	}

	/**
	 * Method that can be called to navigate to a particular URL.
	 * 
	 * @param URL
	 *            URL to which the driver needs to navigate to.
	 * @return Return true, if the able to navigate to the given URL, else will
	 *         return false.
	 */
	public Boolean gotoURL(String URL) {
		try {
			driver.navigate().to(URL);
		} catch (Exception e) {
			e.printStackTrace();
			retry = handleException(e);
			if (retry)
				gotoURL(URL);
			else
				return false;
		}
		return true;
	}

	/**
	 * Method that can be called to click on an element in the currently opened
	 * WebPage.
	 * 
	 * @param locator
	 *            Identifies the element which needs to be clicked.
	 * @return Return true, if able to click on the element, else will return
	 *         false.
	 */
	public Boolean clickOn(By locator) {
		try {
			driver.findElement(locator).click();
		} catch (Exception e) {
			e.printStackTrace();
			retry = handleException(e);
			if (retry)
				clickOn(locator);
			else
				return false;
		}
		return true;
	}

	/**
	 * Method that can be called to send data to any Field which is currently
	 * available in the WebPage.
	 * 
	 * @param locator
	 *            Identifies the element which the data needs to be sent.
	 * @param data
	 *            Data than needs to be sent
	 * @return Return true, if able to sent data to the provided field, else
	 *         will return false.
	 */
	public Boolean sendDataTo(By locator, String data) {
		if (data.equals(""))
			return true;

		try {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(data);
		} catch (Exception e) {
			e.printStackTrace();
			retry = handleException(e);
			if (retry)
				sendDataTo(locator, data);
			else
				return false;
		}

		return true;
	}

	/***
	 * Method that can be called to send Data to a field. Used to send
	 * Data to a field which is validated on keypress and slow to accept
	 * input.
	 * 
	 * @param locator
	 *            Identifies the element which the data needs to be sent.
	 * @param date
	 *            Date in format 'DD/MM/YYYY hh:mm'
	 * @return
	 */
	public Boolean typeDataTo(By locator, String date) {
		if (date.equals(""))
			return true;

		clearField(locator);

		try {
			char[] dateChars = date.toCharArray();

			for (int i = 0; i < date.length(); i++) {
				driver.findElement(locator).sendKeys(Character.toString(dateChars[i]));
				Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
			handleException(e);
		}

		return true;
	}

	/***
	 * Method that can be called to clear any Input field which is currently
	 * available in the WebPade.
	 * 
	 * @param locator
	 *            Identifies the element that needs to be cleared
	 * @return Returns true, if able to clear the Field, or else will return
	 *         false.
	 */
	public Boolean clearField(By locator) {
		try {
			driver.findElement(locator).clear();
		} catch (Exception e) {
			e.printStackTrace();
			retry = handleException(e);
			if (retry)
				clearField(locator);
			else
				return false;
		}

		return true;
	}

	/**
	 * Method that can be called to select a value from a DropDown based on
	 * index value provided.
	 * 
	 * @param locator
	 *            Identifies the drop down element.
	 * @param index
	 *            The index of the value that needs to be selected.
	 * @return Returns true, if able to select the provided index from the
	 *         provided element in WebPage
	 */
	public Boolean SelectBy(By locator, int index) {
		try {
			select = new Select(driver.findElement(locator));
			select.selectByIndex(index);
		} catch (Exception e) {
			e.printStackTrace();
			retry = handleException(e);
			if (retry)
				SelectBy(locator, index);
			else
				return false;
		}
		return true;
	}

	/**
	 * Method that can be called to select a value from a DropDown based on the
	 * text available in the drop down.
	 * 
	 * @param locator
	 *            Identifies the drop down element.
	 * @param index
	 *            The Text of the value that needs to be selected.
	 * @return Returns true, if able to select the provided Text from the
	 *         provided element in WebPage
	 */
	public Boolean SelectBy(By locator, String visibleText) {
		if (visibleText.equals(""))
			return true;

		try {
			select = new Select(driver.findElement(locator));
			select.selectByVisibleText(visibleText);
		} catch (Exception e) {
			e.printStackTrace();
			retry = handleException(e);
			if (retry)
				SelectBy(locator, visibleText);
			else
				return false;
		}

		return true;
	}

	/**
	 * Method that can be called to wait until an element is available on not
	 * available based of parameter 'visibility'.
	 * 
	 * @param locator
	 *            The visibility of element that needs to be considered for
	 *            waiting.
	 * @param seconds
	 *            Maximum time in seconds, waited for before throwing timeout
	 *            exception.
	 * @param visibility
	 *            True : Wait till element is available, False : Wait till
	 *            element is not available.
	 * @return Returns true, when able to wait for element visibility
	 *         successfully, false if exception is thrown.
	 */
	public Boolean waitFor(By locator, int seconds, Boolean visibility) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);

		try {
			if (visibility) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			} else {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			}
		} catch (Exception e) {
			e.printStackTrace();
			retry = handleException(e);
			if (retry)
				waitFor(locator, seconds, visibility);
			else
				return false;
		}

		return true;
	}

	public By waitForAny(By[] locators) {
		// TODO Complete this function
		String waitElements = getXpath(locators[0]);

		for (int i = 0; i < locators.length; i++) {
			waitElements = waitElements + getXpath(locators[0]);
		}

		return null;
	}

	/**
	 * Method that can be used to wait for passed value of seconds
	 * 
	 * @param seconds
	 *            Seconds that need to be waited for
	 * @return Always return true.
	 */
	public Boolean waitFor(int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
			retry = handleException(e);
			if (retry)
				waitFor(seconds);
			else
				return false;
		}
		return true;
	}

	/**
	 * Method that can be called to get the count of passed Element in the
	 * WebPage.
	 * 
	 * @param locator
	 *            The element that needs to be counted.
	 * @return Returns 0, if the element is not available, else will return the
	 *         count.
	 */
	public int countOf(By locator) {
		int count = 0;

		try {
			count = driver.findElements(locator).size();
		} catch (Exception e) {
			e.printStackTrace();
			retry = handleException(e);
			if (retry)
				countOf(locator);
			else
				return 0;
		}

		return count;
	}

	/***
	 * Method that can be called to get the selected value from a Drop-down.
	 * 
	 * @param locator
	 *            The locator from which the selected value should be retrieved.
	 * @return Returns the selected option as String. Returns '' if the nothing
	 *         is selected or failed to get the value from the locator.
	 */
	public String getSelectedOption(By locator) {
		String option = "";

		try {
			Select select = new Select(driver.findElement(locator));
			option = select.getFirstSelectedOption().getText();
		} catch (Exception e) {
			e.printStackTrace();
			retry = handleException(e);
			if (retry)
				getSelectedOption(locator);
			else
				return "";
		}

		return option;
	}

	/***
	 * Method that can be called to switch to another frame in a web page.
	 * 
	 * @param locator
	 *            The unique locator of the frame where the driver should switch
	 *            to.
	 * @return returns True, if able to switch else false.
	 */
	public Boolean switchToFrame(By locator) {
		try {
			driver.switchTo().frame(driver.findElement(locator));
		} catch (Exception e) {
			e.printStackTrace();
			retry = handleException(e);
			if (retry)
				switchToFrame(locator);
			else
				return false;
		}
		return true;
	}

	/***
	 * Method that is called to switch to default frame in the page.
	 * 
	 * @return returns True, if able to switch else false.
	 */
	public Boolean switchBacktoMain() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
			retry = handleException(e);
			if (retry)
				switchBacktoMain();
			else
				return false;
		}
		return true;
	}

	/***
	 * Method that can be called to take Screenshot of the current page, where
	 * the driver is in.
	 * 
	 * @return Returns the screenshot as a file, and 'null' if not able to take
	 *         screenshot.
	 */
	public File getScreenShot(String filename) {
		screenshotCount = screenshotCount + 1;

		File screenshot = null;
		try {
			screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("Screenshots//" + filename + "_" + screenshotCount + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
			retry = handleException(e);
			if (retry)
				getScreenShot(filename);
			else
				return null;
		}
		return screenshot;
	}

	public String getTestStatus(Boolean passed) {
		return ((passed) ? "Passed" : "Failed");
	}

	/***
	 * Method called to get the xpath from By class object
	 * 
	 * @param locator
	 *            The locator from which xpath needs to be retrieved.
	 * @return The xpath locator as string. Returns "" if nothing found.
	 */
	private String getXpath(By locator) {
		return locator.toString().replace("By.xpath:", "").trim();
	}

	/***
	 * Method called to close current tab.
	 */
	public void closeTab() {
		driver.close();
	}

	/***
	 * Method called to quit current session.
	 */
	public void quit() {
		driver.quit();
	}

	/***
	 * Method that is called to process and exception and take appropriate
	 * action.
	 * 
	 * @param e
	 *            The exception object that is passed, for processing.
	 * @return Returns true, if the step can be retried. Else will return false,
	 *         can can stop execution.
	 */
	private boolean handleException(Exception e) {
		// This code block checks how many times the step is executed. If >
		// retryCount, it will exit stopping execution of step.
		executionCount = executionCount + 1;
		if (executionCount > retryCount) {
			executionCount = 0;
			return false;
		}

		// This snippet will get the Method name where the exception occurred.
		// String errorMethod =
		// (e.getCause().getStackTrace()[0].getMethodName());
		// System.out.println(errorMethod);

		// This code block with get the type of exception occurred and Handle
		// it.
		if (e instanceof StaleElementReferenceException) {
			waitFor(1);
			return true;
		} else if (e instanceof TimeoutException) {
			return false;
		} else if (e instanceof WebDriverException) {
			waitFor(1);
			return true;
		} else {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public void foo(int i) {

	}

	/**
	 * Method that can be called to wait till an element is available or not
	 * available in page.
	 * 
	 * @param locator
	 *            The locator of the element.
	 * @param timeout
	 *            The max wait time.
	 * @param pooling
	 *            The pooling time, will check on every interval based on
	 *            pooling.
	 * @param visilbility
	 *            Indicator check whether to wait till element is available or
	 *            not available. True - Wait till available, False - Wait till
	 *            element not available.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void waitByPolling(By locator, int timeout, int pooling, boolean visilbility) {
		@SuppressWarnings("rawtypes")
		Wait wait = new FluentWait(driver).withTimeout(timeout, TimeUnit.SECONDS)
				.pollingEvery(pooling, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		if (visilbility)
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
		else
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(locator)));
	}
}
