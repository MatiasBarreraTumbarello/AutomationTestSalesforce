package com.salesforce.webtest;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomationTest {
	
	private WebDriver driver;
	
	
	@Before
	public void setUp() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://test1dom--sit.my.salesforce.com/secur/frontdoor.jsp?sid=00Dc0000003lOc8!ARsAQOIjf63jURW2O3jPPhnS_8n6eQgkyek9yD22A9yK3CzgWGjypSRPWiWVUSavG3MWauwhkjCDhETXfhnY7uE3ayjjZKTl");
		//driver.manage().deleteAllCookies();
		
		Thread.sleep(20000);
		
	}
	
	@Test
	public void testScript() throws InterruptedException {
		//----------------------------------cuenta Siebel 19991993 ---------------------
		driver.switchTo().frame(0);
		Select picklist = new Select(driver.findElement(By.id("selectAccountOrTlfn")));
		picklist.selectByIndex(2);
		
		driver.findElement(By.xpath("//input[@id='seibelUser']")).sendKeys("19991993");

		Thread.sleep(10000);
		//Botón: Buscar Cliente

		driver.findElement(By.xpath("//div[@id='IP_validClient']")).click();
		Thread.sleep(20000);

		// Cambiar indice a 1 para seleccionar opcion "si"
		RoynerClass.actualizarCliente(driver, 0);

		//------------------------------------PLANES-----------------------
		/*Aca se puede comentar o descomentar según sea necesario probar*/
		NelsonClass nc = new NelsonClass();
		nc.planesPrimero(driver); // Seleccion del plan izzi movil
		// nc.planesSegundo(driver);  // Seleccion del plan izzi movil adicional
		
		
		//-----------------------Seccion: Validacion de Dispositivos
		
		/* Para esta seccion es necesario comentar uno de los 2 codigos (IMEI o Dispositivos)*/
		
		MatiasClass mc = new MatiasClass();
		//mc.validacionImei(driver);
		mc.validacionDispositivo(driver);
		//----------------------Portabilidad------------------------------
		nc.portabilidadNo(driver);
		//nc.portabilidadSi(driver);
		
		// Cambiar indice a 1 para seleccionar opcion "sucursal"
		RoynerClass.tipoDeEntrega(driver, 1);
		
		
		
		//----------------------Seccion: Resumen de Compra
		//mc.resumenDeCompraDomicilio(driver);
		mc.botonEntregaEnSucursal(driver);
		
		
		
		
		Thread.sleep(20000);

	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}
