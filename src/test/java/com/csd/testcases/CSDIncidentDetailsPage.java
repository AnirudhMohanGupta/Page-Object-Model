/* @author:AG050484
 * 
GET /incidents/:id
As a User,
When I visit the show Incident page,
Then I see all Messages sent from that Incident to any of my Subscription's Contracts.
 * 
 */

package com.csd.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.csd.base.TestBase;
import com.csd.pages.AssociateLoginPage;
import com.csd.pages.HomePage;
import com.csd.pages.IncidentDetailsPage;
import com.csd.pages.IncidentsPage;
import com.csd.pages.SelectAProvider;

public class CSDIncidentDetailsPage extends TestBase {

	SelectAProvider provider;
	AssociateLoginPage loginpage;
	HomePage homePage;
	IncidentsPage incidentsPage;
	IncidentDetailsPage incidentDetailsPage;


	public CSDIncidentDetailsPage() {
		super();
	}

	@BeforeTest
	public void setup() {
		intialization();
		provider = new SelectAProvider();
		loginpage = new AssociateLoginPage();
		incidentsPage =new IncidentsPage();
		incidentDetailsPage =new IncidentDetailsPage();
		provider.selectAssociateProvider();
		//driver.get("https://ag050484:Cerner06@associates.sandboxcerner.com/accounts/login?returnTo=https%3A%2F%2Fcsd.devcernerops.net%2Fauth%2Fopenid%2Flogin%2Fcomplete%3Freferer%3D%252Flogin");
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		incidentsPage = homePage.clickOnIncidentsLink();
		incidentDetailsPage=incidentsPage.clickonRunningIncident();
	}
	@Test
	public void showMessageSentFromIncidentTest(){

		incidentDetailsPage.validateIncidentMessageText();

	}
	@Test
	public void showIncidentNameandTimeTest(){

		incidentDetailsPage.validateIncidentName();

	}
	

	@AfterTest
	public void teardown() {
		//driver.quit();
	}


}
