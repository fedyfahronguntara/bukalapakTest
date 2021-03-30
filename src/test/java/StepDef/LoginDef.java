package StepDef;

import BaseSetup.Setup;
import Page.LoginPage;
import Page.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDef extends Setup {
	LoginPage dp = new LoginPage(driver);
	@Given("user has access Home page")
	public void user_has_access_Home_page() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		dp.clickLogin();
	}

	@When("user fill username {string} and password {string}")
	public void user_fill_username_and_password(String email, String pass) {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		dp.input_email(email);
		dp.input_pass(pass);
	}

	@When("click Login button")
	public void click_Login_button() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		dp.click_login();
	}

	@Then("dashboard page")
	public void dashboard_page() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
	}
}
