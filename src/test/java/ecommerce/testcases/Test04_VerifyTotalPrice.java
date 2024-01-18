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
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Test04_VerifyTotalPrice extends SuperBaseClass {
	
	@Test
	public void verifyTotalPriceTest04() throws InterruptedException {
		
		System.out.println("*******************  verifyTotalPriceTest04() is start ****************");
	try {
		
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	   eCommereceAppForm();
		
		
	   driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
	   driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
	   System.out.println("******************* Clicked on two product ****************");
	   
	   //Clicked on 'cart' icon
		 driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		 System.out.println("*******************  Clicked on cart button: Go to Cart screen ****************");
	   
	   WebElement cartTitlElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Cart']"));
	   
	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	   wait.until(ExpectedConditions.attributeContains(cartTitlElement,"text","Cart"));
	   System.out.println("******************* Wait for 'Cart' page load ****************");
	   
	   //All similar type of multiple element store in Webelement 'List' 
	   List<WebElement> productprice = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
	   
	   double sum = 0;
    for (WebElement singleproduct : productprice) {
    	
    	          String singleprice = singleproduct.getText(); //convert web element into string
    	          Double dpriceDouble = Double.parseDouble(singleprice.substring(1)); //convert string into double
    	          sum = sum + dpriceDouble;  //sum of products in available cart
    	          System.out.println(singleprice+"---> After every iteration,total price is:- "+sum);
		
    	
	}
    
    String purchaseAmount = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText(); 
    Double dpurchaseAmount = Double.parseDouble(purchaseAmount.substring(1));
    Assert.assertEquals(sum,dpurchaseAmount);
    System.out.println("******************* Total sum of product is:- "+sum);
    System.out.println("*******************  Total Purchase Amount is:- "+dpurchaseAmount);
    System.out.println("******************* Assertion:Passed Total purchase price is verified ****************");
    
   
    driver.findElement(By.className("android.widget.CheckBox")).click();
    System.out.println("******************* click on checkmarked ****************");
    
    Thread.sleep(3000);
    
    WebElement readtermsElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Please read our terms of conditions']"));
    
   
    longPressAction(readtermsElement);
    System.out.println("******************* Longpress on terms and condition ****************");
    
   WebElement closElement = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='CLOSE']"));
    //Explicit wait untill popup open and element display
    WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(10));
	   wait2.until(ExpectedConditions.attributeContains(closElement,"text","CLOSE"));
	   closElement.click();
    System.out.println("******************* closed terms and condition ****************");
    
    
   
   driver.findElement(By.xpath("//android.widget.Button[@text='Visit to the website to complete purchase']")).click();
   System.out.println("******************* click on 'visit the website to purchase' button ****************");
   
   Thread.sleep(3000);
   //HYBRID APP DEMO - WEBVIEW HANDLE
  
   //get webview of you currect app screen
   Set<String> contexts = driver.getContextHandles();
   for (String constring : contexts) {
	
	   System.out.println("******************* context of app:- "+constring);
}
 
   
    driver.context("WEBVIEW_com.androidsample.generalstore");
    System.out.println("******************* context is switched into Webview ****************");
    
   
    driver.findElement(By.name("q")).sendKeys("Appium with java");
    System.out.println("******************* send key on searched ****************");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    Thread.sleep(5000);  //for watching search results
    driver.pressKey(new KeyEvent(AndroidKey.BACK));
    
    driver.context("NATIVE_APP");
    System.out.println("******************* context is switched into Native App ****************");
    
	System.out.println("*******************  verifyTotalPriceTest04() is finished ****************");
		
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
