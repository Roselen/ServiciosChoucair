package com.servicios.choucair;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PruebasUsabilidadTest {
	
	private WebDriver driver;
	
	@Before
	public void setUpPruebasUsabilidad() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/servicio/");
	}
	
	@Test
	public void testPruebasUsabilidad() {
		WebElement btnPortafolio = driver.findElement(By.xpath("//div[@class='elementor-element elementor-element-ef51f36 elementor-position-top elementor-vertical-align-top elementor-widget elementor-widget-image-box']//div[@class='elementor-image-box-wrapper']"));
		btnPortafolio.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if(driver.findElement(By.id("portafolio")) != null) {
			assertTrue("Prueba exitosa", true);
		}else {
			fail("Prueba fallida");
		}
		
		WebElement btnPruebasUsabilidad = driver.findElement(By.xpath("//div[contains(@class,'elementor-element elementor-element-3003798 elementor-position-top elementor-vertical-align-top elementor-widget elementor-widget-image-box')]//div[contains(@class,'elementor-image-box-wrapper')]"));
		btnPruebasUsabilidad.click();
		
		if(driver.findElement(By.id("usabilidad")) != null) {
			assertTrue("Prueba exitosa", true);
		}else {
			fail("Prueba fallida");
		}
		
		if (driver.findElement(By.xpath("//i[@class='fa fa-angle-up']")).isDisplayed()) { //Volver arriba
			driver.findElement(By.xpath("//i[@class='fa fa-angle-up']")).click();
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
	public void tearDownPruebasUsabilidad() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.quit();
	} 

}
