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
 
 
 public static void planesActualizado(WebDriver driver) throws InterruptedException{
	 WebDriverWait wait = new WebDriverWait(driver, 40);
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("slds-spinner_container")));
	 WebElement seleccionar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'block_01tc0000007pvuiAAA\']")));
	 seleccionar.findElement(By.xpath("//*[@id=\'block_01tc0000007pvuiAAA\']")).click();
	 
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("slds-spinner_container")));
	 WebElement siguiente = wait.until(ExpectedConditions.elementToBeClickable(By.id("PlanSelection_nextBtn")));
	 siguiente.click();
	 
	 Thread.sleep(10000);
 }
 
 public  void planesPrimero(WebDriver driver) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("slds-spinner_container")));
			WebElement plan = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'ChoosePlan\']/div/ng-include/a")));//*[@id="block_01tc0000007pvuiAAA"]
			//WebElement plan2 =driver.findElement(By.xpath("//*[@id=\'block_1\']"));
			Thread.sleep(tiempo);
			
			plan.findElement(By.xpath("//*[@id=\'ChoosePlan\']/div/ng-include/a")).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("slds-spinner_container")));
			Thread.sleep(tiempo);
			WebElement siguientePlan = new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'PlanSelection_nextBtn\']/p")));//*[@id="PlanSelection_nextBtn"]/p
			siguientePlan.click();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 

 
 public  void portabilidadNo(WebDriver driver) {
		
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(By.id("OptionPortability")));
			
			List<WebElement> web = driver.findElements(By.id("OptionPortability"));
			web.get(1).findElement(By.xpath("./..")).click();
			Thread.sleep(tiempo);
			
			driver.findElement(By.xpath("//*[@id=\'StepDeviceValidation_nextBtn\']/p")).click();
			Thread.sleep(tiempo);
			
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
