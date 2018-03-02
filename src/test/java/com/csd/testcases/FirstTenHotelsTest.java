package com.csd.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.csd.base.TestBase;
import com.csd.pages.HomePage;
import com.csd.pages.HotelsInBengluru;

public class FirstTenHotelsTest extends TestBase {

	HomePage homePage;
	HotelsInBengluru hotelsInBengluru;
	
	Logger log = LogManager.getLogger(FirstTenHotelsTest.class);
	
	

	public FirstTenHotelsTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		intialization();
		homePage =new HomePage();
		hotelsInBengluru =new HotelsInBengluru();
		

	}

	@Test
	public void viewFirstTenHotelsTest() throws InterruptedException{

		homePage.setBangaloreonDestinationField();
		homePage.setDate3MonthsfromCurrentDate();
		hotelsInBengluru.enableFreeWifiOption();
		hotelsInBengluru.setPriceField();
		Thread.sleep(5000);
		hotelsInBengluru.viewListofHotels();
		hotelsInBengluru.ListPriceofHotels();
		
		//Store the name of the hotels, along with their prices, in a csv file Using Log4j API
		log.info("CSV output");	
		
		
		
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
