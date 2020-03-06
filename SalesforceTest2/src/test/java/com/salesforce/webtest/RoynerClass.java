package com.salesforce.webtest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RoynerClass{
	
	public static void actualizarCliente(WebDriver driver, Integer index) throws InterruptedException {
		List<WebElement> opt = driver.findElements(By.id("RadioUpdateDatosSeibel"));
		opt.get(index).findElement(By.xpath("./..")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("SearchClient_nextBtn")).click();
		Thread.sleep(10000);
		
		if(index == 1)
			informacionDeCliente(driver);
	}

	public static void informacionDeCliente(WebDriver driver) throws InterruptedException {		
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
	
	public static void tipoDeEntrega(WebDriver driver, Integer index) throws InterruptedException {
		List<WebElement> opt = driver.findElements(By.id("RadioProfileNoVentas"));
		opt.get(index).findElement(By.xpath("./..")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("StepSaleProcessDevice_nextBtn")).click();
		Thread.sleep(10000);
		if(index == 1)
			Thread.sleep(20000);
	}

}