package Page;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BaseSetup.Setup;

public class MainAction extends Setup{
	public void input(WebElement element,String value) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		(element).sendKeys(value);
	}
	
	public void click(WebElement button) {
//		(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOf(button));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		(button).click();
	}
	
	public void pressEnter(WebElement element) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		(element).sendKeys(Keys.ENTER);
	}
	
	public void getassert(WebElement element,String text) {
		(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOf(element));
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Assert.assertTrue((element).getText().contains(text));
		}catch (NoSuchElementException e) {
			Assert.fail("Element "+(element)+" is not found");
		}
	}
	
	public void elassert(WebElement element) {
		(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOf(element));
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Assert.assertTrue((element).isDisplayed());
		}catch (NoSuchElementException e) {
			Assert.fail("Element "+(element)+" is not found");
		}
	}
	
	public void elassert2(WebElement element, String Text) {
		(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOf(element));
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Assert.assertEquals(element.getText(), Text);
		}catch (NoSuchElementException e) {
			Assert.fail("Element "+(element)+" is not found");
		}
	}
	
	public void getassert2(WebElement element,String text) {
		(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOf(element));
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Assert.assertEquals((element).getAttribute("value"),text);
		}catch (NoSuchElementException e) {
			Assert.fail("Element "+(element)+" is not found");
		}
	}

	public void elassert3(WebElement element,String ExpectedText) {
		(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOf(element));
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[contains(text(),'"+ExpectedText+"')]")).click();
		}catch (NoSuchElementException e) {
			Assert.fail("Element "+(element)+" is not found");
		}
	}
}
