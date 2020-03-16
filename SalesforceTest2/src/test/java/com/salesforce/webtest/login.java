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



public class login 
	{
		public void iniciar(WebDriver driver) { 
		
	
	/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\Francisco A\\eclipse-workspace\\IzziTest\\src\\test\\resources\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(); 
		
		driver.get("https://test1dom--sit.my.salesforce.com/secur/frontdoor.jsp?sid=00Dc0000003lOc8!ARsAQFkyWQfFxsGUwshCRAMoFuk_pEibScH79uVMVhwYtVnKmj0JGN0rNmEcCyzFzHtHmI.hf4f_AdrnL0yO0F0n8BZSPBZw");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		Thread.sleep(5000);
			*/				
			try {
				
				// Despliega la Picklist-->
				Select picklist = new Select(driver.findElement(By.id("selectAccountOrTlfn")));
										
				// Selección Cuenta Siebel-->							
				picklist.selectByIndex(2);						
				Thread.sleep(2000);
				
				// Setea dígitos campo-->
				driver.findElement(By.xpath("//input[@id='seibelUser']")).sendKeys("19976285");
				Thread.sleep(2000);
									
				// Botón: Buscar Cliente-->
				driver.findElement(By.xpath("//div[@id='IP_validClient']")). click();
				Thread.sleep(9000);
									
					// Selección Modf datos cliente-->											
					List<WebElement> opt = driver.findElements(By.id("RadioUpdateDatosSeibel"));
					opt.get(0).findElement(By.xpath("./..")).click();				
					Thread.sleep(15000);
					
				// Siguiente								
				driver.findElement(By.id("SearchClient_nextBtn")). click();
				Thread.sleep(2000);
										
				// Imprime error-->
										
				}
			catch(Exception e)
			{
						System.out.println("error = "+e.getMessage());
				}
	
				System.out.println("termino el tiempo");				
	
		
		
		
		
	}
	
}
