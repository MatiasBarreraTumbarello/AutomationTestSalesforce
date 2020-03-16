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
		driver.get("https://test1dom--sittest.my.salesforce.com/secur/frontdoor.jsp?sid=00D3K0000008jQa!ARwAQMLE0Wb2.X5PNgeyvOwN9LM2RBY.SPh2LhoDSNjPZTzsIS7FzPelwIbzyY2Czk1QNg6xX6s7a6B6wx_n4cVCJJVYmUhm");
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));

		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		Thread.sleep(20000);
		
	}
	
	@Test
	public void testScript() throws InterruptedException {
		//----------------------------------cuenta Siebel 19991993 ---------------------
		driver.switchTo().frame(0);
		//new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(By.id("selectAccountOrTlfn")));
		Select picklist = new Select(driver.findElement(By.id("selectAccountOrTlfn")));
		picklist.selectByIndex(2);
		
		driver.findElement(By.xpath("//input[@id='seibelUser']")).sendKeys("19991993");

		//Thread.sleep(4000);
		//Bot�n: Buscar Cliente
		
		WebElement res = new WebDriverWait(driver, 40)
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='IP_validClient']")));

		driver.findElement(By.id(res.getAttribute("id"))).click();
		
		new WebDriverWait(driver, 40)
		        .until(ExpectedConditions.elementToBeClickable(By.id("RadioUpdateDatosSeibel")));

		//driver.findElement(By.xpath("//div[@id='IP_validClient']")).click();
		//Thread.sleep(4000);

		// Cambiar indice a 1 para seleccionar opcion "si"
		RoynerClass.actualizarCliente(driver, 0);
		
		new WebDriverWait(driver, 40)
		        .until(ExpectedConditions.elementToBeClickable(By.id("block_0")));

		//------------------------------------PLANES-----------------------
		/*Aca se puede comentar o descomentar seg�n sea necesario probar*/
		NelsonClass nc = new NelsonClass();
		
		nc.planesPrimero(driver);
		//nc.planesSegundo(driver, plan2, 20, siguientePlan);
		Thread.sleep(4000);
		
		
		// Solo funciona al seleccionar Compra de Equipo
		// RoynerClass.seleccionDeDispositivo(driver);
		
		
		//-----------------------Seccion: Validacion de Dispositivos
		
		/* Para esta seccion es necesario comentar uno de los 2 codigos (IMEI o Dispositivos)*/
		
		MatiasClass mc = new MatiasClass();
		//mc.validacionImei(driver);
		mc.validacionDispositivo(driver);
		
		
		
		//----------------------Portabilidad------------------------------
		
		
		//WebElement portabilidadNo =driver.findElement(By.xpath("//*[@id=\'block_0\']"));
		nc.portabilidadNo(driver);
		
		
		
		// Cambiar indice a 1 para seleccionar opcion "sucursal"
		RoynerClass.tipoDeEntrega(driver, 1);
		
		
		
		//----------------------Seccion: Resumen de Compra
		//mc.resumenDeCompraDomicilio(driver);
		mc.botonEntregaEnSucursal(driver);
		
		
		
		
		Thread.sleep(3000);

	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}
