package com.selenium.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public WebDriver driver;
	public Properties OR;
	public File f1;
	public FileInputStream file;
	
	//WebDriver driver = new FirefoxDriver();
	public void getBrowser(String browser){
		if(System.getProperty("os.name").contains("Window")){
			if(browser.equalsIgnoreCase("firefox")){
				System.out.println(System.getProperty("os.name"));
				//https://github.com/mozilla/geckodriver/releases
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("chrome")){
				System.out.println(System.getProperty("os.name"));
				//https://chromedriver.storage.googleapis.com/index.html
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
				driver = new ChromeDriver();
	//			driver.get("http://stage.fmis.jalanidhi.in");
			}
		}
		else if(System.getProperty("os.name").contains("Mac")){
			//System.out.println(System.getProperty("os.name"));
			if(browser.equalsIgnoreCase("firefox")){
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver");
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
				driver = new ChromeDriver();
			}
		}
	
}
	public void loadPropertiesFile() throws IOException
	{
		OR = new Properties();
		f1 = new File(System.getProperty("user.dir")+"/src/main/java/com/selenium/config/config.properties");
		file = new FileInputStream(f1);
		OR.load(file);
		f1 = new File(System.getProperty("user.dir")+"/src/main/java/com/selenium/config/or.properties");
		file = new FileInputStream(f1);
		OR.load(file);
		
	}
	public void getPropertiesData()
	{
		
	}
	
	public static void main(String[] args) throws IOException {
	TestBase test = new TestBase();
	test.getBrowser("Chrome");
	test.loadPropertiesFile();
	System.out.println(test.OR.getProperty("url"));
	//test.driver.get("url");
	System.out.println(test.OR.getProperty("testname"));
	test.OR.getProperty("testname");
	
	}
}