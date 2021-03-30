package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BaseSetup.BasePOM;

public class LoginPage extends BasePOM{
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	MainAction mainAct = new MainAction();
	
	
	@FindBy(xpath = "/html/body/div[1]/div/section/header/div[3]/div/div/div[2]/div/a[2]")
	private WebElement el_login;
	@FindBy(xpath = "/html/body/main/div/div[2]/div[1]/form/div[2]/input")
	private WebElement el_email;
	@FindBy(xpath = "/html/body/main/div/div[2]/div[1]/form/div[3]/input")
	private WebElement el_pass;
	@FindBy(xpath = "/html/body/main/div/div[2]/div[1]/form/div[5]/button")
	private WebElement el_loginbutton;
	
	public void clickLogin() {
		mainAct.click(el_login);
	}
	public void input_email(String email) {
		mainAct.input(el_email, email);
	}
	public void input_pass(String pass) {
		mainAct.input(el_pass, pass);
	}
	public void click_login() {
		mainAct.click(el_loginbutton);
	}
	
	
}
