package com.csd;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.csd.base.TestBase;
import com.csd.pages.AssociateLoginPage;
import com.csd.pages.ContractsPage;
import com.csd.pages.HomePage;
import com.csd.pages.SelectAProvider;

public class CSDContractsPageTest extends TestBase {
	
	SelectAProvider provider;
	AssociateLoginPage loginpage;
	HomePage homePage;
	ContractsPage contractsPage;

	public CSDContractsPageTest() {
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
		contractsPage = homePage.clickOnContractsLink();
	}
	
	@Test(priority=1)
	
	public void verifyContractsPageLabel(){
		Assert.assertTrue(contractsPage.verifyContractsLabel(),"Contracts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectContractTest(){
		contractsPage.selectContractByName("11111");
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
