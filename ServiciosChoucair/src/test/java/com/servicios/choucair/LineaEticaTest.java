package com.servicios.choucair;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LineaEticaTest {

	private WebDriver driver;
	
	@Before
	public void setUpLineaEtica() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/servicio/");
	}
	
	@Test
	public void testLineaEtica() {		
		WebElement lnkLineaEtica = driver.findElement(By.xpath("//strong[contains(text(),'LÍNEA ÉTICA')]"));
		lnkLineaEtica.click();
				
		String pageURL = driver.getCurrentUrl();
		//assertEquals(pageURL, "https://www.choucairtesting.com/wp-content/uploads/2018/09/Codigo-de-buen-gobierno.pdf");
				
		int resultado = pageURL.indexOf("to=lineaetica@choucairtesting.com");
		
		if(resultado != -1) {//Se encuentra
			assertTrue("Prueba exitosa", true);
		}else {
			fail("Prueba fallida");
		}
		
		driver.navigate().back(); //Volver atrás
		
		if (driver.findElement(By.xpath("//a[contains(@class,'go-top show')]")).isDisplayed()) { //Volver arriba
			driver.findElement(By.xpath("//a[contains(@class,'go-top show')]")).click();
			if(driver.findElement(By.xpath("//div[@class='elementor-element elementor-element-bd039e7 elementor-widget elementor-widget-image animated fadeIn']//img[@class='attachment-full size-full']")) != null) {//Img slider
				assertTrue("Prueba exitosa", true);
			}else {
				fail("Prueba fallida");
			}
		}else {
			fail("Prueba fallida");
		}
	}
	
	@After
	public void tearDownLineaEtica() {
		driver.quit();
	} 
}
