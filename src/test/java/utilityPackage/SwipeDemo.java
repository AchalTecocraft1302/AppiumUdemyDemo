package utilityPackage;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import baseclassPackage.BaseClassAutoServer;
import baseclassPackage.SuperBaseClass;
import io.appium.java_client.AppiumBy;

public class SwipeDemo extends SuperBaseClass {
	
	@Test
	public void swipeTest2() {
		
try {
			
			System.out.println("*******************  SwipeTest2() is Start ****************");
		   
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           
		      driver.findElement(AppiumBy.accessibilityId("Views")).click();
			   System.out.println("****** First element is found and clicked on found element ********");
			  
			   driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Gallery\"]")).click();
			   System.out.println("****** Second element is found and clicked on found element ********");
			   
			   
			   driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
			   System.out.println("****** Third element is found and clicked on found element ********");
			   
			   //SWIPE functionality
			   
			WebElement firstimage = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));
			  
			  //check first image focus attribute ,before swipe
			  Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "true");
			  
			   System.out.println("****** First image is focused: true ********");
			   
//			   //Swipe by javascriptExecutor :SwipeGesture
//			   ((JavascriptExecutor)mobiledriver).executeScript("mobile: swipeGesture",ImmutableMap.of("elementId",((RemoteWebElement)firstimage).getId(),"direction","left","percent",0.75));
//			   System.out.println("****** First image is swiped ********");
			   
			   swipeaction(firstimage, "left"); // call function from baseclass ,pass argument as webelement and direction
			   
			   // //check first image focus attribute ,after swipe
			   Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "false");
			   System.out.println("****** Second image is focused:true ,first image is focused: false  ********");
			   
			 
			   

	
			   
			   
			   
			   
			 
			
			   
			   
				System.out.println("******  SwipeTest() is run successfully  ******");
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("cause is:...."+e.getCause());
			System.out.println("Error cause message ...."+e.getMessage());
			e.printStackTrace();
		}
		
		
	}

}
