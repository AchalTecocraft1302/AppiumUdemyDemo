package baseclassPackage;


import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testinium.deviceinformation.DeviceInfo;
import com.testinium.deviceinformation.DeviceInfoImpl;
import com.testinium.deviceinformation.device.DeviceType;
import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import com.testinium.deviceinformation.model.Device;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
//import io.appium.java_client.android.AndroidTouchAction;
//import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
//import java.io.File;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseClass {
	
	public static AndroidDriver mobiledriver;
	public static AppiumDriver  driver;
	public static AppiumDriverLocalService service ;
	public static DeviceInfo deviceInfo ;
	public static Device device ;
	//public static IOSDriver mobiledriver;
	
	
	@BeforeTest
	public <AndroidElement> void setup() throws IOException, DeviceNotFoundException {

		 System.out.println("******************  BaseClass setup is started ****************");                
		//Appium server auto run started through node.j ->  PATH -\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js        
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Achal Trivedi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
	        		  .withIPAddress("127.0.0.1")
	        		  .withArgument(() -> "--port", "4723")
	        		  .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
	        		  .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
	        	      .withArgument(GeneralServerFlag.LOG_LEVEL,"debug").usingPort(4723).build();
		               service.start();
		               
		     System.out.println("******************  Appium Server is started ****************");       

		    //API DEMOS APP 
	       // File app= new File("C:/Users/Achal Trivedi/eclipse-workspace/AppiumUdemyDemo/src/test/resources/apps/ApiDemos-debug.apk");
		     
		    //E-COMMERCE APP 
	        File app= new File("C:/Users/Achal Trivedi/eclipse-workspace/AppiumUdemyDemo/src/test/resources/apps/General-Store.apk");
	        
		
			DesiredCapabilities cap = new DesiredCapabilities();
			
try {
       
		    deviceInfo = new DeviceInfoImpl(DeviceType.ANDROID);
			deviceInfo.anyDeviceConnected();
			device = deviceInfo.getFirstDevice();

			System.out.println("Platform Name - " + device.getDeviceProductName());
			System.out.println("Device UDID   - " + device.getUniqueDeviceID());
			System.out.println("Product Verison - " + device.getProductVersion());
			System.out.println("Model Number   - " + device.getModelNumber());
		    System.out.println("Buld Verison   - " + device.getBuildVersion());
			 
			
			  
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME,device.getDeviceProductName());
			System.out.println("******************  get Platform name ****************"); 
			cap.setCapability(MobileCapabilityType.UDID,device.getUniqueDeviceID());
			System.out.println("******************  get UDID ****************"); 
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,device.getProductVersion());
			System.out.println("******************  get Platform Verison ****************"); 
			cap.setCapability(MobileCapabilityType.DEVICE_NAME,device.getModelNumber());
			System.out.println("******************  get device name (Model Number) ****************"); 
			
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
			cap.setCapability("appWaitDuration", 100);
			
		    cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		    cap.setCapability(MobileCapabilityType.APP,app.getPath());
			
			//cap.setCapability("autoGrantPermissions", true);
		    cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
			
		    //URL url = new URL("http://127.0.0.1:4723/wd/hub"); 
	    	 mobiledriver = new AndroidDriver(service,cap); //call service here after appium server start by service.start() 
	    	 
	    		
	    	System.out.println("******************  capabilities are successfully taken ****************"); 
			
	    	//implicitwait 
	    	mobiledriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		    System.out.println("******************  BaseClass setup is successfully run ****************"); 
		    
} catch (Exception e) {

	System.out.println("Error cause message ...."+e.getMessage());
	System.out.println("cause is:...."+e.getCause());
	e.printStackTrace();
	System.out.println("******************  Device is not connected or please check your device ****************"); 
	// TODO: handle exception
}	    

	}


 public void eCommereceAppForm() {
	 
	 try {
			
		 System.out.println("******************* BaseClass:- eCommereceAppForm() is start ****************");
		 
		 
		 
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
		  
		   
		   System.out.println("******************* eCommereceAppForm() is finished ****************");
		
		
	} catch (NotFoundException e) {
		// TODO: handle exception
		System.out.println("cause is:...."+e.getCause());
		System.out.println("Error cause message ...."+e.getMessage());
		e.printStackTrace();
		System.out.println("******************* BaseClass:- submitform() is not run ****************");
	}
	 
 }

	@AfterTest 
	public void teardown() {
	
		System.out.println("AfterTest is run....");
		System.out.println("Program run successfully run....");
		service.close();
		System.out.println("Appium Server Closed....");
		 
	
	}
	
	@Test 
	public void test() {
	
		System.out.println("Baseclass Test is run....");
	
	}
	
	
}


// Socket hung up issue arise than follow below command
//Stop appium server and execute below commands
//adb uninstall io.appium.uiautomator2.server
//adb uninstall io.appium.uiautomator2.server.test
//start appium server and execute your scripts ..it will work
