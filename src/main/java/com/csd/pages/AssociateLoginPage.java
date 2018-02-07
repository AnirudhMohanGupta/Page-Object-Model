package com.csd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.csd.base.TestBase;

public class AssociateLoginPage extends TestBase {
	
	//Page-Factory -OR:
	@FindBy(name="authUsername")
	WebElement username;
	
	@FindBy(name="authPassword")
	WebElement password;
	
	@FindBy(xpath=".//*[@id='login']")
	WebElement loginBtn;
	
	
	@FindBy(id="return1")
	WebElement returnToCSDBtn;
	
	//Initializing the page objects
	public AssociateLoginPage(){
		PageFactory.initElements(driver, this);
		
	}
	//Actions
	public String validateAssociateLoginPageTitle(){
		return driver.getTitle();
		
	}
	
	public HomePage login(String un,String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	

}
