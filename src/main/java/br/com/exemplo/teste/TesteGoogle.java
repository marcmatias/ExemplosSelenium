package br.com.exemplo.teste;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class TesteGoogle {
	
	@Test
	public void teste() {
		
// 		ChormeDriver
		ChromeDriverManager.getInstance().setup();
		WebDriver driver = new ChromeDriver();

// 		EdgeDriver
//		EdgeDriverManager.getInstance().setup();
//		WebDriver driver = new EdgeDriver();
	
// 		FirefoxDriver
//		FirefoxDriverManager.getInstance().setup();
//		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("https://duckduckgo.com/");
		Assert.assertEquals("DuckDuckGo — Privacy, simplified.", driver.getTitle());
		driver.findElement(By.xpath("//input[@id='search_form_input_homepage']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@id='search_button_homepage']")).click();
		Assert.assertEquals("Selenium", driver.findElement(By.xpath("//input[@id='search_form_input']"))
				.getAttribute("value"));
		driver.quit();
	}

}
