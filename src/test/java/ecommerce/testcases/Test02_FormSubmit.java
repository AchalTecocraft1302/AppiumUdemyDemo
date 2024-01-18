package ecommerce.testcases;

import java.time.Duration;

import org.openqa.selenium.NotFoundException;

import org.testng.annotations.Test;

import baseclassPackage.BaseClass;
import io.appium.java_client.AppiumBy;

public class Test02_FormSubmit extends BaseClass {
	
	@Test
	public void formSubmitTest02() {
		
		System.out.println("******************* formSubmitTest02() is Start ****************");
		   
		mobiledriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		try {
			
			 mobiledriver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Afghanistan']")).click();
			   System.out.println("****** Clicked on country list ********");
			   
			   mobiledriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))")).click();
			   System.out.println("****** List is scrolled Australia is selected from list ********");
			   
			   mobiledriver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("Achal");
			   System.out.println("****** Enter name is 'Your Name' field ********");
			   
			   mobiledriver.hideKeyboard();
			   System.out.println("****** Keyboard is hide ********");
			   
			   mobiledriver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text='Female']")).click();
			   System.out.println("****** Gender 'Female' is selected ********");
			   
			   mobiledriver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button")).click();
			   System.out.println("****** Clicked on 'Let's shop' to submit form ********");
			  
			   
			   System.out.println("*******************  formSubmitTest02() is finish ****************");
			
			
		} catch (NotFoundException e) {
			// TODO: handle exception
			System.out.println("cause is:...."+e.getCause());
			System.out.println("Error cause message ...."+e.getMessage());
			e.printStackTrace();
			System.out.println("*******************  formSubmitTest02() is not run ****************");
		}
       
		
	}

}
