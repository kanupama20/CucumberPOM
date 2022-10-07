package salesForceNew.test.steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import salesForceNew.test.pages.base.BasePage;
import salesForceNew.test.pages.login.LoginPage;
import salesForceNew.test.tests.ReadProperties;
import salesForceNew.test.pages.login.ForgotPasswordPage1;
import salesForceNew.test.pages.login.ForgotPasswordPage2;
import salesForceNew.test.pages.home.HomePage;

public class SalesforceTestDefination extends ReadProperties{

	
	public static WebDriver driver = null;
	
	LoginPage login;
	HomePage home;
	ForgotPasswordPage1 forgotpassword_page1;
	ForgotPasswordPage2 forgotpassword_page2;
	
	@Before 
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
		try {
			driver.get(readPropertyData("applicationProperties", "url"));
		} catch (IOException e) {
			System.out.println("Login to salesforce page did not open");
			e.printStackTrace();
		}		
	}	
	
	/*
	 * @Before (order = 1) public void setUp1() {
	 * WebDriverManager.firefoxdriver().setup(); driver=new FirefoxDriver(); try {
	 * driver.get(readPropertyData("applicationProperties", "url")); } catch
	 * (IOException e) {
	 * System.out.println("Login to salesforce page did not open");
	 * e.printStackTrace(); } }
	 */
	
	@After
	public void close_browser() {
		driver.close();
	}
	
	@When("user on {string}")
	public void user_on(String page) {
	    if(page.equalsIgnoreCase("loginpage"))
	    	login=new LoginPage(driver);
	    else if(page.equalsIgnoreCase("homepage"))
	    	home=new HomePage(driver);
	    else if(page.equals("forgot password page1"))
	    	forgotpassword_page1 = new ForgotPasswordPage1(driver);
	    else if(page.equals("forgot password page2")) 
	    	forgotpassword_page2 = new ForgotPasswordPage2(driver);
	    
	}
	
	@When("I enter valid login")
	public void i_enter_valid_login() {
		try {
			login.enterUserName(readPropertyData("applicationProperties", "valid-usernm"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@When("I enter valid password")
	public void i_enter_valid_password() {
		try {
			login.enterPassword(readPropertyData("applicationProperties", "valid-pw"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@When("I enter invalid login")
	public void i_enter_invalid_login() {
		try {
			login.enterUserName(readPropertyData("applicationProperties", "invalid-usernm"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@When("I enter invalid password")
	public void i_enter_invalid_password() {
		try {
			login.enterPassword(readPropertyData("applicationProperties", "invalid-pw"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@When("I enter clear password")
	public void i_enter_clear_password() {
	    login.clearPassword();
	}

	@When("I click login button")
	public void i_click_login_button() {
	   login.clickLoginButton();
	   BasePage.waitUntillPageLoads();
	}

	@Then("I should get page title as {string}")
	public void i_should_get_page_title_as(String title) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		home.waitUtillHomeTabVisible();
		Assert.assertEquals(home.get_homepage_title(), title);
	}

	@Then("I should get error as {string}")
	public void i_should_get_error_as(String error) {
	  login.validate_errormsg();
	  Assert.assertEquals(login.get_errormsg(), error);
	}		
	
	@When("I click rememberme chkbox")
	public void i_click_rememberme_chkbox() {
	   login.selectRememberMe();
	}

	@Then("click on usermenu drop down's logout link")
	public void click_on_usermenu_drop_down_s_logout_link() {
	   home.logout();
	   BasePage.waitUntillPageLoads();
	}

	@Then("username field should display username")
	public void username_field_should_display_username() {
	  try {
		Assert.assertEquals(login.readRememberedUsernmField(), readPropertyData("applicationProperties", "valid-usernm"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

	@When("I click forgot password link")
	public void i_click_forgot_password_link() {
	    login.clickForgotPw();
	    BasePage.waitUntillPageLoads();
	}

	@When("I click continue button")
	public void i_click_continue_button() {
		forgotpassword_page1.clickContinueButton();
		BasePage.waitUntillPageLoads();
	}

	@Then("I should see a message {string}")
	public void i_should_see_a_message(String msg) {
	   Assert.assertEquals(forgotpassword_page2.get_SendEmail_Msg(), msg);
	}
	
	@When ("I enter valid login in forgot password page1")
	public void i_enter_valid_login_in_forgot_password_page1() {
		try {
			forgotpassword_page1.enterUserName_forgotPwPage(readPropertyData("applicationProperties", "valid-usernm"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
