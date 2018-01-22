package com.csd;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.csd.base.TestBase;
import com.csd.pages.AssociateLoginPage;
import com.csd.pages.HomePage;
import com.csd.pages.IncidentDetailsPage;
import com.csd.pages.IncidentsPage;
import com.csd.pages.SelectAProvider;

public class CSDIncidentContractPageTest extends TestBase {

	SelectAProvider provider;
	AssociateLoginPage loginpage;
	HomePage homePage;
	IncidentsPage incidentsPage;
	IncidentDetailsPage incidentDetailsPage;

	public CSDIncidentContractPageTest() {
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
		incidentsPage = homePage.clickOnIncidentsLink();
		incidentDetailsPage=incidentsPage.clickonRunningIncident();
		incidentDetailsPage.clickonIncidentsContracts();
	}
	@Test
	public void showIncidentContractsTest(){
		
		incidentDetailsPage.validateNameofSubscriptionContract();
		incidentDetailsPage.viewSubscriptionContractsListImpactedbyIncident();
	}

	@AfterTest
	public void teardown() {
		//driver.quit();
	}

}
