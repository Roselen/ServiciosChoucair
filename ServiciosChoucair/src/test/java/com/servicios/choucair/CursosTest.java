package com.servicios.choucair;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CursosTest {

	private WebDriver driver;
	
	@Before
	public void setUpCursos() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/servicio/");
	}
	
	@Test
	public void testCursos() {
		WebElement btnPortafolio = driver.findElement(By.xpath("//div[@class='elementor-element elementor-element-ef51f36 elementor-position-top elementor-vertical-align-top elementor-widget elementor-widget-image-box']//div[@class='elementor-image-box-wrapper']"));
		btnPortafolio.click();;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if(driver.findElement(By.id("portafolio")) != null) {
			assertTrue("Prueba exitosa", true);
		}else {
			fail("Prueba fallida");
		}
		
		WebElement btnCursos = driver.findElement(By.xpath("//div[@class='elementor-element elementor-element-8afa470 elementor-position-top elementor-vertical-align-top elementor-widget elementor-widget-image-box']//img[@class='elementor-animation-grow attachment-full size-full']"));
		btnCursos.click();
		
		if(driver.findElement(By.id("cursos")) != null) {
			assertTrue("Prueba exitosa", true);
		}else {
			fail("Prueba fallida");
		}
		
		WebElement btnLeerMas = driver.findElement(By.xpath("//span[@class='elementor-button-text']"));		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", btnLeerMas);
		
		if (driver.findElement(By.xpath("//h1[contains(text(),'No disponible')]")) != null) {
			fail("Prueba fallida");
		}else {
			assertTrue("Prueba exitosa", true);
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
	public void tearDownCursos() {
		driver.quit();
	} 
}
