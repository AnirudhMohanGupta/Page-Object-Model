package com.csd.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.csd.base.TestBase;

public class IncidentDetailsPage extends TestBase {

	//Page-Factory -OR:

	@FindBy(xpath="(//a[contains(text(),'Contracts')])[2]")
	WebElement IncidentsContractsTabBtn;

	@FindBy(xpath="//a[@class='TabsLink'][contains (text(),'History')]")
	WebElement IncidentsHistoryTabBtn;

	@FindBy(xpath="//a[@class='TabsLink'][contains (text(),'Edit')]")
	WebElement IncidentsEditTabBtn;

	@FindBy(xpath="//a[@class='TabsLink TabsLink--active'][contains (text(),'Message')]")
	WebElement IncidentsMessageTabBtn;

	@FindBy(xpath="//div[@class='CardHeader']")
	WebElement NameofSubscriptionContract;

	@FindBy(xpath="//ul[@class='ListGroup ListGroup--flush']/descendant::div[@class='Subtext']")
	List<WebElement> ContractsList;

	//Actions
	public String validateIncidentsDetailsPageTitle(){
		return driver.getTitle();	
	}

	public IncidentsContractsListPage clickonIncidentsContracts(){
		IncidentsContractsTabBtn.click();
		return new IncidentsContractsListPage();
	}

	public void validateNameofSubscriptionContract(){

		NameofSubscriptionContract.getText();	
	}

	public void viewSubscriptionContractsListImpactedbyIncident(){


		// check Subscription's Contracts impacted by Incident

		if (ContractsList.size()>0) {

			System.out.println("Subscription's Contracts impacted by this Incident are "+ ContractsList.size());
		}

		// get list of contractsList

		for (WebElement webElement : ContractsList) {
			System.out.println(webElement.getText());

		}
	}

}
