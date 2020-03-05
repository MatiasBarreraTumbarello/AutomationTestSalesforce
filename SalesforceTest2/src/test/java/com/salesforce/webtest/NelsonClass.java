package com.salesforce.webtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NelsonClass {
 public NelsonClass() {}
 
 
 public  void planesPrimero(WebDriver driver) {
		
		try {
			driver.findElement(By.xpath("//*[@id=\'block_0\']")).click();
			Thread.sleep(20000);
			driver.findElement(By.xpath("//*[@id=\'PlanSelection_nextBtn\']/p")).click();
			Thread.sleep(20000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
 
 
 
 public void planesSegundo(WebDriver driver) {
		
		try {
			driver.findElement(By.xpath("//*[@id=\'block_1\']")).click();
			Thread.sleep(15000);
			driver.findElement(By.xpath("//*[@id=\'PlanSelection_nextBtn\']/p")).click();
			Thread.sleep(20000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
public void portabilidadNo(WebDriver driver) {
	 
	 try {
		 driver.findElement(By.xpath("//*[@id=\'OptionPortability|0\']/div/div[1]/label[2]/span[1]")).click();
		 Thread.sleep(20000);
		 driver.findElement(By.xpath("//*[@id='StepDeviceValidation_nextBtn']/p")).click();
		Thread.sleep(20000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 
 }
}
