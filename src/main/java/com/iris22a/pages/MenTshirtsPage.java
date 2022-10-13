package com.iris22a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iris22a.keywords.UIKeyword;

public class MenTshirtsPage {
	
	@FindBy(xpath="//div[@class='sort-sortBy']")
	public WebElement sortByFilter;
	@FindBy(xpath="//h4[contains(text(),'Country of Origin')]")
	public WebElement countryOrigin;
	@FindBy(xpath="//div[@class='sort=sortBy']/span[contains(text(),'popularti')]")
	public WebElement popularityFilter;
	
	public MenTshirtsPage() {
		PageFactory.initElements(UIKeyword.driver, this);
	}

/*	public MenTshirtsPage() {
		sortByFilter = UIKeyword.driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		countryOrigin = UIKeyword.driver.findElement(By.xpath("//h4[contains(text(),'Country of Origin')]"));
		popularityFilter = UIKeyword.driver.findElement(By.xpath("//div[@class='sort=sortBy']/span[contains(text(),'popularti')]"));

	}*/

	public void clickOnSortByFilter() {

		sortByFilter.click();
	}

	public void selectPopularityFilter() {
		UIKeyword.mouseMove(sortByFilter);
		UIKeyword.click(popularityFilter);
	}

	public void selectWhatsNewFilter() {

	}
	

	public void selectBetterDiscountFilter() {

	}

}
