package com.servicios.choucair;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CapacidadesTest {
	
	private WebDriver driver;
	
	@Before
	public void setUpCapacidades() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/servicio/");
	}
	
	@Test
	public void testCapacidades() {
		WebElement btnCapacidades = driver.findElement(By.xpath("//div[@class='elementor-element elementor-element-9537fb8 elementor-position-top elementor-vertical-align-top elementor-widget elementor-widget-image-box']//div[@class='elementor-image-box-wrapper']"));
		btnCapacidades.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		if (driver.findElement(By.id("capacidades")) != null) {
			assertTrue("Prueba exitosa", true);
		}else {
			fail("Prueba fallida");
		}
		
		if (driver.findElement(By.xpath("//i[contains(@class,'fa fa-angle-up')]")).isDisplayed()) { 
			driver.findElement(By.xpath("//i[contains(@class,'fa fa-angle-up')]")).click();
			if(driver.findElement(By.xpath("//div[@class='elementor-element elementor-element-bd039e7 elementor-widget elementor-widget-image animated fadeIn']//img[@class='attachment-full size-full']")) != null) {//Img slider
				assertTrue("Prueba exitosa", true);
			}else {
				fail("Prueba fallida");
			}
		}else {
			fail("Prueba fallida");
		}
		
		//System.out.println("Ha finalizado " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@After
	public void tearDownCapacidades() {
		driver.quit();
	} 

}
