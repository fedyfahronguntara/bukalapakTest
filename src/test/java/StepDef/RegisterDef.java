package StepDef;

import java.io.IOException;
import java.security.GeneralSecurityException;

import BaseSetup.Setup;
import Page.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import BaseSetup.Setup;

public class RegisterDef extends Setup{
	RegisterPage dp = new RegisterPage(driver);
	
	@Given("User has accessed Home page")
	public void user_has_accessed_Home_page() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		System.out.println("Access WWeb");
	}

	@When("User click on Daftar button")
	public void user_click_on_Daftar_button() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		dp.click_daftarbutton();
	}

	@When("user fill email {string}")
	public void user_fill_email(String val_email) {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		dp.input_email(val_email);
	}
	@When("User click on Daftar button_{int}")
	public void user_click_on_Daftar_button_(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		dp.click_daftarbutton2();
	}
	@When("click send code button")
	public void click_send_code_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		dp.send_code();
		
	}

	@When("fill code verification")
	public void fill_code_verification() throws IOException, GeneralSecurityException, Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		Thread.sleep(15000);
		String code=dp.get_OTP();
//		Thread.sleep(5000);
		dp.input_code(code);
		
	}

	@When("click verifikasi button")
	public void click_verifikasi_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//		Thread.sleep(1000);
		dp.click_verifikasi();
		Thread.sleep(5000);
	}
	@When("fill name {string} and password {string}")
	public void fill_name_and_password(String name, String pass) {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		dp.input_name(name);
		dp.input_password(pass);
	}
	
	@When("click simpan button")
	public void click_simpan_button() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		dp.click_simpan();
	}
	@Then("Account success Register")
	public void account_success_Register() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		dp.asser_success();
		System.out.println("Success register");
	}
}
