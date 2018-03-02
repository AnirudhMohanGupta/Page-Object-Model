package com.csd.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.csd.base.TestBase;

public class HomePage extends TestBase {

	//Page-Factory -OR:
	@FindBy(xpath=".//*[@id='qf-0q-destination']")
	WebElement DestinationField;

	@FindBy(xpath=".//*[@id='qf-0q-localised-check-in']")
	WebElement CheckInDateField;

	@FindBy(xpath=".//*[@id='qf-0q-localised-check-out']")
	WebElement CheckOutDateField;

	@FindBy(xpath=".//*[@id='widget-query-label-1']")
	WebElement CheckInDateWidget;

	@FindBy(xpath=".//*[@id='widget-query-label-3']")
	WebElement ContractsBtn;

	@FindBy(xpath="//div[2]/div/button[2]")
	WebElement NextMonthBtn;

	@FindBy(xpath="//button[@class='widget-overlay-close']")
	WebElement CloseBtn;

	@FindBy(xpath="//button[contains(text(),'Search')]")
	WebElement SearchBtn;

	@FindBy(xpath="//a[contains (text(),'Tags')]")
	WebElement TagsBtn;

	@FindBy(xpath="//th[contains (text(),'Event')]")
	WebElement EventColumn;

	@FindBy(xpath="//a[contains(text(),'1')]")
	WebElement DateSelection;
	
	@FindBy(xpath="//div[@class='autosuggest-category-result']")
	List<WebElement> results;

	//Initializing the page objects
	public HomePage(){
		PageFactory.initElements(driver, this);


	}
	//Actions
	public String validateHomePageTitle(){
		return driver.getTitle();

	}

	public void setBangaloreonDestinationField() throws InterruptedException {

		String searchingText = "Bengaluru, India";
		String partialText = "Bengaluru";

		DestinationField.sendKeys(partialText);
		Thread.sleep(3000);
		int size = results.size();

		System.out.println("The size of the list is: " + size);

		for (int i = 0; i < size; i++) {
			System.out.println(results.get(i).getText());
		}

		//Thread.sleep(3000);
		for (WebElement result : results) {
			if (result.getText().equals(searchingText)) {
				result.click();
				System.out.println("Selected: " + result.getText());
				break;
			}
		}

	}

	public void setDate3MonthsfromCurrentDate() throws InterruptedException{
		String selectdate= "07/01/2018";
		Date d =new Date(selectdate);
		SimpleDateFormat dt = new SimpleDateFormat("MMMM/dd/yyyy");
		String date=dt.format(d);
		System.out.println(date);
		String[] split = date.split("/");
		System.out.println(split[0]+" "+split[1]+" "+split[2]);

		String Month =split[0]+" "+split[2];
		System.out.println("month--------"+Month);

		CheckInDateWidget.click();

		Thread.sleep(2000);
		//*[contains(text(),'May 2018')]

		while(true){

			try {
				driver.findElement(By.xpath("//*[contains(text(),'"+Month+"')]")).isDisplayed();
				Thread.sleep(2000);
				DateSelection.click();
				SearchBtn.click();
				break;

			} catch (Exception e) {
				// TODO: handle exception
				NextMonthBtn.click();
				Thread.sleep(2000);
			}
		}
	}
}


