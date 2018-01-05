package com.csd.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

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

	public void enteronCleintSearchForm(String clientName){

		CleintSearchForm.sendKeys(clientName + Keys.ENTER);
	

		try {
			WebElement autoOptions = driver.findElement(By.xpath("/div/datalist/option"));

			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("option"));
			for(WebElement option : optionsToSelect){
				if(option.getText().equals(clientName)) {
					System.out.println("Trying to select: "+clientName);
					option.click();
					break;
				}
			}

		} catch (NoSuchElementException e) {
			System.out.println("Exception Occured 1"+e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println("Exception Occured 2"+e.getStackTrace());
		}
	}

}

