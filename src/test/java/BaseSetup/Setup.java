package BaseSetup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class Setup {
	public static WebDriver driver;

	public void set_up()    {
		System.setProperty("webdriver.chrome.driver","Driver\\chromedriver2.exe"); //disesuaikan dengan browser driver yang dipakai
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_68,true);
		driver.get("https://www.bukalapak.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

    public void tearDown(){
        driver.quit();
    }
}
