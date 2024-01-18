package ecommerce.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import baseclassPackage.SuperBaseClass;
import io.appium.java_client.AppiumBy;

public class Test03_AddToCart extends SuperBaseClass {
	
	@Test
	public void addToCartTest03() {
		
		System.out.println("*******************  addToCartTest03() is start ****************");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		eCommereceAppForm();
		
		//Scroll till Product 'Nike SFB Jungle' 
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nike SFB Jungle\"))"));
		
		//step 1) get size of product and store into integer
		int prodcount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		 System.out.println("*********** Total Product :- "+prodcount); //Product count as per display on screen only
		 
		 for(int i=0;i<prodcount;i++) {
			 
			 //step 2) Check one by one product name , get it's index amd get product name and store into string
			 String productname = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			 System.out.println("*********** Product Name is:- "+productname);
			  
			 //step 3) check product name one by one and check text with 'Nike SFB Jungle' than click on it until
			 if(productname.equalsIgnoreCase("Nike SFB Jungle"))
			 {
				 driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				 System.out.println("******************* Clicked on desired product name: 'Nike SFB Jungle' ****************");
			 } 
		 }
		 //Clicked on 'cart' icon
		 driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		 System.out.println("*******************  Clicked on cart button: Go to Cart screen ****************");
		
		System.out.println("*******************  addToCartTest03() is finished ****************");
	}

}
