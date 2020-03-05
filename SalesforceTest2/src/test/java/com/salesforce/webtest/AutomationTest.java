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
		driver.get("https://test1dom--sit.my.salesforce.com/secur/frontdoor.jsp?sid=00Dc0000003lOc8!ARsAQCJGjYcOzDX9q7VvU_6Fl7UvpYKNnsU9_BriQXfmQpHD6wVZ1WbiCOGXND4o97fXeeNSztXkVBUtsb.C5Unhlz5LLLN1");
		
		Thread.sleep(20000);
		
	}
	
	@Test
	public void testScript() throws InterruptedException {
		//----------------------------------cuenta Siebel 19991993 ---------------------
		driver.switchTo().frame(0);
		Select picklist = new Select(driver.findElement(By.id("selectAccountOrTlfn")));
		picklist.selectByIndex(2);
		
		driver.findElement(By.xpath("//input[@id='seibelUser']")).sendKeys("19991993");

		Thread.sleep(20000);
		//Botón: Buscar Cliente

		driver.findElement(By.xpath("//div[@id='IP_validClient']")).click();
		Thread.sleep(20000);
		//driver.findElement(By.xpath("//*[@id='RadioUpdateDatosSeibel' AND @value='no']")).click();
		List<WebElement> opt = driver.findElements(By.id("RadioUpdateDatosSeibel"));
		opt.get(0).findElement(By.xpath("./..")).click(); //seleccionamos el radio button "NO"
		
		driver.findElement(By.xpath("//*[@id=\'SearchClient_nextBtn\']/p")).click(); //linea generada por mi para seleccionar boton siguiente
		Thread.sleep(10000);
		
		/*opt.get(1).findElement(By.xpath("./..")).click();
		Thread.sleep(5000);
		
		RoynerClass.editClientInfo(driver);
		*/  //DESCOMENTAR ESTO SI SE QUIERE VER LA OPCION DE SI EN LA SECIION BUSCAR CIENTE

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
		
		Thread.sleep(20000);

	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}
