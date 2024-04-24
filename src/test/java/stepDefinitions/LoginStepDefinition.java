package stepDefinitions;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

public class LoginStepDefinition {
	private WebDriver driver;
	private LoginPage loginPage;
	
	@Before
	public void setUp () {
		System.setProperty("webdriver.chrome.driver",".\\src\\test\\java\\libraries\\chromedriver.exe");
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		driver.manage().window().maximize();
	}

	@Given("I am on the Login Page")
	public void i_am_on_the_page() {
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}
	
	@When("I enter username {string} and password {string}")
	public void i_enter_username_password(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);		
	}
	
	@And("I click on the login button")
	public void i_click_on_the_login_button() {
		loginPage.clickLoginButton();
	}
	
	@Then("I should see the welcome message")
	public void i_see_the_welcome_message() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getSuccessMessageLocator()));
		
		String successMessage = loginPage.getSuccessMessage();
		
		Assert.assertEquals("Logged In Successfully", successMessage);
		
		System.out.println("Login Successfull");
		
			
		}
		
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			
		}
	}
}
