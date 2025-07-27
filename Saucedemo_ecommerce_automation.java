package Ecommerce_website_Automate;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
//ChromeOptions options = new ChromeOptions();
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeOptions;

public class Saucedemo_ecommerce_automation {
	public static void main(String args[]) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();

		// Disable password manager and notifications
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.default_content_setting_values.notifications", 2);
		options.setExperimentalOption("prefs", prefs);

		// Add a temporary profile directory
		options.addArguments("user-data-dir=C:/Temp/ChromeProfile");  // Windows-safe directory

		// Additional arguments
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");  // extra safe
		
//**********Driver Start***************		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");

		
//**************************For Login***********************************************
		WebElement username=driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		password.sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		

//*************************Add to Cart***********************************************
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
//**************************Checkout**********************************
		driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
//************Checkout Your Information Page********************
		WebElement name = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input"));
		name.sendKeys("Cheese");
		WebElement L_name = driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
		L_name.sendKeys("cake");
		
		WebElement Code = driver.findElement(By.xpath("//*[@id=\"postal-code\"]"));
		Code.sendKeys("345678");
		
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
		
	}
}
