package com.csd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

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

	@FindBy(xpath="//textarea[@class='FormControl']")
	WebElement IncidentsMessageTextArea;

	@FindBy(xpath="//h1[@class='Content-title']")
	WebElement IncidentName;

	@FindBy(xpath="//small[@class='Content-subtitle']")
	WebElement IncidentTimeDetail;




	//Initializing the page objects
	public IncidentDetailsPage(){
		PageFactory.initElements(driver, this);

	}

	//Actions
	public String validateIncidentsDetailsPageTitle(){
		return driver.getTitle();	
	}

	public IncidentsContractsListPage clickonIncidentsContracts(){
		IncidentsContractsTabBtn.click();
		return new IncidentsContractsListPage();
	}

	public void validateIncidentMessageText(){
		
		System.out.println("Messages sent from Incident is: "+IncidentsMessageTextArea.getText());

	}

	public void validateIncidentName(){
		System.out.println("Incident Name and Time details is: "+IncidentName.getText());
	}

	public void validateIncidentTimeDetail(){
		System.out.println(IncidentTimeDetail.getText());
	}


}
