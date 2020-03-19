package com.salesforce.webtest;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NelsonClass {
 //Esta variable se debe cambiar segun el retraso del servidor.
 public int tiempo= 4000;
 
 public NelsonClass() {}
 
 
 public static void planesActualizado(WebDriver driver) throws InterruptedException{
	 Thread.sleep(2000);
	 WebDriverWait wait = new WebDriverWait(driver, 40);
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("slds-spinner_container")));
	 WebElement seleccionar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'block_01tc0000007pvuiAAA\']")));
	 Thread.sleep(1000);
	 seleccionar.click();
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("slds-spinner_container")));
	 WebElement siguiente = wait.until(ExpectedConditions.elementToBeClickable(By.id("PlanSelection_nextBtn")));
	 while(siguiente.isEnabled() && siguiente.isDisplayed()) {
		 Thread.sleep(1000);
		 siguiente.click();
	 }
	 
	 
	 Thread.sleep(10000);
 }
 
 
 

 
 public  void portabilidadNo(WebDriver driver) {
		
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(By.id("OptionPortability")));
			Thread.sleep(1000);
			
			List<WebElement> web = driver.findElements(By.id("OptionPortability"));
			web.get(1).findElement(By.xpath("./..")).click();
			Thread.sleep(tiempo);
			
			WebElement btn = driver.findElement(By.xpath("//*[@id=\'StepDeviceValidation_nextBtn\']/p"));
			while(btn.isEnabled() && btn.isDisplayed()) {
				Thread.sleep(1000);
				btn.click();
			}
			Thread.sleep(tiempo);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 

//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


}
