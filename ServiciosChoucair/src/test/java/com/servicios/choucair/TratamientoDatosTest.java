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

public class TratamientoDatosTest {

	private WebDriver driver;
	
	@Before
	public void setUpTratamientoDatos() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/servicio/");
	}
	
	@Test
	public void testTratamientoDatos() {		
		WebElement lnkTratamientoDatos = driver.findElement(By.xpath("//strong[contains(text(),'TRATAMIENTO DE DATOS |')]"));
		lnkTratamientoDatos.click();
		
		if(driver.findElement(By.xpath("//h2[@class='elementor-heading-title elementor-size-default']")) != null) {
			assertTrue("Prueba exitosa", true);
		}else {
			fail("Prueba fallida");
		}
		
		driver.navigate().back(); //Volver atr�s
		
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
	public void tearDownTratamientoDatos() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.quit();
	}
}
