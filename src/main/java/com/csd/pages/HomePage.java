package com.csd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.csd.base.TestBase;

public class HomePage extends TestBase {

	//Page-Factory -OR:
	@FindBy(xpath="//a[contains (text(),'Preferences')]")
	WebElement PreferencesBtn;

	@FindBy(xpath="//a[contains (text(),'Log Out')]")
	WebElement LogOutBtn;

	@FindBy(xpath="//a[contains (text(),'Clients')]")
	WebElement ClientsBtn;

	@FindBy(xpath="//a[contains (text(),'Services')]")
	WebElement ServicesBtn;

	@FindBy(xpath="//a[contains (text(),'Contracts')]")
	WebElement ContractsBtn;

	@FindBy(xpath="//a[contains (text(),'Events')]")
	WebElement EventsBtn;

	@FindBy(xpath="//a[contains (text(),'Incidents')]")
	WebElement IncidentsBtn;

	@FindBy(xpath="//a[contains (text(),'Tags')]")
	WebElement TagsBtn;

	@FindBy(xpath="//th[contains (text(),'Event')]")
	WebElement EventColumn;

	//Initializing the page objects
	public HomePage(){
		PageFactory.initElements(driver, this);


	}
	//Actions
	public String validateHomePageTitle(){
		return driver.getTitle();

	}
	
	public boolean verifyLogOutBtnisDisplayed(){
		return LogOutBtn.isDisplayed();
	}
	
	public ClientsPage clickOnClientsLink() {
		ClientsBtn.click();
		return new ClientsPage();		
	}

	public ServicesPage clickOnServicesLink() {
		ServicesBtn.click();
		return new ServicesPage();		
	}

	public ContractsPage clickOnContractsLink() {
		ContractsBtn.click();
		return new ContractsPage();		
	}

	public EventsPage clickOnEventsLink() {
		EventsBtn.click();
		return new EventsPage();		
	}

	public IncidentsPage clickOnIncidentsLink() {
		IncidentsBtn.click();
		return new IncidentsPage();		
	}

	public TagsPage clickOnTagsLink() {
		TagsBtn.click();
		return new TagsPage();		
	}

}
