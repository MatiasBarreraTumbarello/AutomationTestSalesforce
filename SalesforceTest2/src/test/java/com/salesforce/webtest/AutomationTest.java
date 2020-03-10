package com.salesforce.webtest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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
		driver.get("https://test1dom--sit.my.salesforce.com/secur/frontdoor.jsp?sid=00Dc0000003lOc8!ARsAQKMaCa1WmbO7z7tm2pJj64Uzf.kuDoXPogLaqzE.aGYT0_JokvR4QOEEHyMb_Nt7kR67sxuUMvz0CUPDm5ORrg7jp8jy");
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		Thread.sleep(20000);
		
	}
	
	@Test
	public void testScript() throws InterruptedException {
		//----------------------------------cuenta Siebel 19991993 ---------------------
		driver.switchTo().frame(0);
		Select picklist = new Select(driver.findElement(By.id("selectAccountOrTlfn")));
		picklist.selectByIndex(2);
		
		driver.findElement(By.xpath("//input[@id='seibelUser']")).sendKeys("19991993");

		//Thread.sleep(4000);
		//Botón: Buscar Cliente
		
		WebElement res = new WebDriverWait(driver, 40)
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='IP_validClient']")));

		driver.findElement(By.id(res.getAttribute("id"))).click();
		
		WebElement res1 = new WebDriverWait(driver, 40)
		        .until(ExpectedConditions.elementToBeClickable(By.id("RadioUpdateDatosSeibel")));

		//driver.findElement(By.xpath("//div[@id='IP_validClient']")).click();
		//Thread.sleep(4000);

		// Cambiar indice a 1 para seleccionar opcion "si"
		RoynerClass.actualizarCliente(driver, 0);
		
		WebElement res2 = new WebDriverWait(driver, 40)
		        .until(ExpectedConditions.elementToBeClickable(By.id("block_0")));

		//------------------------------------PLANES-----------------------
		/*Aca se puede comentar o descomentar según sea necesario probar*/
		NelsonClass nc = new NelsonClass();
		WebDriverWait wait = new WebDriverWait (driver, 30);
		WebElement plan =driver.findElement(By.xpath("//*[@id=\'block_0\']"));
		WebElement siguientePlan = driver.findElement(By.xpath("//div[@id=\'PlanSelection_nextBtn\']/p"));
		nc.planesPrimero(driver, plan, 20, siguientePlan);
		Thread.sleep(4000);
		
		
		
		
		
		//-----------------------Seccion: Validacion de Dispositivos
		
		/* Para esta seccion es necesario comentar uno de los 2 codigos (IMEI o Dispositivos)*/
		
		MatiasClass mc = new MatiasClass();
		//mc.validacionImei(driver, 20);
		mc.validacionDispositivo(driver, 20);
		
		
		
		//----------------------Portabilidad------------------------------
		//nc.portabilidadNo(driver);
		//nc.portabilidadSi(driver);
		
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
