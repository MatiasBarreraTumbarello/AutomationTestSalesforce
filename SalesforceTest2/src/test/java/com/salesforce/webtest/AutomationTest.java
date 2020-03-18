package com.salesforce.webtest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationTest {
	
	private WebDriver driver;
	
	
	@Before
	public void setUp() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://test1dom--sittest.my.salesforce.com/secur/frontdoor.jsp?sid=00D3K0000008jQa!ARwAQBY0ZxwXgqMa5QFLaka5ocWZbOYsqmx68XF7oX.nqRiZD5.U2LujEdISpoLauCidE_j42k5nBtU9U24KlpxkWFacpdW0");
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	
		//new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));

		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		Thread.sleep(20000);
		
	}
	
	@Test
	public void testScript() throws InterruptedException {
		MatiasClass mc = new MatiasClass();
		NelsonClass nc = new NelsonClass();
		
		
		//----------------------------------cuenta Siebel 19991993 ---------------------
		driver.switchTo().frame(0);
		Select picklist = new Select(driver.findElement(By.id("selectAccountOrTlfn")));
		picklist.selectByIndex(2);
		
		driver.findElement(By.xpath("//input[@id='seibelUser']")).sendKeys("19964717");

		//Bot�n: Buscar Cliente
		
		WebElement res = new WebDriverWait(driver, 40)
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='IP_validClient']")));

		driver.findElement(By.id(res.getAttribute("id"))).click();
		
		new WebDriverWait(driver, 40)
		        .until(ExpectedConditions.elementToBeClickable(By.id("RadioUpdateDatosSeibel")));


		// Cambiar indice a 1 para seleccionar opcion "si"
		RoynerClass.actualizarCliente(driver, 1);
		

		//------------------------------------PLANES-----------------------
		/*Aca se puede comentar o descomentar seg�n sea necesario probar*/
		
		NelsonClass.planesActualizado(driver);
		Thread.sleep(4000);
		// driver.quit();
		
		//-----------------------Seccion: Dispositivos
		
		RoynerClass.dispositivos(driver, 0);
		
		// Solo funciona al seleccionar Compra de Equipo
		// RoynerClass.seleccionDeDispositivo(driver);
		
		
		//----------- Check: No estoy interesado en estos equipos.
		
		//FranciscoClass.desinteresEquipo(driver);
		
		
		//-----------------------Seccion: Validacion de Dispositivos
		/* Para esta seccion es necesario comentar uno de las 2 lineas de codigos siguientes (IMEI o Dispositivos)*/
		
		
		//mc.validacionImei(driver);
		mc.validacionDispositivo(driver);
		
		
		
		//----------------------Portabilidad------------------------------
		
		
		nc.portabilidadNo(driver);
		
		
		//--------------------------------
		RoynerClass.tipoDeEntrega(driver);
		
		
		
		//----------------------Seccion: Resumen de Compra
		//mc.resumenDeCompraDomicilio(driver);
		mc.resumenDeCompra(driver);
		
		
		
		
		Thread.sleep(3000);

	}
	
	/*@After
	public void tearDown() {
		driver.quit();
	}*/
	
	
	
	
}