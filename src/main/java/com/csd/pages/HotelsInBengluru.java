package com.csd.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

import com.csd.base.TestBase;
import com.csd.testcases.FirstTenHotelsTest;

public class HotelsInBengluru extends TestBase {
	
	Logger log = LogManager.getLogger(HotelsInBengluru.class);

	//Page-Factory -OR:
	@FindBy(xpath="(//a[contains(text(),'Price')])[2]")
	WebElement PriceField;

	@FindBy(xpath="//a[contains(text(),'Price (high to low)')]")
	WebElement PriceHightoLowOption;

	@FindBy(id="f-popular-527")
	WebElement FreeWifiOption;

	@FindBy(xpath="//h3[@class='p-name']/a")
	List<WebElement> ListofHotels;


	@FindBy(xpath="//div[@class='price']")
	List<WebElement> PriceofHotels;

	@FindBy(xpath=".//*[@id='listings']/ol/li/article/div//a/b")
	List<WebElement> PriceofHotelsWithoutPricecut;

	//Initializing the page objects
	public HotelsInBengluru(){
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String validateHomePageTitle(){
		return driver.getTitle();

	}
	public void setPriceField(){

		Actions action = new Actions(driver);
		action.moveToElement(PriceField);
		PriceField.click();
		PriceHightoLowOption.click();

	}

	public void enableFreeWifiOption(){

		FreeWifiOption.click();
	}

	public void viewListofHotels(){


		// check size displayed 

		if (ListofHotels.size()>0) {

			System.out.println("List of Hotels Displayed is "+ ListofHotels.size());
		}

		// get ListofHotels

		//		for (int i = 0; i < 10; i++) {
		//			System.out.println(ListofHotels.get(i).getText());
		//			((JavascriptExecutor)driver).executeScript("scroll(0,800)");
		//			break;
		//		}


		for (WebElement webElement : ListofHotels) {
			System.out.println(webElement.getText());
			log.info(webElement.getText());
		}

	}

	public void ListPriceofHotels(){


		for (WebElement webElement : PriceofHotels) {
			System.out.println(webElement.getText());
			log.info(webElement.getText());
		}

	}


}
