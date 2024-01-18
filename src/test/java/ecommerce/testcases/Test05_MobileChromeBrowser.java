package ecommerce.testcases;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseclassPackage.SuperBaseClass;
import baseclassPackage.SuperChromeBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Test05_MobileChromeBrowser extends SuperChromeBase {
	
	@Test
	public void chromebrowserTest05() throws InterruptedException {
		
		System.out.println("*******************  chromebrowserTest05() is start ****************");
	try {
		
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
    driver.get("https://google.com");  //google open in chrome browser
    System.out.println("*******************  Title is:- "+driver.getTitle()+"********************"); //print title of website
    
    driver.findElement(By.name("q")).sendKeys("Appium with java"); //find element and enter given text
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER); //press enter on android keyboard
    
    Thread.sleep(5000);  //for watching search results
    
    driver.pressKey(new KeyEvent(AndroidKey.BACK)); //press back on android
   
    
	System.out.println("*******************  chromebrowserTest05() is finished ****************");
		
	} catch (NoSuchElementException e) {
		// TODO: handle exception
		System.out.println("No such Element Error Message...."+e.getMessage());
		e.printStackTrace();
	}
	catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error message ...."+e.getMessage());
		e.printStackTrace();
	}
	
		
		
	
	}

}
