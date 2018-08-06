package com.cg.test;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class RedbusSteps {
	
	WebDriver driver=null;

@Given("^The user visits the redbus page$")

public void the_user_visits_the_redbus_page() throws Throwable {
	
	
	
	
	System.setProperty("webdriver.chrome.driver","D:\\Sabari\\chrome driver\\chromedriver.exe" );
	 driver = new ChromeDriver();
	driver.get("https://www.redbus.in/bus-tickets/");

	
}

@Given("^the user fills the source,destination,date of travel and searches for buses$")

public void the_user_fills_the_source_destination_date_of_travel_and_searches_for_buses() throws Throwable {
   
	WebElement src = driver.findElement(By.xpath("//*[@id=\"txtSource\"]"));
	src.sendKeys("Chennai Intl Airport");
	
	WebElement dest = driver.findElement(By.xpath("//*[@id=\"txtDestination\"]"));
	dest.sendKeys("Bangalore Intl Airport");
	
	WebElement startdate = driver.findElement(By.xpath("//*[@id=\"txtOnwardCalendar\"]"));
	startdate.sendKeys("08-Aug-2018");
	
	
	WebElement returndate = driver.findElement(By.xpath("//*[@id=\"txtReturnCalendar\"]"));
	returndate.sendKeys("15-Aug-2018");
	
	WebElement search = driver.findElement(By.xpath("/html/body/div[1]/div[4]/button"));
search.click();

Thread.sleep(7000);
search.sendKeys(Keys.TAB);
search.sendKeys(Keys.TAB);
search.sendKeys(Keys.ENTER);
	
}
@Given("^the user views the seats in the buses$")
public void the_user_views_the_seats_in_the_buses() throws Throwable {
    

//Thread.sleep(6000);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	WebElement viewseats = driver.findElement(By.xpath("//*[@id=\"10661994\"]/div/div[2]/div[1]"));
	viewseats.click();
}
@Given("^the user select the required seats$")
public void the_user_select_the_required_seats() throws Throwable {
    
	Thread.sleep(6000);
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	WebElement seat = driver.findElement(By.xpath("//*[@id=\"rt_10661994\"]/div/div/div/div[2]/div[2]/div[2]/canvas"));
	Actions action=new Actions(driver);
	action.moveToElement(seat,80,30).click().build().perform();

	Thread.sleep(5000);
	WebElement proceed  = driver.findElement(By.xpath("//*[@id=\"10661994\"]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[6]/button"));
	proceed .click();
}
@Given("^the user enters the passenger details$")
public void the_user_enters_the_passenger_details() throws Throwable {
	
	Thread.sleep(6000);
	WebElement name = driver.findElement(By.xpath("//*[@id=\"seatno-04\"]"));
	name.sendKeys("Sabari");
	
	WebElement gender = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div/span[2]/label"));
	gender.click();
	
	WebElement age = driver.findElement(By.xpath("//*[@id=\"seatno-01\"]"));
	age.sendKeys("21");
	
	WebElement email = driver.findElement(By.xpath("//*[@id=\"seatno-05\"]"));
	 email.sendKeys("sabari@gmail.com");
	
	 WebElement phone = driver.findElement(By.xpath("//*[@id=\"seatno-06\"]"));
	 phone.sendKeys("9876543210");
}
@Then("^the user clicks proceed to pay$")
public void the_user_clicks_proceed_to_pay() throws Throwable {
    
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	WebElement success = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div[2]/input"));
	success.click();
}
}
