package utilityPackage;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import baseclassPackage.BaseClassAutoServer;
import io.appium.java_client.AppiumBy;



public class AppiumDemo extends BaseClassAutoServer {
	

	@SuppressWarnings("deprecation")
	@Test
	public void AppiumDemoTest() {
		
		try {
			
			System.out.println("*******************  AppiumDemoTest() is Start ****************");
           
		      mobiledriver.findElement(AppiumBy.accessibilityId("Preference")).click();
			   System.out.println("****** First element is found and clicked on found element ********");
			   
			   mobiledriver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
			   System.out.println("****** Second element is found and clicked on found element ********");
			   
			   mobiledriver.findElement(AppiumBy.id("android:id/checkbox")).click();
			   System.out.println("****** Third element is found and clicked on found element ********");
			   
			   mobiledriver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
			   System.out.println("****** Fourth element is found and clicked on found element ********");
			   
			  //Enter 'wifiset' in textfield
			   mobiledriver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Wifiset");
			   System.out.println("****** Fifth element is found and clicked on found element ********");
			   
			  // ok button click
			   mobiledriver.findElement(AppiumBy.id("android:id/button1")).click();
			   System.out.println("****** Sixth element is found and clicked on found element ********");
			   
			   
			   System.out.println("****** ALL element is found and clicked on found element ********");
			   
			   
				System.out.println("******  AppiumDemoTest() is run successfully  ******");
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("cause is:...."+e.getCause());
			System.out.println("Error cause message ...."+e.getMessage());
			e.printStackTrace();
		}
		
	}


}
