package com.csd;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.csd.base.TestBase;
import com.csd.pages.AssociateLoginPage;
import com.csd.pages.HomePage;
import com.csd.pages.SelectAProvider;

public class CSDHomePageTest extends TestBase {
	SelectAProvider provider;
	AssociateLoginPage loginpage;
	HomePage homePage;
	public CSDHomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		intialization();
		provider = new SelectAProvider();
		loginpage = new AssociateLoginPage();
		provider.selectAssociateProvider();
		//driver.get("https://ag050484:Cerner06@associates.sandboxcerner.com/accounts/login?returnTo=https%3A%2F%2Fcsd.devcernerops.net%2Fauth%2Fopenid%2Flogin%2Fcomplete%3Freferer%3D%252Flogin");
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)

	public void verifyHomePageTitleTest(){

		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "CSD | Clients","Home Page title not matched");

	}

	@Test(priority=2)

	public void verifyLogoutBtnExist(){

		Assert.assertTrue(homePage.verifyLogOutBtnisDisplayed());

	}
	@Test(priority=3)
	public void verifyPreferencesBtnExist(){

		Assert.assertTrue(homePage.verifyPreferencesBtnisDisplayed());

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
