package utilityPackage;

import java.security.PublicKey;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.Test;
import org.w3c.dom.DOMException;

import com.beust.jcommander.converters.BooleanConverter;
import com.google.common.collect.ImmutableMap;

import baseclassPackage.BaseClassAutoServer;
import baseclassPackage.SuperBaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class SwipeTillLast extends SuperBaseClass {
	
	@SuppressWarnings("unused")
	@Test
	public void swipeTest() {
		
		
try {
			
			System.out.println("*******************  SwipeTest() is Start ****************");
			   
			   
			  
			   
			   Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.view.Gallery1");
				 driver.startActivity(activity);
				 System.out.println("****** App start from Activity: ApiDemos ********");
				 
				 
			   
			   //SWIPE Multiple Images (three times)
//				 wait = new WebDriverWait(driver,Duration.ofSeconds(0));
//				 List<WebElement> imagesElements2 = driver.findElements(AppiumBy.className("android.widget.ImageView"));
//				 wait.until(ExpectedConditions.visibilityOfAllElements(imagesElements2));
//				 for (WebElement webElement2 : imagesElements2) {
//					 
//					 System.out.println("*******************  Second for loop ****************");
//					 swipeaction(webElement2, "left");
//					  
//				 }
			
				  //SWIPE functionality untill last images with multiple for loops
         
		try {
			
			
			 wait = new WebDriverWait(driver,Duration.ofSeconds(0));
			 List<WebElement> imagesElements1 = driver.findElements(AppiumBy.className("android.widget.ImageView"));
			 wait.until(ExpectedConditions.visibilityOfAllElements(imagesElements1));
			
			 
//		     List<WebElement> imagesElements2 = driver.findElements(AppiumBy.className("android.widget.ImageView"));
			    for (WebElement webElement1 : imagesElements1) {
				      
			    	
			    	if(imagesElements1.size()> 0) {
						 swipeaction(webElement1, "left");
						 System.out.println("*******************  if condition: first loop ****************");
					 }	  
			    	else {
			    		System.out.println("*******************  break by first loop ****************");
						 break;   
					}
					 
					 Thread.sleep(3000);
					 wait = new WebDriverWait(driver,Duration.ofSeconds(0));
					 List<WebElement> imagesElements2 = driver.findElements(AppiumBy.className("android.widget.ImageView"));
					 wait.until(ExpectedConditions.visibilityOfAllElements(imagesElements2));
					 for (WebElement webElement2 : imagesElements2) {
						 
						 System.out.println("*******************  Second for loop ****************");
						 swipeaction(webElement2, "left");
						  
					 }
					 
					 Thread.sleep(3000);
					 wait = new WebDriverWait(driver,Duration.ofSeconds(0));
					 List<WebElement> imagesElements3 = driver.findElements(AppiumBy.className("android.widget.ImageView"));
					 wait.until(ExpectedConditions.visibilityOfAllElements(imagesElements3));
					 for (WebElement webElement3 : imagesElements3) {
						 
						 if(imagesElements3.size()>= 0){
							 System.out.println("*******************  Third for loop: get size *****  "+imagesElements3.size());
							 swipeaction(webElement3, "left");
							 System.out.println("*******************  if condition: Third for loop ****************");
						 }
					   
					 }
					 break;
					           
		          }
			
		}
		catch (DOMException d) {
			// TODO: handle exception
			 System.out.println("******************* DOM Error message ****************"+d.getLocalizedMessage());
			d.printStackTrace();
		}
		catch (StaleElementReferenceException s) {
			// TODO: handle exception
			 System.out.println("******************* Stale Error message ****************"+s.getLocalizedMessage());
			s.printStackTrace();
		}		 
		
		catch (Exception e) {
			// TODO: handle exception
			 System.out.println("*******************  Error message ****************"+e.getLocalizedMessage());
			e.printStackTrace();
		}	
		
				
//					  
//		 
				 
			 
				 
			 
			   
			   

			  // System.out.println("****** ScrollToEnd() is run ********");
			   
			   
			   
			   
			 
			
			   
			   
				System.out.println("******  SwipeTest() is run successfully  ******");
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error cause message ...."+e.getMessage());
			System.out.println("cause is:...."+e.getCause());
			e.printStackTrace();
		}
		
		
	}

}
