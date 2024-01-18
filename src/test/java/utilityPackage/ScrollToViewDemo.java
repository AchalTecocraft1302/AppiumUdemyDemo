package utilityPackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import baseclassPackage.BaseClassAutoServer;
import io.appium.java_client.AppiumBy;

public class ScrollToViewDemo extends BaseClassAutoServer {
	
	@Test
	public void ScrollToViewTest(){
		
try {
			
			System.out.println("*******************  ScrollToViewTest() is Start ****************");
		   
			mobiledriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           
		      mobiledriver.findElement(AppiumBy.accessibilityId("Views")).click();
			   System.out.println("****** First element is found and clicked on found element ********");
			   
			   
			   //Two way scrolling 
			   //1)by UiScrollable - ScrollIntoView (pass element text in scrollIntoView())
//			    mobiledriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Hover Events\"))"));
			   //Thread.sleep(2000);
			   //System.out.println("*******************  Scroll to Element ****************");
	
			   WebElement rating = mobiledriver.findElement(AppiumBy.androidUIAutomator(
					     "new UiScrollable(new UiSelector().scrollable(true))" +
				         ".scrollIntoView(new UiSelector().textContains(\"Hover Events\"))"));
			   rating.click();
			   System.out.println("*******************  Scroll to Element ****************");
			   System.out.println("****** screen is scrolled and clicked on found element ********");
   
			   
			   //2)by JavaExecutor- call function for scroll till end by javaExecutor
//			   scrollToEnd();
//			   System.out.println("****** ScrollToEnd() is run ********");
			   
			   //Above function is scrolling till 'WebView' element is not found
//			  mobiledriver.findElement(AppiumBy.accessibilityId("WebView")).click();
//			  System.out.println("****** screen is scrolled and clicked on found element ********");
			   
			   
				System.out.println("******  ScrollToViewTest() is run successfully  ******");
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("cause is:...."+e.getCause());
			System.out.println("Error cause message ...."+e.getMessage());
			e.printStackTrace();
		}
		
		
	}

}
