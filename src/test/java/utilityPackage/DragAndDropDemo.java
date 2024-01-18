package utilityPackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import baseclassPackage.BaseClassAutoServer;
import baseclassPackage.SuperBaseClass;
import io.appium.java_client.AppiumBy;

public class DragAndDropDemo extends SuperBaseClass {
	
	@SuppressWarnings("deprecation")
	@Test
	public void DragAndDropTest(){
		
try {
			
			System.out.println("*******************  DragAndDropTest() is Start ****************");
		   
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           
		      driver.findElement(AppiumBy.accessibilityId("Views")).click();
			   System.out.println("****** First element is found and clicked on found element ********");
			   
			   driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
			   System.out.println("****** second element is found and clicked on found element ********");
			   
			  WebElement source = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.view.View[1]"));
			   System.out.println("****** Source Element is found and store in source variable ********");
			   
			   ((JavascriptExecutor)driver).executeScript("mobile: dragGesture",ImmutableMap.of(
					   "elementId",((RemoteWebElement)source).getId(),
					   "endX",469,
					   "endY",375
					   ));
			   System.out.println("****** DragAndDrop Gesture is done ********");
			   Thread.sleep(2000);
			   String result = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dropped!']")).getText();
			   
			   Assert.assertEquals(result, "Dropped!");
			   
			  
				System.out.println("******  DragAndDropTest() is run successfully  ******");
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("cause is:...."+e.getCause());
			System.out.println("Error cause message ...."+e.getMessage());
			e.printStackTrace();
		}
		
		
	}

}
