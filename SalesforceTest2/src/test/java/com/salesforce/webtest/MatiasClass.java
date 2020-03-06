package com.salesforce.webtest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MatiasClass {

	public MatiasClass() {}
	
	
	public void validacionImei(WebDriver driver) {
	{
		try {
			
			List<WebElement> mdv = driver.findElements(By.id("RadioSelectMethod"));
			mdv.get(0).findElement(By.xpath("./..")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//input[@id=\'NumberIMEI\']")).sendKeys("355576090532169");
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@id=\'IPAValidateIMEI\']/p")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@id='StepApprovedDevice_nextBtn']")).click();
			Thread.sleep(10000);
			
				} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}	
		
	}
	
	
	public void validacionDispositivo(WebDriver driver) {
		try {
			
			List<WebElement> mdv = driver.findElements(By.id("RadioSelectMethod"));
			mdv.get(1).findElement(By.xpath("./..")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//select[@id=\'SelectBrand\']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//option[@label='BITTIUM']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//select[@id=\'SelectModel\']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//option[@label='Tough Mobile']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@id='StepApprovedDevice_nextBtn']")).click();
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void botonEntregaEnSucursal(WebDriver driver) {
		try {										
			driver.findElement(By.xpath("//div[@id=\'DeliveryHomeSummary_nextBtn\']/p")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@id=\'StockBranches_nextBtn\']/p")).click();  //Seccion "Entrega en Sucursal"
			Thread.sleep(20000); //20 segundos para chequear info
			driver.findElement(By.xpath("//div[@id=\'DeliveryHomeSummary_nextBtn\']/p")).click();
			//Nos muestra el numero de pedido 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void botonEntregaEnDomicilio(WebDriver driver) {
		try {
			driver.findElement(By.xpath("//div[@id=\'DeliveryHomeSummary_nextBtn\']/p")).click();
			Thread.sleep(10000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
