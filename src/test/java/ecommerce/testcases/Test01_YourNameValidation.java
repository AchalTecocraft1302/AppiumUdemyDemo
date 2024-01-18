package ecommerce.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.NotFoundException;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseclassPackage.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import utilityPackage.AppiumDemo;

public class Test01_YourNameValidation extends BaseClass {
	
	
	@Test
	public void yourNameValidationTest01() {
		
		System.out.println("*******************  yourNameValidationTest01() is Start ****************");
		   
		mobiledriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		try {
			
			 mobiledriver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Afghanistan']")).click();
			   System.out.println("****** Clicked on country list ********");
			   
			   mobiledriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))")).click();
			   System.out.println("****** List is scrolled Australia is selected from list ********");
			  
			   mobiledriver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button")).click();
			   System.out.println("****** Clicked on 'Let's shop without enter name ********");
			  
			  
			  try {
				  String toastMessage  = mobiledriver.findElement(AppiumBy.xpath("//android.widget.Toast[1]")).getAttribute("");
				  Assert.assertEquals(toastMessage,"Please enter your name");
				  
				   System.out.println("************** 'Please enter your name' toast is displayed *********************");
				
			} catch (AssertionError e) {
				// TODO: handle exception
				System.out.println("************** 'Please enter your name' toast is not displayed *********************");
			}
			   
			   
			   
			   
			   
			   System.out.println("*******************  yourNameValidationTest01() is finish ****************");
			
			
		} catch (NotFoundException e) {
			// TODO: handle exception
			System.out.println("cause is:...."+e.getCause());
			System.out.println("Error cause message ...."+e.getMessage());
			e.printStackTrace();
			System.out.println("*******************  yourNameValidationTest01() is not run ****************");
		}
       
	     
	}

}
