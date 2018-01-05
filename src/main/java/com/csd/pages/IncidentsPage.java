package com.csd.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.csd.base.TestBase;

public class IncidentsPage extends TestBase {
	
	//Page-Factory -OR:
		@FindBy(xpath="//a[contains (text(),'Search')]")
		WebElement SearchBtn;
		
		@FindBy(xpath="//a[contains (text(),'New')]")
		WebElement NewBtn;
		
		@FindBy(xpath="//input[@name='q']")
		WebElement IncidentSearchForm;
		
		@FindBy(xpath="//button[contains (text(),'Go')]")
		WebElement GoBtn;
		
		@FindBy(xpath="//input[@name='name']")
		WebElement IncidentNameField;
		
		@FindBy(xpath="//input[@name='startedAt']")
		WebElement IncidentStartField;
		
		@FindBy(xpath="//button[contains (text(),'Now')]")
		WebElement NowBtn;
		
		@FindBy(xpath="//button[contains (text(),'Clear')]")
		WebElement ClearBtn;
		
		@FindBy(xpath="//div/div/button[3]")
		WebElement DateTimeInputBtn;
		
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
		public IncidentsPage(){
			PageFactory.initElements(driver, this);			
		}

		//Actions
		public String validateIncidentsPageTitle(){
			return driver.getTitle();	
		}
		
		public void clickonNewIncidentBtn(){
			NewBtn.click();
		}
		
		public void createNewIncident(String IncName,String contractName ){
			
			IncidentNameField.sendKeys(IncName);
			NowBtn.click();
			ContractNameForm.sendKeys(contractName + Keys.ENTER);
			
			SubmitBtn.click();
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		


}
