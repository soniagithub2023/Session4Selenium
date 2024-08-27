package variousConcepts;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class LearningDropdown {
  WebDriver driver;
  By USERNAME_FIELD = By.xpath("//*[@id=\"user_name\"]");
  By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
  By SIGN_IN_BUTTON_FIELD  = By.xpath("//*[@id=\"login_submit\"]");
  By DASHBOARD_HEADER_FIELD = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong");
  By CUSTOMER_FIELD = By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a");
  By ADD_CUSTOMER_FIELD = By.xpath("//*[@id=\"customers\"]/li[2]/a/span");
  By NEW_CUSTOMER_FIELD = By.xpath("/html/body/div[1]/section/div/div[2]/div/div[1]/div[1]/div/div/header/div/strong");
  By CUSTOMER_FULL_NAME_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[1]/div/input");
  By COMPANY_FIELD = By.xpath("//select[@name='company_name']");
  By EMAIL_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[3]/div/input");
  By PHONE_FIELD = By.xpath("//*[@id=\"phone\"]");
  By ADDRESS_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[5]/div/input");
  By CITY_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[6]/div/input");
  By ZIPCODE_FIELD = By.xpath("//*[@id=\"port\"]");
  By COUNTRY_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[8]/div[1]/select");
  By GROUP_FIELD = By.xpath("//*[@id=\"customer_group\"]");
  By SAVE_FIELD = By.xpath("//*[@id=\"save_btn\"]");
  
  @Before
  public void setup() {
	  System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.manage().deleteAllCookies();
	   driver.get("https://codefios.com/ebilling/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	  
  }
  
  
  @Test
  public void loginTest() {
	  driver.findElement(USERNAME_FIELD).sendKeys("demo@codefios.com");
	  driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
	  driver.findElement(SIGN_IN_BUTTON_FIELD).click();
  
	    //For Valdidating the code we do ASSERTION 
	   // ASSERTION means to validate whether we landed on right page or not 
	   Assert.assertTrue("Dashboard page not found",driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
	  
	  //Storing WebElements 
	  // TYPE NAME = VALUE
	  //WebElement USERNAME_ELEMENT = driver.findElement(By.xpath("//*[@id=\"user_name\"]"));
	  //WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
	  //WebElement SIGN_IN_BUTTON_ELEMENT  = driver.findElement(By.xpath("//*[@id=\"login_submit\"]"));
	  
	  //driver.findElement(By.xpath("//*[@id=\"user_name\"]")).sendKeys("demo@codefios.com ");
	  //driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
	  //driver.findElement(By.xpath("//button[@id='login_submit']")).click();
		
	   //USERNAME_ELEMENT.sendKeys("demo@codefios.com");
	   //PASSWORD_ELEMENT.sendKeys("abc123");
	   //SIGN_IN_BUTTON_ELEMENT.click();
	  
	  
	   
	  }
  @Test
  public void addCustomer() {
	  loginTest();
	  driver.findElement(CUSTOMER_FIELD).click();
	  driver.findElement(ADD_CUSTOMER_FIELD).click();
	  Assert.assertTrue("New customer page is not found",driver.findElement(NEW_CUSTOMER_FIELD).isDisplayed());
	   
	  driver.findElement(CUSTOMER_FULL_NAME_FIELD).sendKeys("Mahindra");
	  
	  //FOR DROPDOWN FIELD we use select class
	  Select sel= new Select(driver.findElement(COMPANY_FIELD));
	  sel.selectByValue("Walgreen");
	  
	  driver.findElement(EMAIL_FIELD).sendKeys("techfios2023@gmail.com");
	  driver.findElement(PHONE_FIELD).sendKeys("5456164430");
	  driver.findElement(ADDRESS_FIELD).sendKeys("8940 las padre");
	  driver.findElement(CITY_FIELD).sendKeys("alba");
	  driver.findElement(ZIPCODE_FIELD).sendKeys("45609"); 
	  
	  Select sel1 = new Select(driver.findElement(COUNTRY_FIELD));
	  sel1.selectByValue("United States of America");
	  
	  Select sel2 = new Select(driver.findElement(GROUP_FIELD));
	  sel2.selectByValue("SDLC");
	  
	  driver.findElement(SAVE_FIELD).click();
	  }
  
  @After
  public void teardown (){
	 driver.close();
	 driver.quit();
	  
  }
}
