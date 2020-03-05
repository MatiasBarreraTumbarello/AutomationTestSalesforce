package com.salesforce.webtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RoynerClass{

	public static void editClientInfo(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("SearchClient_nextBtn")).click();
		Thread.sleep(5000);
		
		WebElement phone = driver.findElement(By.id("TextNumberPhone"));
		phone.clear();
		phone.sendKeys("5518497468");
		Thread.sleep(2000);
		
		WebElement email = driver.findElement(By.id("TextEmail"));
		email.clear();
		email.sendKeys("scardozo@labsxd.co");
		Thread.sleep(2000);
		
		driver.findElement(By.id("AditionalInfo_nextBtn")).click();
	}

}