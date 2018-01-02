package com.csd;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
