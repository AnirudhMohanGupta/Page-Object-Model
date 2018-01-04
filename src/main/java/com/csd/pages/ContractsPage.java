package com.csd.pages;

import java.util.List;

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

	@FindBy(xpath="//table")
	WebElement pagination;

	//Initializing the page objects
	public ContractsPage(){
		PageFactory.initElements(driver, this);
	}

	//Actions

	public String validateContractsPageTitle(){
		return driver.getTitle();

	}
	
	public String validateContractsPageCurrentURL(){
		return driver.getCurrentUrl();
	}

	public boolean verifyContractsLabel(){
		return ContratcsLabel.isDisplayed();	
	}

	public boolean verifySearchBtn(){
		return SearchBtn.isEnabled();
	}

	public boolean verifyNewBtn(){
		return NextPageBtn.isDisplayed();
	}

	public boolean verifyNextPageBtn(){
		return NewBtn.isEnabled();
	}

	public boolean verifySearchFormTextbox(){
		return SearchTextBox.isDisplayed();
	}

	public ShowContractPage selectContractByName(String contractName){

		driver.findElement(By.xpath("//a[contains (text(),'"+contractName+"')]")).click();
		return new ShowContractPage();
	}

	public void verifyPaginationinContractsPage(){

		List<WebElement> sub_links = pagination.findElements(By.tagName("a"));

		// check if pagination link exists

		if (sub_links.size()>0) {

			System.out.println("Pagination Exists and count of pagination links are "+sub_links.size());
		}

		// get Text of pagination link 

		for (WebElement webElement : sub_links) {
			System.out.println(webElement.getText());

		}

	}

	public void searchForContract(String contractName){
		SearchTextBox.sendKeys(contractName);
		GoBtn.click();
	}
	public void clearSearchForContract(){
		SearchTextBox.clear();
		GoBtn.click();
	}
	public void clickonNextBtn(){
		NextPageBtn.click();
	}

}
