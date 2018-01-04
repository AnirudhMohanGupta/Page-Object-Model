package com.csd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.csd.base.TestBase;

public class PreferencesClients extends TestBase {

	//Page-Factory -OR:
	@FindBy(xpath="//small")
	WebElement AssociateIDLink;

	@FindBy(xpath="//a[contains (text(),'Edit')]")
	WebElement EditBtn;

	@FindBy(xpath="//a[contains (text(),'Contact Methods')]")
	WebElement ContactMethodBtn;

	@FindBy(xpath="//ul/li[3]/a[contains (text(),'Clients')]")
	WebElement ClientsBtn;

	@FindBy(xpath="//ul/li[4]/a[contains (text(),'Services')]")
	WebElement ServicesBtn;

	@FindBy(xpath="//a[contains (text(),'API Tokens')]")
	WebElement APITokenBtn;

	@FindBy(xpath="//select[@name='home']")
	Select HomeSelect;

	@FindBy(xpath="//select[@name='tz']")
	Select TimeZoneSelect;

	@FindBy(xpath="//button[contains (text(),'Submit')]")
	WebElement SubmitBtn;

	@FindBy(xpath="//input[@name='q']")
	WebElement CleintSearchForm;

	@FindBy(xpath="//div[@class='SubscriptionsTable-footer']")
	WebElement SubscriptionsTableText;

	@FindBy(xpath="//button[contains (text(),'Subscribe all')]")
	WebElement SubscribeAllBtn;

	@FindBy(xpath="//button[contains (text(),'Unsubscribe all')]")
	WebElement UnSubscribeAllBtn;	

	//Initializing the page objects
	public PreferencesClients(){
		PageFactory.initElements(driver, this);			
	}

	//Actions
	public String validateAssociateLoginPageTitle(){
		return driver.getTitle();	
	}

	public String validateAssociateIDText(){
		return AssociateIDLink.getText();
	}

	public void clickonPreferncesClientsBtn(){
		ClientsBtn.click();
	}








}
