package com.csd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.csd.base.TestBase;

public class NewEventPage extends TestBase {
	
	//Page-Factory -OR:
	
	@FindBy(xpath="//input[@name='name']")
	WebElement EventNameField;

	@FindBy(xpath="//input[@name='url']")
	WebElement EventURLField;
	
	@FindBy(xpath="//textarea[@name='description']")
	WebElement EventDescription;
	
	@FindBy(xpath="//input[@name='displayStartedAt']")
	WebElement EventStartDisplayField;

	@FindBy(xpath="(//button[@type='button'])[1]")
	WebElement EventStartDisplayNowBtn;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement EventStartDisplayClearBtn;
	
	@FindBy(xpath="(//button[@type='button'])[3]")
	WebElement EventStartDisplayCalenderBtn;
	
	@FindBy(xpath="(//button[@type='button'])[4]")
	WebElement EventStopDisplayNowBtn;
	
	@FindBy(xpath="(//button[@type='button'])[5]")
	WebElement EventStopDisplayClearBtn;
	
	@FindBy(xpath="(//button[@type='button'])[6]")
	WebElement EventStopDisplayCalenderBtn;
	
	@FindBy(xpath="(//button[@type='button'])[7]")
	WebElement EventStartNowBtn;
	
	@FindBy(xpath="(//button[@type='button'])[8]")
	WebElement EventStartClearBtn;
	
	@FindBy(xpath="(//button[@type='button'])[9]")
	WebElement EventStartCalenderBtn;

	@FindBy(xpath="//input[@name='displayEndedAt']")
	WebElement EventEndDisplayField;
	
	@FindBy(xpath="//input[@name='startedAt']")
	WebElement EventstartedAtField;
	
	@FindBy(xpath="//input[@name='q']")
	WebElement ContractNameForm;
	
	@FindBy(xpath="//input[@value='service[name]']")
	WebElement SearchByServiceNameCheckBox;

	@FindBy(xpath="//input[@value='client[mnemonic]']")
	WebElement SearchByClientMnemonicCheckBox;

	@FindBy(xpath="//input[@value='tag[name]']")
	WebElement SearchByTagNameCheckBox;

	@FindBy(xpath="//input[@value='service']")
	WebElement GroupResultsByServiceCheckBox;

	@FindBy(xpath="//input[@value='client']")
	WebElement GroupResultsByClientCheckBox;

	@FindBy(xpath="//button[contains (text(),'Submit')]")
	WebElement SubmitBtn;
	
	
	//Initializing the page objects
		public NewEventPage(){
			PageFactory.initElements(driver, this);			
		}

		//Actions
		public String validateNewEventPageTitle(){
			return driver.getTitle();	
		}
		
		public void createNewEvent(String EventName,String EventURL,String Description,String ContractsName){
			
			
			
			
			
			
		}



}
