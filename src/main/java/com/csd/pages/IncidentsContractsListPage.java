package com.csd.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.csd.base.TestBase;

public class IncidentsContractsListPage extends TestBase {

	//Page-Factory -OR:

	@FindBy(xpath="//div[@class='CardHeader']")
	WebElement NameofSubscriptionContract;

	@FindBy(xpath="//ul[@class='ListGroup ListGroup--flush']/descendant::div[@class='Subtext']")
	List<WebElement> ContractsList;
	
	//Initializing the page objects
	public IncidentsContractsListPage(){
		PageFactory.initElements(driver, this);

	}

	//Actions
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
