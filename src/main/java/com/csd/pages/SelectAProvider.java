package com.csd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.csd.base.TestBase;

public class SelectAProvider extends TestBase {
	
	//Page-Factory -OR:
		@FindBy(xpath="//a[contains (text(),'Associate')]")
		WebElement AssociateBtn;
		
		@FindBy(xpath="//a[contains (text(),'Professional')]")
		WebElement ProfessionalBtn;
		
		//Initializing the Page Objects:
		public SelectAProvider(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions
		
		public AssociateLoginPage selectAssociateProvider(){
			AssociateBtn.click();
			return new AssociateLoginPage();
			
		}

}
