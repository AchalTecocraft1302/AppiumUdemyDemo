package utilityPackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import baseclassPackage.BaseClassAutoServer;
import io.appium.java_client.AppiumBy;

public class LongPressDemo extends BaseClassAutoServer {
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void LongPressTest() {
		
		try {
			
			System.out.println("*******************  LongPressTest() is Start ****************");
		   
			mobiledriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           
		      mobiledriver.findElement(AppiumBy.accessibilityId("Views")).click();
			   System.out.println("****** First element is found and clicked on found element ********");
			   
			   mobiledriver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
			   System.out.println("****** Second element is found and clicked on found element ********");
			   
			   mobiledriver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
			   System.out.println("****** Third element is found and clicked on found element ********");
			   
            WebElement ele = mobiledriver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']")); 
            // xpath - /hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ExpandableListView/android.widget.TextView[1]
            // xpath - "//class[@text='text here']" -> //android.widget.TextView[@text='People Names']		
			   
              //Function call for long press action (pass webElement as argument) 
               longPressAction(ele);    
			   System.out.println("************* Long Press element is found and clicked on found element ***************");
			   
			  //AssertEquals(Actual text ,Expected text)
			   String menutext = mobiledriver.findElement(By.id("android:id/title")).getText();
			   Assert.assertEquals(menutext,"Sample menu");
			   System.out.println("*************** AssertEquals is run ******************");
			   
			   
			   //AssertTrue (Element is displayed then return true otherwise return false
			   Assert.assertTrue(mobiledriver.findElement(By.id("android:id/title")).isDisplayed());
			   System.out.println("************** AssertTrue is run *********************");
			   
			   

			   
			   
				System.out.println("******  LongPressTest() is run successfully  ******");
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("cause is:...."+e.getCause());
			System.out.println("Error cause message ...."+e.getMessage());
			e.printStackTrace();
		}
		
	
	}
}
