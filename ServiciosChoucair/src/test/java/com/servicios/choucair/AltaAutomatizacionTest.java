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

public class AltaAutomatizacionTest {

	private WebDriver driver;
	
	@Before
	public void setUpAltaAutomatizacion() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/servicio/");
	}
	
	@Test
	public void testAltaAutomatizacion() {
		WebElement btnPortafolio = driver.findElement(By.xpath("//div[@class='elementor-element elementor-element-ef51f36 elementor-position-top elementor-vertical-align-top elementor-widget elementor-widget-image-box']//div[@class='elementor-image-box-wrapper']"));
		btnPortafolio.click();;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if(driver.findElement(By.id("portafolio")) != null) {
			assertTrue("Prueba exitosa", true);
		}else {
			fail("Prueba fallida");
		}
		
		WebElement btnAltaAutomatizacion = driver.findElement(By.xpath("//div[@class='elementor-element elementor-element-74eeaa2 elementor-position-top elementor-vertical-align-top elementor-widget elementor-widget-image-box']//img[@class='elementor-animation-grow attachment-full size-full']"));
		btnAltaAutomatizacion.click();
		
		if(driver.findElement(By.id("AltaAuto")) != null) {
			assertTrue("Prueba exitosa", true);
		}else {
			fail("Prueba fallida");
		}
		
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
	public void tearDownAltaAutomatizacion() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.quit();
	}
}
