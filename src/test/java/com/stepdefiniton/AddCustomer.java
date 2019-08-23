package com.stepdefiniton;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddCustomer {
	static WebDriver driver;

	@Given("user should launch the browser")
	public void user_should_launch_the_browser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Amarnath\\eclipse-workspace\\CucumberJuly8AM\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/telecom/");

	}

	@Given("user should click add customer")
	public void user_should_click_add_customer() {
		driver.findElement(By.xpath("(//a[@href='addcustomer.php'])[1]")).click();

	}

	@When("user as to provide the valid details")
	public void user_as_to_provide_the_valid_details() {
		driver.findElement(By.xpath("//label[text()='Done']")).click();
		driver.findElement(By.id("fname")).sendKeys("Ashwini");
		driver.findElement(By.id("lname")).sendKeys("Amaru");
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("message")).sendKeys("chennai");
		driver.findElement(By.id("telephoneno")).sendKeys("1244435");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("have to verif customer ID is Displayed")
	public void have_to_verif_customer_ID_is_Displayed() {
		Assert.assertTrue(driver.findElement(By.xpath("(//td[@align='center'])[2]")).isDisplayed());
	}

}
