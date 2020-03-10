package com.salesforce.webtest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MatiasClass {
	public int tiempo= 5000;
	public MatiasClass() {}
	public List<WebElement> mdv;
	public WebElement boton;
	
	public void validacionImei(WebDriver driver, int timeout) {
	{
		try {
			
			mdv = driver.findElements(By.id("RadioSelectMethod"));
			mdv.get(0).findElement(By.xpath("./.."));
			new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(mdv.get(0)));
			mdv.get(0).click();
			Thread.sleep(tiempo);
			driver.findElement(By.xpath("//input[@id=\'NumberIMEI\']")).sendKeys("355576090532169");
			//Thread.sleep(5000);
			
			boton = driver.findElement(By.xpath("//div[@id=\'IPAValidateIMEI\']/p"));
			new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(boton));
			boton.click();
			Thread.sleep(tiempo);
			boton = driver.findElement(By.xpath("//div[@id='StepApprovedDevice_nextBtn']"));
			new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(boton));
			boton.click();
			Thread.sleep(tiempo);
			
				} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}	
		
	}
	
	
	public void validacionDispositivo(WebDriver driver, int timeout) {
		try {
			
			mdv = driver.findElements(By.id("RadioSelectMethod"));
			mdv.get(1).findElement(By.xpath("./.."));
			new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(mdv.get(1)));
			mdv.get(1).click();

			Thread.sleep(tiempo);
			driver.findElement(By.xpath("//select[@id=\'SelectBrand\']")).click();
			//Thread.sleep(3000);
			driver.findElement(By.xpath("//option[@label='BITTIUM']")).click();
			//Thread.sleep(3000);
			driver.findElement(By.xpath("//select[@id=\'SelectModel\']")).click();
			//Thread.sleep(3000);
			driver.findElement(By.xpath("//option[@label='Tough Mobile']")).click();
			boton = driver.findElement(By.xpath("//div[@id='StepApprovedDevice_nextBtn']"));
			new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(boton));
			boton.click();
			Thread.sleep(tiempo);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void botonEntregaEnSucursal(WebDriver driver) {
		try {	
			driver.findElement(By.xpath("//div[@id=\'StockBranches_nextBtn\']/p")).click();  //Seccion "Entrega en Sucursal"
			Thread.sleep(tiempo); //20 segundos para chequear info
			driver.findElement(By.xpath("//div[@id=\'DeliveryHomeSummary_nextBtn\']/p")).click();
			Thread.sleep(tiempo);
			driver.findElement(By.xpath("//div[@id=\'FinishMsg_nextBtn\']/p")).click();
			Thread.sleep(tiempo);
			//Nos muestra el numero de pedido 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void resumenDeCompraDomicilio(WebDriver driver) {
		try {
			driver.findElement(By.xpath("//div[@id=\'DeliveryHomeSummary_nextBtn\']/p")).click();
			Thread.sleep(tiempo);
			driver.findElement(By.xpath("//div[@id=\'FinishMsg_nextBtn\']/p")).click();
			Thread.sleep(tiempo);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
