package com.salesforce.webtest;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class FranciscoClass 
	{
						
	
		//Compra de Equipo-> Check: No estoy interesado en estos equipos.
		
		public static void desinteresEquipo(WebDriver driver)throws InterruptedException {
		
			driver.findElement(By.id("CheckboxDontWantDevice")). click();
			Thread.sleep(2000);
			
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("slds-spinner_container")));
			driver.findElement(By.id("vlcCart_Top")).findElement(By.xpath(".//div[1]")).click();
			driver.findElement(By.id("StepChooseDevices_nextBtn")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.className("slds-button slds-button_brand ng-binding")). click();
			Thread.sleep(2000);
			
		}
}
	
