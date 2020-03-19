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
		driver.get("https://test1dom--sittest.my.salesforce.com/secur/frontdoor.jsp?sid=00D3K0000008jQa!ARwAQKDfWhyXEp3pcOXNmX7nXrtovNuyNmfS17th.3bUuaoK.6D0aYNcUXyUawxx7Rq6cO554gnOrO8tQ.H.lRKlL9KA0JoA");
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	
		//new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));

		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		Thread.sleep(20000);
		
	}
	
	@Test
	public void testScript() throws InterruptedException {
		NelsonClass nc = new NelsonClass();
		
		
		//--------------------------------- Cuenta Siebel  ---------------------
		driver.switchTo().frame(0);
		Select picklist = new Select(driver.findElement(By.id("selectAccountOrTlfn")));
		picklist.selectByIndex(2);
		
		driver.findElement(By.xpath("//input[@id='seibelUser']")).sendKeys("19964717");

		//Boton: Buscar Cliente
		
		WebElement res = new WebDriverWait(driver, 40)
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='IP_validClient']")));

		driver.findElement(By.id(res.getAttribute("id"))).click();
		
		new WebDriverWait(driver, 40)
		        .until(ExpectedConditions.elementToBeClickable(By.id("RadioUpdateDatosSeibel")));


		// Para la seleccion de actualizacion utilizar indices: 1 = "si", 0 = "no"
		RoynerClass.actualizarCliente(driver, 1);
		//driver.quit();
		

		//------------------------------------PLANES-----------------------
		/*Aca se puede comentar o descomentar seg�n sea necesario probar*/
		
		NelsonClass.planesActualizado(driver);
		Thread.sleep(4000);
		
		//-----------------------Seccion: Dispositivos
		
		RoynerClass.dispositivos(driver, 1);
		
		// Solo funciona al seleccionar Compra de Equipo
		RoynerClass.seleccionDeDispositivo(driver);
		
		
		//----------- Check: No estoy interesado en estos equipos.
		
		//FranciscoClass.desinteresEquipo(driver);
		
		
		//-----------------------Seccion: Validacion de Dispositivos
		/* Para esta seccion es necesario comentar uno de las 2 lineas de codigos siguientes (IMEI o Dispositivos)*/
		
		
		//mc.validacionImei(driver);
		//MatiasClass.validacionDispositivo(driver);
		
		
		
		//----------------------Portabilidad------------------------------
		
		
		nc.portabilidadNo(driver);
		
		
		//--------------------------------
		RoynerClass.tipoDeEntrega(driver);
		
		
		
		//----------------------Seccion: Resumen de Compra
		//mc.resumenDeCompraDomicilio(driver);
		MatiasClass.resumenDeCompra(driver);
		
		
		
		
		Thread.sleep(3000);

	}
	
	/*@After
	public void tearDown() {
		driver.quit();
	}*/
	
	
	
	
}