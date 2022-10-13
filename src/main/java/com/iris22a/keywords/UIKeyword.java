package com.iris22a.keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UIKeyword {

	public static RemoteWebDriver driver;

	private static final Logger log = Logger.getLogger(UIKeyword.class);

	public static void openBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {

			ChromeOptions option = new ChromeOptions();
			option.addArguments("-disable-notification", "start-maximized", "--incognito");
			WebDriverManager.chromedriver().setup();
			/*
			 * System.setProperty("webdriver.chrome.driver",
			 * "D:\\Drivers\\chromedriver_win32\\driver.exe");
			 */
			driver = new ChromeDriver(option);
		} else if (browserName.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("-disable-notification", "start-maximized", "--incognito");
			driver = new FirefoxDriver(option);
			System.out.println(browserName + " browser is launcher successfully");
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		}
		System.out.println(browserName + " browser is launched successfully");
		/* log.info(browserName + " browser is launched successfully"); */
	}

	public static void launchUrl(String url) {
		driver.get(url);
		System.out.println("Url is launched: " + url);
		/* log.info("Url is launched: " + url); */
	}

	public static void closeBrowser() {
		driver.close();
		System.out.println("Browser is closed successfully");
		/* log.info("Browser is closed successfully"); */
	}

	public static void switchToWindow(String byTitle) {

		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		String title = driver.getTitle();
		for (String window : windows) {
			if (driver.switchTo().window(window).getTitle().equals(byTitle)) {
				System.out.println("Switched on Window: " + byTitle);
				/* log.info("Switched on Window: " + byTitle); */
				break;
			}
		}
	}

	public static void enterText(By element, String text) {
		driver.findElement(element).sendKeys(text);

	}

	public static void hitButton(int keycode) throws AWTException {

		Robot robo = new Robot();
		robo.keyPress(keycode);
		robo.keyRelease(keycode);
	}

	public static List<String> getTexts(By element) {
		List<WebElement> elements = driver.findElements(element);
		List<String> texts = new ArrayList<String>();
		for (WebElement elmnt : elements) {
			texts.add(elmnt.getText());

		}
		return texts;
	}

	public static void mouseMove(By xpath) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(xpath)).build().perform();
	}

	public static void click(By xpath) {

		driver.findElement(xpath).click();
	}

	public static void click(String locatorType, String locatorValue) {

		/*
		 * if (locatorType.equalsIgnoreCase("xpath")) {
		 * driver.findElement(By.xpath(locatorValue)).click(); } else if
		 * (locatorType.equalsIgnoreCase("id")) {
		 * driver.findElement(By.id(locatorValue)).click(); } else if
		 * (locatorType.equalsIgnoreCase("css")) {
		 * driver.findElement(By.cssSelector(locatorValue)).click(); } else if
		 * (locatorType.equalsIgnoreCase("LinkText")) {
		 * driver.findElement(By.linkText(locatorValue)).click(); } else if
		 * (locatorType.equalsIgnoreCase("partialLinkText")) {
		 * driver.findElement(By.partialLinkText(locatorValue)).click(); } else if
		 * (locatorType.equalsIgnoreCase("class")) {
		 * driver.findElement(By.className(locatorValue)).click(); } else if
		 * (locatorType.equalsIgnoreCase("tagName")) {
		 * driver.findElement(By.tagName(locatorValue)).click(); } else if
		 * (locatorType.equalsIgnoreCase("name")) {
		 * driver.findElement(By.name(locatorValue)).click(); } else {
		 * System.err.println("Invalid locator type: " + locatorType); }
		 */
		getWebElement(locatorType, locatorValue).click();
	}

	public static WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;

		if (locatorType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("LinkText")) {
			element = driver.findElement(By.linkText(locatorValue));
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			element = driver.findElement(By.partialLinkText(locatorValue));
		} else if (locatorType.equalsIgnoreCase("class")) {
			element = driver.findElement(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			element = driver.findElement(By.tagName(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(locatorValue));
		} else {
			System.err.println("Invalid locator type: " + locatorType);
		}
		return element;

	}

	public static List<WebElement> getWebElements(String locatorType, String locatorValue) {
		List<WebElement> elements = null;

		if (locatorType.equalsIgnoreCase("xpath")) {
			elements = driver.findElements(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("id")) {
			elements = driver.findElements(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			elements = driver.findElements(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("LinkText")) {
			elements = driver.findElements(By.linkText(locatorValue));
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			elements = driver.findElements(By.partialLinkText(locatorValue));
		} else if (locatorType.equalsIgnoreCase("class")) {
			elements = driver.findElements(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			elements = driver.findElements(By.tagName(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			elements = driver.findElements(By.name(locatorValue));
		} else {
			System.err.println("Invalid locator type: " + locatorType);
			/* log.error("Invalid locator type: " + locatorType); */
		}
		return elements;
	}

	public static void mouseMove(String locatorType, String locatorValue) {
		Actions actions = new Actions(UIKeyword.driver);
		actions.moveToElement(getWebElement(locatorType, locatorValue)).perform();
	}

	public static List<String> getText(String locatorType, String locatorValue) {
		List<WebElement> elements = getWebElements(locatorType, locatorValue);
		List<String> texts = new ArrayList<String>();
		for (WebElement elmnt : elements) {
			texts.add(elmnt.getText());

		}
		return texts;

	}

	public static void enterText(String locatorType, String locatorValue, String text) {
		// TODO Auto-generated method stub
		getWebElement(locatorType, locatorValue).sendKeys(text);
	}

	public static List<String> getTexts(String locatorType, String locatorValue) {
		// TODO Auto-generated method stub
		getWebElement(locatorType, locatorValue);
		return null;
	}

	public static void mouseMove(WebElement element) {
		Actions actions = new Actions(UIKeyword.driver);
		actions.moveToElement(element).perform();

	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void enterText(WebElement element, String productName) {
		element.sendKeys(productName);
	}
}
