package utilityPackage;

import java.time.Duration;

import org.testng.annotations.Test;

import baseclassPackage.BaseClassAutoServer;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellanousDemo extends BaseClassAutoServer {
	
    
	@Test
	public void MiscellanousTest(){
		
		try {
					
					// Learn 3 Miscellanous things :- 
					// 1)Open app from app package and app activity -
			        //adb shell "dumpsys window | grep mCurrentFocus" - By this command get package name and activity name
			        // Activity activity = new Activity("App package name","app activity name");
			        // mobiledriver.startActivity(activity);
			
					// 2)Use clipboard and paste into textfield
			        // mobiledriver.setClipboardText("Wifiset");
			       //  .sendKeys(mobiledriver.getClipboardText());
			
				   // 3)Keypress event - Androidkey - Home,Back etc.
			       // mobiledriver.pressKey(new KeyEvent(AndroidKey.HOME));
			        
			
			      System.out.println("*******************  MiscellanousTest() is Start ****************");
				   
					 mobiledriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					 
					 
					 
					 
					 //Open direct focus activity screen ,no need to follow click from start
					//new Activity("App package name","app activity name")
					 Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
					 mobiledriver.startActivity(activity);
					 System.out.println("****** Preference Dependencies: activity is opened ********");
					 
					   
					   mobiledriver.findElement(AppiumBy.id("android:id/checkbox")).click();
					   System.out.println("****** Clicked on checkbox ********");
					   
					   mobiledriver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
					   System.out.println("****** Clicked on 'Wifi Settings' ********");
					   
					   //'Wifiset' text copied into clipboard
					   mobiledriver.setClipboardText("Wifiset");
					   System.out.println("****** text is copied into clipboard ********");
					   
					  //Enter 'wifiset' in textfield from clipboard
					   mobiledriver.findElement(AppiumBy.id("android:id/edit")).sendKeys(mobiledriver.getClipboardText());
					   System.out.println("****** Clipboard text is paste in field ********");
					   
					   Thread.sleep(3000);
					   
					  // 'ok' button click
					   mobiledriver.findElement(AppiumBy.id("android:id/button1")).click();
					   System.out.println("****** 'Ok' button is found and clicked ********");
					   
					   //Android 'BACK' keypress event
					   mobiledriver.pressKey(new KeyEvent(AndroidKey.BACK));
					   System.out.println("****** Back Keypress ********");
					   
					   Thread.sleep(3000);
					   
					   //Android 'HOME' keypress event
					   mobiledriver.pressKey(new KeyEvent(AndroidKey.HOME));
					   System.out.println("****** Home keypress ********");   
					   
					   
					   
					  
					System.out.println("******  MiscellanousTest() is run successfully  ******");
					
					
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println("cause is:...."+e.getCause());
					System.out.println("Error cause message ...."+e.getMessage());
					e.printStackTrace();
				}

	}
}
