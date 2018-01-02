package com.csd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.csd.base.TestBase;

public class ContractsPage extends TestBase {
	
	//Page-Factory -OR:

	@FindBy(xpath="//h1[contains (text(),'Contracts')]")
	WebElement ContratcsLabel;

	@FindBy(xpath="//a[contains (text(),'Search')]")
	WebElement SearchBtn;
	
	@FindBy(xpath="//a[contains (text(),'New')]")
	WebElement NewBtn;
	
	@FindBy(xpath="//a[contains (text(),'Next Page')]")
	WebElement NextPageBtn;
	
	@FindBy(xpath="//form/input")
	WebElement SearchTextBox;
	
	@FindBy(xpath="//button[contains (text(),'Go')]")
	WebElement GoBtn;

	//Initializing the page objects
	public ContractsPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions

	public boolean verifyContractsLabel(){
		return ContratcsLabel.isDisplayed();	
	}

	public void selectContractByName(String contractName){

		driver.findElement(By.xpath("//a[contains (text(),'"+contractName+"')]")).click();
	}

}
