package com.salesforce.webtest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RoynerClass{
	
	public static void actualizarCliente(WebDriver driver) throws InterruptedException {
		int index = 1;
		List<WebElement> opt = driver.findElements(By.xpath("//*[@id=\'RadioUpdateDatosSeibel\']"));
		Thread.sleep(4000);
		opt.get(0).findElement(By.xpath("./..")).click();
		Thread.sleep(2000);
		//
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("slds-spinner_container")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("SearchClient_nextBtn")));
		//
		driver.findElement(By.xpath("//*[@id=\'SearchClient_nextBtn\']/p")).click();
		Thread.sleep(2000);
		
//		if(index == 1)
//s			informacionDeCliente(driver);
	}

	public static void informacionDeCliente(WebDriver driver) throws InterruptedException {		
		WebElement phone = driver.findElement(By.id("TextNumberPhone"));
		phone.clear();
		phone.sendKeys("5518497468");
		Thread.sleep(2000);
		
		WebElement email = driver.findElement(By.id("TextEmail"));
		email.clear();
		email.sendKeys("scardozo@labsxd.co");
		WebElement res = new WebDriverWait(driver, 40)
		        .until(ExpectedConditions.elementToBeClickable(By.id("AditionalInfo_nextBtn")));
		
		driver.findElement(By.id(res.getAttribute("id"))).click();
	}
	
	public static void tipoDeEntrega(WebDriver driver, Integer index) throws InterruptedException {
		new WebDriverWait(driver, 40)
		        .until(ExpectedConditions.elementToBeClickable(By.id("RadioProfileNoVentas")));
		List<WebElement> opt = driver.findElements(By.id("RadioProfileNoVentas"));
		opt.get(index).findElement(By.xpath("./..")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("StepSaleProcessDevice_nextBtn")).click();
		Thread.sleep(5000);
		if(index == 1)
			Thread.sleep(5000);
	}
	
	public static void seleccionDeDispositivo(WebDriver driver) throws InterruptedException {
		WebElement opt = new WebDriverWait(driver, 40)
		        .until(ExpectedConditions.elementToBeClickable(By.id("block_01t3K000000HEDoQAO")));
		opt.findElement(By.xpath("./..")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("StepChooseDevices_nextBtn")).click();
		Thread.sleep(2000);
	}

}