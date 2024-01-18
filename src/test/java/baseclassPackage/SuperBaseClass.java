package baseclassPackage;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.testinium.deviceinformation.DeviceInfo;
import com.testinium.deviceinformation.DeviceInfoImpl;
import com.testinium.deviceinformation.device.DeviceType;
import com.testinium.deviceinformation.model.Device;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class SuperBaseClass {
	
	public static AndroidDriver driver = null;
	// public static AppiumDriver driver = null;
	public static AppiumDriverLocalService service = null;
	public static AppiumServiceBuilder builder ;
	public static DeviceInfo deviceInfo ;
	public static Device device ;
	public static WebDriverWait wait;
	public static String projectdir = System.getProperty("user.dir");
	//public static IOSDriver mobiledriver;
	
	@BeforeTest
	public void Setup() {
		
System.out.println("*********** SuperBaseclass: BeforeTest is Start ******************");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		//Build the Appium service
        builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1"); 
        builder.withArgument(() -> "--port", "4723");
        builder.withArgument(GeneralServerFlag.BASEPATH, "/wd/hub");
        //127.0.0.1 is the  localhost normally resolves to the IPv4  127.0.0.1
        builder.usingPort(4723); //Appium default port
        builder.withCapabilities(cap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL,"debug");
        builder.usingAnyFreePort().withArgument(() -> "--allow-insecure","chromedriver_autodownload");
        builder.build();

        //Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        System.out.println("**********************Appium Server Started via Java ************************************************");

   
       System.out.println("********************** Project directory:-" +projectdir);

   	 //E-COMMERCE APP 
    File app= new File( projectdir +"/src/test/resources/apps/General-Store.apk");
   
     //API DEMOS APP  
  	//  File app= new File(projectdir+ "/src/test/resources/apps/ApiDemos-debug.apk");
    
    //Chromedriver path if it is required
    // String driverpathString = projectdir + "/src/test/resources/driver/chromedriver111.exe";
    //  cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,driverpathString);
	
		
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
     			
     			cap.setCapability("automationName", "UiAutomator2");
      		    cap.setCapability(MobileCapabilityType.APP,app.getPath());
      		 
     			
     			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
     		
     			
     			//cap.setCapability("autoGrantPermissions", true);
     		   cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
     			
     		    //URL url = new URL("http://127.0.0.1:4723/wd/hub"); 
     	    	 driver = new AndroidDriver(service,cap); //call service here after appium server start by service.start() 
     	    	 
     	    		
     	    	System.out.println("******************  capabilities are successfully taken ****************"); 
     			
     	    	//implicitwait 
     	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     				
     		    System.out.println("******************  SuperBaseClass setup is successfully run ****************"); 
     		    
     } catch (Exception e) {

     	System.out.println("Error cause message ...."+e.getMessage());
     	System.out.println("cause is:...."+e.getCause());
     	e.printStackTrace();
     	System.out.println("******************  Device is not connected or please check your device ****************"); 
     	// TODO: handle exception
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
	public void test() throws InterruptedException {
	
		System.out.println("SuperBaseclass Test is run....");
		
	
	}
	
	
	public void eCommereceAppForm() {
	   	 
	   	 try {
	   			
	   		 System.out.println("******************* BaseClassAutoServer:- eCommereceAppForm() is start ****************");
	   		 
	   		 
	   		 
	   		 driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Afghanistan']")).click();
	   		   System.out.println("****** Clicked on country list ********");
	   		   
	   		   driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))")).click();
	   		   System.out.println("****** List is scrolled Australia is selected from list ********");
	   		   
	   		   driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("Achal");
	   		   System.out.println("****** Enter name is 'Your Name' field ********");
	   		   
	   		   driver.hideKeyboard();
	   		   System.out.println("****** Keyboard is hide ********");
	   		   
	   		   driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text='Female']")).click();
	   		   System.out.println("****** Gender 'Female' is selected ********");
	   		   
	   		   driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button")).click();
	   		   System.out.println("****** Clicked on 'Let's shop' to submit form ********");
	   		  
	   		   
	   		   System.out.println("******************* BaseClassAutoServer:- eCommereceAppForm() is finished ****************");
	   		
	   		
	   	} catch (NotFoundException e) {
	   		// TODO: handle exception
	   		System.out.println("cause is:...."+e.getCause());
	   		System.out.println("Error cause message ...."+e.getMessage());
	   		e.printStackTrace();
	   		System.out.println("******************* BaseClass:- submitform() is not run ****************");
	   	}
	
}
	
	
public void longPressAction(WebElement ele) throws InterruptedException{
		
		//Long press action by JavascriptExecutor
		  ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
		   Thread.sleep(2000);
	}

public void swipeaction(WebElement imagesElements,String direction) {
	
	 //Swipe by javascriptExecutor :SwipeGesture
	   ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",ImmutableMap.of("elementId",((RemoteWebElement)imagesElements).getId(),"direction",direction,"percent",0.75,"speed", 500));
	   System.out.println("****** Image is swiped ********");
	   
}
}
