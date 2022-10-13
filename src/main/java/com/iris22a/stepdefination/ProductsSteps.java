package com.iris22a.stepdefination;

import java.awt.AWTException;
import java.util.List;

import org.testng.Assert;

import com.iris22a.keywords.UIKeyword;
import com.iris22a.pages.HomePage;
import com.iris22a.pages.MenTshirtsPage;
import com.iris22a.util.Environment;
import com.iris22a.util.WaitFor;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsSteps {
	/*
	 * @Given("Open the chrome browser") public void m1() {
	 * UIKeyword.openBrowser("chrome"); }
	 */
	@And("launch the url")
	public void launchMytraUrl() {
		UIKeyword.launchUrl(Environment.URL);
	}

	@When("user searches for polo shirt")
	public void searchPoloTShirts() throws AWTException {
		HomePage home = new HomePage();
		home.searchProduct("Polo");

	}

	@Then("all results should be ralated to polo")
	public void verifyAllResults() {
		HomePage home = new HomePage();
		List<String> productTexts = home.getSearchResultTexts();
		for (String text : productTexts) {
			Assert.assertTrue(text.toLowerCase().contains("polo"), "Product is mismatch: " + text);
		}
	}

	@When("user hovers on men menue")
	public void hoverOnMenMenu() {
		HomePage home = new HomePage();
		home.hoverOnMenMenu();

	}

	@Then("user clicks on men T-shirt")
	public void clickOnMenTshirt1() {
		HomePage home = new HomePage();
		WaitFor.elemenToBeClickable(home.menTshirt);
		home.ClickOnMenTshirt();
	}

	@Then("user selects popularity filter")
	public void PopularityFilter() {
		MenTshirtsPage menTshirt = new MenTshirtsPage();
		WaitFor.elemenToBeClickable(menTshirt.sortByFilter);
		menTshirt.selectPopularityFilter();
	}

}
