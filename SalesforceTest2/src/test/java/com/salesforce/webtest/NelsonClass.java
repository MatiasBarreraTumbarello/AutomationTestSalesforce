package com.salesforce.webtest;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NelsonClass {
 public NelsonClass() {}
 //Esta variable se debe cambiar segun el retraso del servidor.
 public int tiempo= 4000;
 
 
 public  void planesPrimero(WebDriver driver) {
		
		try {
			WebDriverWait wait = new WebDriverWait (driver, 40);
			WebElement plan =driver.findElement(By.xpath("//*[@id=\'block_0\']"));
			//WebElement plan2 =driver.findElement(By.xpath("//*[@id=\'block_1\']"));
			
			
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(plan));
			plan.click();
			Thread.sleep(tiempo);
			WebElement siguientePlan = driver.findElement(By.xpath("//div[@id=\'PlanSelection_nextBtn\']/p"));
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(siguientePlan));
			siguientePlan.click();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
 
 
 public  void planesSegundo(WebDriver driver, WebElement plan2, int timeout, WebElement siguientePlan) {
		
		try {
			
			new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(plan2));
			plan2.click();
			Thread.sleep(tiempo);
			new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(siguientePlan));
			siguientePlan.click();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
 public  void portabilidadNo(WebDriver driver) {
		
		try {
			
			List<WebElement> web = driver.findElements(By.id("OptionPortability"));
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(By.id("OptionPortability")));
			web.get(1).findElement(By.xpath("./..")).click();
			Thread.sleep(tiempo);
			
			WebElement siguientePorta = driver.findElement(By.id("StepDeviceValidation_nextBtn"));
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(siguientePorta));
			siguientePorta.click();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
public void portabilidadSi(WebDriver driver) {
	 
	 try {
		 driver.findElement(By.xpath("//*[@id=\'OptionPortability|0\']/div/div[1]/label[1]/span[1]")).click();
		 Thread.sleep(tiempo);
		 driver.findElement(By.xpath("//*[@id='StepDeviceValidation_nextBtn']/p")).click();
		Thread.sleep(tiempo);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 
}
//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


}
