package com.iris22a.config;

import org.apache.commons.exec.environment.EnvironmentUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.iris22a.keywords.UIKeyword;
import com.iris22a.util.Environment;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestBase {

	public WebDriver driver;
	public ThreadLocal<WebDriver> thread = new ThreadLocal<WebDriver>();
	// private static final Logger log=Logger.getLogger(TestBase.class);

	/* @Parameters("browser-name") */
	/* @BeforeMethod */
	/* public void setUp(@Optional String browserName) throws Exception { */

	@Before
	// @BeforeMethod
	public void setUp() throws Exception {
		String brwsName = System.getProperty("browserName");
		String browserName = Environment.BROWSER;
		if (browserName == null) {
			browserName = "chrome";
		}
		if (browserName.isEmpty()) {
			browserName = "chrome";
			System.out.println("Setting default browser as chrome");
			/* log.info("Setting default browser as chrome"); */
		}
		// UIKeyword.openBrowser(browserName);
		this.driver = UIKeyword.openBrowser(browserName);
		thread.set(this.driver);
	}

	// @After
	@AfterMethod
	public void tearDownMethod() throws Exception {
		// UIKeyword.closeBrowser();
		thread.get().close();
		/* log.info("Browser is closed successfully"); */
	}
}
