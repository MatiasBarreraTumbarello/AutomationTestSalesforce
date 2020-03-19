package com.salesforce.webtest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MatiasClass {
	public MatiasClass() {}
	
	//Este metodo se utiliza una vez elegido la opcion "Trae tu equipo a IZZI" en la seccion: Dispositivo
	//Solo puede elegir entre la validacion por IMEI o validacion por disposiivo
	public static void validacionImei(WebDriver driver) {
	{
		try {
			int tiempo= 5000;
			new WebDriverWait(driver, 40)
			        .until(ExpectedConditions.elementToBeClickable(By.id("RadioSelectMethod")));
			List<WebElement> mdv = driver.findElements(By.id("RadioSelectMethod"));
			Thread.sleep(tiempo);
			mdv.get(0).findElement(By.xpath("./..")).click();
			Thread.sleep(tiempo);
			driver.findElement(By.xpath("//input[@id=\'NumberIMEI\']")).sendKeys("355576090532169");
			//Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@id=\'IPAValidateIMEI\']/p")).click();
			Thread.sleep(tiempo);
			driver.findElement(By.xpath("//div[@id='StepApprovedDevice_nextBtn']")).click();
			Thread.sleep(tiempo);
				} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}	
		
	}
	
	//Este metodo se utiliza una vez elegido la opcion "Trae tu equipo a IZZI" en la seccion: Dispositivo
	//Solo puede elegir entre la validacion por IMEI o validacion por disposiivo
	public static void validacionDispositivo(WebDriver driver) {
		try {
			int tiempo= 5000;
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("slds-spinner_container")));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("RadioSelectMethod")));
			List<WebElement> mdv = driver.findElements(By.id("RadioSelectMethod"));
			Thread.sleep(tiempo);
			mdv.get(1).findElement(By.xpath("./..")).click();

			Thread.sleep(tiempo);
			driver.findElement(By.xpath("//select[@id=\'SelectBrand\']")).click();
			//Thread.sleep(3000);
			driver.findElement(By.xpath("//option[@label='BITTIUM']")).click();
			//Thread.sleep(3000);
			driver.findElement(By.xpath("//select[@id=\'SelectModel\']")).click();
			//Thread.sleep(3000);
			driver.findElement(By.xpath("//option[@label='Tough Mobile']")).click();
			//Thread.sleep(tiempo);
			driver.findElement(By.xpath("//div[@id='StepApprovedDevice_nextBtn']")).click();
			Thread.sleep(tiempo);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Este metodo es el paso final de la gestion de compra, donde se muestra el resumente y pasa a la siguiente pestaña de finalizar compra
	public static void resumenDeCompra(WebDriver driver) {
		try {
			int tiempo= 5000;
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("slds-spinner_container")));
			WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=\'DeliveryHomeSummary_nextBtn\']/p")));
			while(btn.isDisplayed() && btn.isEnabled()) {
				Thread.sleep(1000);
				btn.click();
			}
			Thread.sleep(tiempo);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("slds-spinner_container")));
			WebElement btnFinish = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=\'slds-button slds-button_brand ng-binding\']")));
			btnFinish.click();
			Thread.sleep(tiempo);
			//Nos muestra el numero de pedido 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
