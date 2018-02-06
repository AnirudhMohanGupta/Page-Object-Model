package com.csd.testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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

	@BeforeTest
	public void setup() throws IOException {
		intialization();
		provider = new SelectAProvider();
		loginpage = new AssociateLoginPage();
		provider.selectAssociateProvider();
		
		Runtime.getRuntime().exec("C:/Users/AG050484/Desktop/HandleAuthenticationWindow.exe");
		

		//driver.navigate().to("https://ag050484:Cerner06@associates.sandboxcerner.com/accounts/login?returnTo=https%3A%2F%2Fcsd.devcernerops.net%2Fauth%2Fopenid%2Flogin%2Fcomplete%3Freferer%3D%252Flogin");
	
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

	@AfterTest
	public void teardown() {
		//driver.quit();
	}
}
