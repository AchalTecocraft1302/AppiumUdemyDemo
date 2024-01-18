package baseclassPackage;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
//import io.appium.java_client.android.AndroidTouchAction;
//import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
//import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseClassAutoServer {
	
	public static AndroidDriver mobiledriver = null;
	// public static AppiumDriver driver = null;
	//public static DriverService appiumDriverService = null;
	public static AppiumDriverLocalService service = null;
	public static AppiumServiceBuilder builder ;
	//public static IOSDriver mobiledriver;


	@SuppressWarnings("deprecation")
	@BeforeTest
	public <AndroidElement> void setup() throws MalformedURLException {
		
		System.out.println("*********** BaseclassAutoserver: BeforeTest is Start ******************");
		
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
        builder.build();

        //Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        System.out.println("**********************Appium Server Started via Java ************************************************");

      //API DEMOS APP  
   	 File app= new File("C:/Users/Achal Trivedi/eclipse-workspace/AppiumUdemyDemo/src/test/resources/apps/ApiDemos-debug.apk");
   	 
   	 //E-COMMERCE APP 
//     File app= new File("C:/Users/Achal Trivedi/eclipse-workspace/AppiumUdemyDemo/src/test/resources/apps/General-Store.apk");
		
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"vivo 1820");   //Pixel //OPPO A12 //vivo 1820 //Galaxy on7
		cap.setCapability(MobileCapabilityType.UDID,"JZBUSWZ9ROOBQ8ZD");   //emulator-5554 //oppoA12- HAEY95SKIFIJDI49 //vivo - JZBUSWZ9ROOBQ8ZD //sam on7 -d06c56ef
 	    cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");  //8.1 //9  //vivo - 8.1.0 //sam on7- 6.0.1
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
	    cap.setCapability("automationName", "UiAutomator2");
	    cap.setCapability(MobileCapabilityType.APP,app.getPath());
		//cap.setCapability("autoGrantPermissions", true);
	    //cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		
 		 mobiledriver = new AndroidDriver(service,cap);
 		
		 mobiledriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
			
		System.out.println("***************** BeforeTest Run successfully **************************");		
		 	   
			
	}

	
	public void longPressAction(WebElement ele){
		
		//Long press action by JavascriptExecutor
		  ((JavascriptExecutor)mobiledriver).executeScript("mobile: longClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
		   
	}

    public void scrollToEnd() {
    	
    	//2) JavaExecutor -scroll till end of screen
		   boolean canScrollMore;
		   do
		   {
		      canScrollMore = (Boolean) ((JavascriptExecutor) mobiledriver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 3.0  
				));
		      //code: verify if element is present or not
			   WebElement rating = mobiledriver.findElement(AppiumBy.androidUIAutomator(
					     "new UiScrollable(new UiSelector().scrollable(true))" +
				         ".scrollIntoView(new UiSelector().textContains(\"Hover Events\"))"));
			   rating.click();
			   System.out.println("*******************  Scroll to Element ****************");
			   System.out.println("****** screen is scrolled and clicked on found element ********");
		   }while(canScrollMore);
    	
    }

    
    public void eCommereceAppForm() {
   	 
   	 try {
   			
   		 System.out.println("******************* BaseClassAutoServer:- eCommereceAppForm() is start ****************");
   		 
   		 
   		 
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
   		  
   		   
   		   System.out.println("******************* BaseClassAutoServer:- eCommereceAppForm() is finished ****************");
   		
   		
   	} catch (NotFoundException e) {
   		// TODO: handle exception
   		System.out.println("cause is:...."+e.getCause());
   		System.out.println("Error cause message ...."+e.getMessage());
   		e.printStackTrace();
   		System.out.println("******************* BaseClass:- submitform() is not run ****************");
   	}
   	 
    }
    
    public void swipeaction(WebElement element,String direction) {
    	
    	 //Swipe by javascriptExecutor :SwipeGesture
		   ((JavascriptExecutor)mobiledriver).executeScript("mobile: swipeGesture",ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"direction",direction,"percent",0.75));
		   System.out.println("****** Image is swiped ********");
    }

    
    
    
	@AfterTest 
	public void teardown() throws InterruptedException {
	
		System.out.println("******* teardown() is start *********");
		System.out.println("------------- Program run successfully ------------------- ");
		Thread.sleep(3000);
        mobiledriver.quit();
		System.out.println("************** Application is CLosed ********************");
		
		
		service.close();
		System.out.println("************** Appium Server closed via Java ********************");
		
			
		System.out.println("******* teardown() is finished *********");	 
	
	}
	
//	@Test 
//	public void test() {
//		
//		System.out.println("****** BaseclassAutoserver: Test() is run  ******");
//	
//	}
	
	
}


// Socket hung up issue arise than follow below command
//Stop appium server and run below command
//adb uninstall io.appium.uiautomator2.server
//adb uninstall io.appium.uiautomator2.server.test
//start appium server and execute your scripts ..it will work
