package Page;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;  
import java.util.Scanner;  
import java.util.regex.Matcher;    

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64;
import com.google.api.client.util.StringUtils;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.ModifyThreadRequest;

import BaseSetup.BasePOM;
import Page.MainAction;

public class RegisterPage extends BasePOM{
	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private static final String APPLICATION_NAME = "Gmail API Java Quickstart";
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static final String user = "me";
	static Gmail service = null;
	private static File filePath = new File(System.getProperty("user.dir")+"/credentials.json");
	public String valeu_otp;
	
	MainAction mainAct = new MainAction();
	
	@FindBy(xpath = "//*[@id=\"vm__white-header-dweb\"]/section/header/div[3]/div/div/div[2]/div/a[1]/p")
	private WebElement el_daftarbutton;
	@FindBy(xpath = "/html/body/main/div/div[2]/section/div[1]/div[1]/div/input")
	private WebElement el_emailinput;
	@FindBy(xpath = "/html/body/main/div/div[2]/section/div[2]/button")
	private WebElement el_daftarbutton2;
	@FindBy(xpath = "/html/body/div[1]/section/div/div[2]/div/div[2]/div/div/div/div/button[1]")
	private WebElement el_sendcodebutton;
	@FindBy(xpath = "/html/body/div[1]/section/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div/input")
	private WebElement el_code;
	@FindBy(xpath = "/html/body/div[1]/section/div/div[2]/div/div[2]/div/div/div/div/button")
	private WebElement el_verifikasibutton;
	@FindBy(xpath = "/html/body/main/div/div[2]/section/div[2]/div[1]/div/input")
	private WebElement el_pass;
	@FindBy(xpath = "/html/body/main/div/div[2]/section/div[1]/div[1]/div/input")
	private WebElement el_name;
	@FindBy(xpath = "/html/body/main/div/div[2]/section/button")
	private WebElement el_simpanbutton;
	@FindBy(xpath = "/html/body/main/div/div[2]/section/p[1]")
	private WebElement el_success;
	
	
	public void click_daftarbutton() {
		mainAct.click(el_daftarbutton);
	}
	public void click_daftarbutton2() {
		mainAct.click(el_daftarbutton2);
	}
	public void input_email(String email) {
		mainAct.input(el_emailinput,email);
	}
	
	public void send_code() {
		mainAct.click(el_sendcodebutton);
		
	}
	
	public String get_OTP() throws Throwable, IOException, GeneralSecurityException {
		InputStream in = new FileInputStream(filePath); //Read credentials.json
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

		//Credential builder

		Credential authorize =new GoogleCredential.Builder().setTransport(GoogleNetHttpTransport.newTrustedTransport())
				.setJsonFactory(JSON_FACTORY)
				.setClientSecrets(clientSecrets.getDetails().getClientId().toString(),
						clientSecrets.getDetails().getClientSecret().toString())
				.build()
				.setAccessToken("ya29.a0AfH6SMBP-fGySlGQTj2E7h40Of3a_PSVqjIl02PgTAJ1JQ1Edgu_WacoisSQbNhS3bRGZY0kJMzsUme5DuuNsYlEtNao4KaisRhWQocgXLLsrV3sD8-WBzz6EhByURRHzzzI8DsabxWOg0X_hwLRJAkC1fqw")//getAccessToken()
				.setRefreshToken("1//0gGjOLDS03D_zCgYIARAAGBASNwF-L9IrdIcj6LSNCUcJ1nk9zc6_akoOHkUoDFSEJZ1nLPTn4ac5S1DllLKY6SaYhvROuCBck4E");


		//Create Gmail service
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, authorize).setApplicationName(RegisterPage.APPLICATION_NAME).build();

		//Access Gmail inbox

		Gmail.Users.Messages.List request = service.users().messages().list(user).setQ("from: " + "mail@noreply.bukalapak.com");

		ListMessagesResponse messagesResponse = request.execute();
		request.setPageToken(messagesResponse.getNextPageToken());

		int totalMail = messagesResponse.getMessages().size();
		System.out.println("total = "+totalMail);
		//remove UNREAD status for all email
		for (int i = 0; i < 2; i++) {
			//Get ID of the email you are looking for
			String messageId = messagesResponse.getMessages().get(i).getId();
			Message message = service.users().messages().get(user, messageId).execute();

			List<String> labelsToAdd = new LinkedList<String>();
			List<String> labelsToRemove = new LinkedList<String>();

			labelsToAdd.add("INBOX"); //IMPORTANT
			labelsToRemove.add("UNREAD"); //UNREAD
			ModifyThreadRequest mods = new ModifyThreadRequest().setAddLabelIds(labelsToAdd)
					.setRemoveLabelIds(labelsToRemove);
			service.users().threads().modify(user, message.getThreadId(), mods).execute();
		}

		//check for new email
		for (int j = 0; j < 1; j++) {
			//Get ID of the email you are looking for
			String messageId = messagesResponse.getMessages().get(j).getId();
			Message message = service.users().messages().get(user, messageId).execute();
//			System.out.println("message = "+message);
			String readStatus = message.getLabelIds().get(0);
			String emailBody = StringUtils.newStringUtf8(Base64.decodeBase64(message.getPayload().getBody().getData()));
//			System.out.println("Email body : "+emailBody);
			valeu_otp = emailBody.substring(10247, 10252);
			System.out.println("OTP : "+valeu_otp);

		}
		return valeu_otp;

	}
	
	public void input_code(String code) {
		mainAct.input(el_code, code);
	}
	public void click_verifikasi() {
		mainAct.click(el_verifikasibutton);
	}
	
	public void input_name(String name) {
		mainAct.input(el_name, name);
	}
	public void input_password(String pass) {
		mainAct.input(el_pass, pass);
	}
	
	public void click_simpan() {
		mainAct.click(el_simpanbutton);
	}
	
	public void asser_success() {
		mainAct.elassert2(el_success, "Akun kamu berhasil dibuat!");
	}
	
}
