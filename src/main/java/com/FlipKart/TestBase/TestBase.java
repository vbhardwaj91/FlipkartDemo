package com.FlipKart.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	public static WebDriver driver;
	public static Properties Config;
	public static FileInputStream fi;
	public static WebDriverWait w;
	
	
	public TestBase() {
		
		try {
			 
			Config = new Properties();
		//	fi = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\Flipkart\\src\\main\\java\\com\\FlipKart\\Properties\\Config.properties");
			fi = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//FlipKart//Properties//Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Config.load(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	public static void initilizations() {
		
		if( Config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Executables//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("ImpilcitWait")), TimeUnit.MILLISECONDS);
			driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(Config.getProperty("PageLoadTimeOut")), TimeUnit.MILLISECONDS);
			w= new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(Config.getProperty("ExplicitWait"))));
			driver.manage().window().maximize();
		}
		
		else if ( Config.getProperty("Browser").equalsIgnoreCase("Firefox")) {
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Executables//geckodriver.exe");
			
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("ImpilcitWait")), TimeUnit.MILLISECONDS);
			driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(Config.getProperty("PageLoadTimeOut")), TimeUnit.MILLISECONDS);
			w= new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(Config.getProperty("ExplicitWait"))));
			driver.manage().window().maximize();
		}
		
		else if ( Config.getProperty("Browser").equalsIgnoreCase("IE")) {
			
			driver = new InternetExplorerDriver();			
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("ImpilcitWait")), TimeUnit.MILLISECONDS);
			driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(Config.getProperty("PageLoadTimeOut")), TimeUnit.MILLISECONDS);
			w= new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(Config.getProperty("ExplicitWait"))));
			driver.manage().window().maximize();
		}
		
		else {
			
			System.out.println("Incorrect Browser");
			
			
		}
	}
	
	
	
	
}
