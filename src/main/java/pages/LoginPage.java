package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

//constructor
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

//enter username

	public void enterUsername(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}

//enter password
	public void enterPassword(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
	}
	
// click on login button
	public void clickLoginButton() {
		driver.findElement(By.id("submit")).click();
	}

// get success message 
	public String getSuccessMessage() {
		return driver.findElement(By.xpath("//h1[@class='post-title']")).getText();
	}
	
 
// get success message for locator
	public By getSuccessMessageLocator() {
		return By.xpath("//h1[@class='post-title']");
	}
}