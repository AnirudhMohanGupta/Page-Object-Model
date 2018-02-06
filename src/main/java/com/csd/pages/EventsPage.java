package com.csd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.csd.base.TestBase;

public class EventsPage extends TestBase {
	
	//Page-Factory -OR:
		@FindBy(xpath="//a[contains (text(),'Search')]")
		WebElement SearchBtn;

		@FindBy(xpath="//a[contains (text(),'New')]")
		WebElement NewBtn;
		
		@FindBy(xpath="//input[@name='q']")
		WebElement EventSearchForm;
		
		@FindBy(xpath="//button[contains (text(),'Go')]")
		WebElement GoBtn;
		
		@FindBy(xpath="//a[@class='Anchor']")
		WebElement RunningEventBtn;
		
		//Initializing the page objects
		public EventsPage(){
			PageFactory.initElements(driver, this);			
		}

		//Actions
		public String validateIncidentsPageTitle(){
			return driver.getTitle();	
		}

		public NewEventPage clickonNewEventBtn(){
			NewBtn.click();
			return new NewEventPage();
		}


}
