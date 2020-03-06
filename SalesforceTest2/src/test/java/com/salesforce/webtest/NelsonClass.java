package com.salesforce.webtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NelsonClass {
 public NelsonClass() {}
 public int tiempo= 5000;
 
 public  void planesPrimero(WebDriver driver) {
		
		try {
			driver.findElement(By.xpath("//*[@id=\'block_0\']")).click();
			Thread.sleep(tiempo);
			driver.findElement(By.xpath("//*[@id=\'PlanSelection_nextBtn\']/p")).click();
			Thread.sleep(10000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
 
 
 
 public void planesSegundo(WebDriver driver) {
		
		try {
			driver.findElement(By.xpath("//*[@id=\'block_1\']")).click();
			Thread.sleep(tiempo);
			driver.findElement(By.xpath("//*[@id=\'PlanSelection_nextBtn\']/p")).click();
			Thread.sleep(10000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
public void portabilidadNo(WebDriver driver) {
	 
	 try {
		 driver.findElement(By.xpath("//*[@id=\'OptionPortability|0\']/div/div[1]/label[2]/span[1]")).click();
		 Thread.sleep(tiempo);
		 driver.findElement(By.xpath("//*[@id='StepDeviceValidation_nextBtn']/p")).click();
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
}
