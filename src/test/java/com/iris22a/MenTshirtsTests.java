package com.iris22a;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.iris22a.config.TestBase;
import com.iris22a.keywords.UIKeyword;
import com.iris22a.pages.HomePage;
import com.iris22a.pages.MenTshirtsPage;
import com.iris22a.util.Environment;
import com.iris22a.util.WaitFor;

/*public class MenTshirtsTests extends TestBase {*/
	public class MenTshirtsTests{
	/*UIKeyword keyword = new UIKeyword();*/

	@Test
	public void verifySearchByPopularityYeildsProperResults(){

		UIKeyword.launchUrl(Environment.URL);
		/*HomePage home = new HomePage();*/
		/*HomePage home=PageFactory.initElements(UIKeyword.driver,HomePage.class);*/
		HomePage home=new HomePage();
		/*WaitFor.time(4);*/
		
		home.hoverOnMenMenu();
		WaitFor.elemenToBeClickable(home.menTshirt);
		home.ClickOnMenTshirt();
		
		/*MenTshirtsPage menTshirt=new MenTshirtsPage();*/
		/*MenTshirtsPage menTshirt=PageFactory.initElements(UIKeyword.driver, MenTshirtsPage.class);*/
		MenTshirtsPage menTshirt=new MenTshirtsPage();
		WaitFor.elemenToBeClickable(menTshirt.sortByFilter);
		menTshirt.selectPopularityFilter();

	}

}
