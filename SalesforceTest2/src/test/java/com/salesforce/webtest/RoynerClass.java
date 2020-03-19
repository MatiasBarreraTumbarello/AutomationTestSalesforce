package com.salesforce.webtest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RoynerClass{
	
	public static void actualizarCliente(WebDriver driver, Integer index) throws InterruptedException {
		new WebDriverWait(driver, 40)
        	.until(ExpectedConditions.elementToBeClickable(By.id("RadioUpdateDatosSeibel")));
		List<WebElement> opt = driver.findElements(By.xpath("//*[@id=\'RadioUpdateDatosSeibel\']"));
		Thread.sleep(2000);
		opt.get(index).findElement(By.xpath("./..")).click();
		Thread.sleep(2000);
		//
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("slds-spinner_container")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("SearchClient_nextBtn")));
		//
		driver.findElement(By.xpath("//*[@id=\'SearchClient_nextBtn\']/p")).click();
		Thread.sleep(2000);
		
		if(index == 1)
			informacionDeCliente(driver);
	}

	public static void informacionDeCliente(WebDriver driver) throws InterruptedException {	
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("slds-spinner_container")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("TextNumberPhone")));
		WebElement phone = driver.findElement(By.id("TextNumberPhone"));
		phone.clear();
		phone.sendKeys("5569310423");
		Thread.sleep(2000);
		
		WebElement email = driver.findElement(By.id("TextEmail"));
		email.clear();
		email.sendKeys("scardozo@labsxd.com");
		Thread.sleep(1000);
		driver.findElement(By.id("CheckboxPrincipal")).findElement(By.xpath("./..")).click();
		WebElement res = new WebDriverWait(driver, 40)
		        .until(ExpectedConditions.elementToBeClickable(By.id("AditionalInfo_nextBtn")));
		
		Thread.sleep(2000);
		driver.findElement(By.id(res.getAttribute("id"))).click();
		
		Thread.sleep(2000);
	}
	
	public static void tipoDeEntrega(WebDriver driver) throws InterruptedException {
		new WebDriverWait(driver, 40)
		        .until(ExpectedConditions.elementToBeClickable(By.id("RadioProfileNoVentas")));
		//List<WebElement> opt = driver.findElements(By.id("RadioProfileNoVentas"));
		driver.findElement(By.id("RadioProfileNoVentas")).findElement(By.xpath("./..")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("StepSaleProcessDevice_nextBtn")).click();
		Thread.sleep(5000);
	}
	
	public static void seleccionDeDispositivo(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("slds-spinner_container")));
		WebElement opt = new WebDriverWait(driver, 40)
		        .until(ExpectedConditions.elementToBeClickable(By.id("block_01t3K000000HEDoQAO")));
		opt.findElement(By.xpath("./..")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("slds-spinner_container")));
		driver.findElement(By.id("vlcCart_Top")).findElement(By.xpath(".//div[1]")).click();
		WebElement btn = driver.findElement(By.id("StepChooseDevices_nextBtn"));
		while(btn.isEnabled() && btn.isDisplayed()) {
			Thread.sleep(1000);
			btn.click();
		}
		Thread.sleep(2000);
	}
	
	public static void dispositivos(WebDriver driver, Integer index) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("slds-spinner_container")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("RadioDevices")));
		List<WebElement> opt = driver.findElements(By.id("RadioDevices"));
		opt.get(index).findElement(By.xpath("./..")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("StepDevicesSelect_nextBtn")).click();
		Thread.sleep(5000);
	}

}