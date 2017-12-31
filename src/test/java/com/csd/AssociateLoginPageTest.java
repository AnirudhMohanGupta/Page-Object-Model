package com.csd;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.csd.base.TestBase;
import com.csd.pages.AssociateLoginPage;
import com.csd.pages.HomePage;
import com.csd.pages.SelectAProvider;

public class AssociateLoginPageTest extends TestBase {
	SelectAProvider provider;
	AssociateLoginPage loginpage;
	HomePage homePage;

	public AssociateLoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		intialization();
		provider = new SelectAProvider();
		loginpage = new AssociateLoginPage();

	}

	@Test(priority = 1)
	public void associateLoginPageTitleTest() {
		provider.selectAssociateProvider();
		String title = loginpage.validateAssociateLoginPageTitle();
		assertEquals(title,"Cerner Associate (Sandbox) - Log In");
	}

	@Test(priority = 2)
	public void loginTest() {
		provider.selectAssociateProvider();
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
