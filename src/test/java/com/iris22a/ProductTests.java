package com.iris22a;

import java.awt.AWTException;

import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iris22a.config.TestBase;
import com.iris22a.keywords.UIKeyword;
import com.iris22a.pages.CasualShirtsPage;
import com.iris22a.pages.HomePage;
import com.iris22a.util.Environment;
import com.iris22a.util.PropUtil;
import com.iris22a.util.WaitFor;

public class ProductTests extends TestBase {
	/*public class ProductTests extends TestBase {*/
	@Test
	public void VerifySearchResultForPoloMen() throws AWTException, FileNotFoundException {

		PropUtil repo = new PropUtil();
		UIKeyword.launchUrl(Environment.URL);
		/*
		 * Environment env=new Environment(); UIKeyword.launchUrl(env.getAppUrl());
		 */
		/* UIKeyword.launchUrl(repo.getValue(filePath, key)); */
		/* UIKeyword.launchUrl("https://www.myntra.com/"); */
		/*
		 * UIKeyword.enterText(By.
		 * xpath("//input[@placeholder=\"Search for products, brands and more\"]"
		 * ),"polo men");
		 */
		UIKeyword.enterText(repo.getLocator("search_products_txtBx")[0],repo.getLocator("search_products_txtBx")[0], "polo men");
		UIKeyword.hitButton(KeyEvent.VK_ENTER);
		List<String> productTitles = UIKeyword.getTexts(repo.getLocator("product_titles_txt")[0],repo.getLocator("product_titles_txt")[1]);
		for (String productTitle : productTitles) {
			Assert.assertTrue(productTitle.contains("Polo"), "Product title doesn't dontains polo: " + productTitle);

		}
	}

	public void verifyCategoryListForTopWears() throws FileNotFoundException {
		List<String> expected=new ArrayList<String>();
		expected.add("Tshirts");
		expected.add("shirts");
		expected.add("Sweatshirts");
		expected.add("Kurtas");
		expected.add("Jackets");
		expected.add("Sweaters");
		expected.add("Blazers");
		PropUtil repo = new PropUtil();
		UIKeyword.launchUrl(Environment.URL);
	/*	UIKeyword.mouseMove(By.xpath(repo.getLocator("men_menu")));*/
		UIKeyword.mouseMove(repo.getLocator("men_menu")[0],repo.getLocator("men_menu")[1]);
		UIKeyword.click(repo.getLocator("men_topwear")[0],repo.getLocator("men_topwear")[1]);
		WaitFor.elementtoBePresent(repo.getLocator("categories_text")[0],repo.getLocator("categories_text")[1]);
		List<String> actualCategories = UIKeyword.getTexts(repo.getLocator("categories_text")[0],repo.getLocator("categories_text")[1]);
		for(int i=0;i<actualCategories.size();i++)
		{
			actualCategories.add(i,actualCategories.get(i).split("(")[0]);
		}
		Assert.assertTrue(actualCategories.containsAll(expected),"List didn't match: expected:"+expected+"\n Actual:"+actualCategories);
	}
	
	@Test
	public void verifyItemCountOfCasualShirts() {
		UIKeyword.launchUrl(Environment.URL);
		HomePage home=new HomePage();
		home.hoverOnMenMenu();
		home.clickOnCasualShrts();
		CasualShirtsPage casual= new CasualShirtsPage();
		int itemCount=casual.getItemCount();
		System.out.println(itemCount);
		
		
	}

}
