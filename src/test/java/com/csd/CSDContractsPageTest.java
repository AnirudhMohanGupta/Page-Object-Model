package com.csd;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.csd.base.TestBase;
import com.csd.pages.AssociateLoginPage;
import com.csd.pages.ContractsPage;
import com.csd.pages.HomePage;
import com.csd.pages.SelectAProvider;
import com.csd.pages.ShowContractPage;

public class CSDContractsPageTest extends TestBase {

	SelectAProvider provider;
	AssociateLoginPage loginpage;
	HomePage homePage;
	ContractsPage contractsPage;
	ShowContractPage showContractPage;

	public CSDContractsPageTest() {
		super();
	}

	@BeforeTest
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

	public void verifyHomePageTitleTest(){

		String ContractPageTitle = contractsPage.validateContractsPageTitle();
		Assert.assertEquals(ContractPageTitle, "CSD | Contracts","Home Page title not matched");

	}

	@Test(priority=1)

	public void verifyContractsPageLabel(){
		Assert.assertTrue(contractsPage.verifyContractsLabel(),"Contracts label is missing on the page");
	}

	@Test(priority=2)

	public void verifySearchBtnTest(){
		Assert.assertTrue(contractsPage.verifySearchBtn(),"Search Button is missing on the page");
	}

	@Test(priority=3)

	public void verifyNewBtnTest(){
		Assert.assertTrue(contractsPage.verifyNewBtn(),"New Button is missing on the page");
	}

	@Test(priority=4)

	public void verifyNextPageBtnTest(){
		Assert.assertTrue(contractsPage.verifyNextPageBtn(),"Next Page Button is missing on the page");
	}

	@Test(priority=5)

	public void verifySearchFormTextboxTest(){
		Assert.assertTrue(contractsPage.verifySearchFormTextbox(),"Search form is missing on the page");
	}
	@Test(priority=6)
	public void selectContractTest(){
		showContractPage=contractsPage.selectContractByName("11111");	
	}

	//	As an Associate,
	//	When I visit the admin Contracts page,
	//	And search for a Contract,
	//	Then it filters the paginated list of Contracts by my search term.

	@Test(priority=7)

	public void searchContractTest(){
		homePage.clickOnContractsLink();
		contractsPage.searchForContract("22");
		contractsPage.verifyPaginationinContractsPage();


		//		As an Associate,
		//		When I visit the admin Contracts page,
		//		And search for a Contract,
		//		And clear the search,
		//		Then it removes the filter from the paginated list of Contracts.

	}
	@Test(priority=8)
	public void clearSearchTest(){

		contractsPage.clearSearchForContract();
		contractsPage.verifyPaginationinContractsPage();
	}

	//	As an Associate,
	//	When I visit the admin Contracts page,
	//	And choose to load the next page,
	//	Then it reloads the page,
	//	And the list of paginted Contracts is the next page of Contracts.
	
	@Test(priority=9)
	public void clickNextPageBtninContractspageTest(){

		homePage.clickOnContractsLink();
		contractsPage.clickonNextBtn();
		Assert.assertEquals(contractsPage.validateContractsPageCurrentURL(), "https://csd.devcernerops.net/admin/contracts?page=2","Current URL not matched");	
	}


	@AfterTest
	public void teardown() {
		//driver.quit();
	}

}
