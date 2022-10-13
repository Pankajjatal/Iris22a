package com.iris22a.pages;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.iris22a.keywords.UIKeyword;

public class HomePage {

	private static final Logger log = Logger.getLogger(HomePage.class);
	// PageFactory
	@CacheLookup
	@FindBy(xpath = "//div[@class='desktop-navLink']/a[@href=\\\"/shop/men\\\"]")

	public WebElement menMenu;
	@FindBy(xpath = "//a[@href=/men-tshirts']")
	public WebElement menTshirt;
	@FindBy(xpath = "(//li@class='desktop-oddColumnContent'])[1]/descendant::a[contains(text(),'Casual')]")
	public WebElement CasualShirts;
	@FindBy(css = "div.desktop-query>input.desktop-SearchBar")
	public WebElement searchComponent;
	@FindBy(css = "h3.product-brand")
	public List<WebElement> productTexts;

	public HomePage() {
		PageFactory.initElements(UIKeyword.driver, this);
	}

	/*
	 * public HomePage() { menMenu=UIKeyword.driver.findElement(By.xpath(
	 * "//div[@class='desktop-navLink']/a[@href="/shop/men"]");
	 * menTshirt=UIKeyword.driver.findElement(By.xpath("//a[@href=\"/men-tshirts\"]"
	 * )); }
	 */

	public void hoverOnMenMenu() {

		UIKeyword.mouseMove(menMenu);
	}

	public void ClickOnMenTshirt() {
		UIKeyword.click(menTshirt);
	}

	public void searchProduct(String ProductName) throws AWTException {
		UIKeyword.enterText(searchComponent, ProductName);
		UIKeyword.hitButton(KeyEvent.VK_ENTER);

	}

	public void clickOnCasualShrts() {
		CasualShirts.click();
		System.out.println("Clicked on Casual Shirts");
		// log.info("Clicked on Casual Shirts");
	}

	public List<String> getSearchResultTexts() {

		List<String> productTexts = new ArrayList<String>();

		for (WebElement product : this.productTexts) {
			productTexts.add(product.getText());
		}
		return productTexts;
	}

	


	

}