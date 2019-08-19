package authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import helper.TestData;

public class Mobile_LoginFlow
{
	public static WebDriver driver = null;
	public static String osx_ChromeDriver = "./src/test/resources/Browser_Drivers/OSX/chromedriver";
	public static String linux_ChromeDriver = "./src/test/resources/Browser_Drivers/Linux/chromedriver";
	public static String windows_ChromeDriver = "./src/test/resources/Browser_Drivers/Windows/chromedriver.exe";
	public static String osx_GeckoDriver = "./src/test/resources/Browser_Drivers/OSX/geckodriver";
	public static String linux_GeckoDriver = "./src/test/resources/Browser_Drivers/Linux/geckodriver";
	public static String windows_GeckoDriver = "./src/test/resources/Browser_Drivers/Windows/geckodriver.exe";
	
	@BeforeTest
	public void GetTestData()
	{
		TestData.general_TestData();	
	}
	@Test
	public void LoginFlow()
	{
		try
		{
			if(TestData.deployment_Environment.equalsIgnoreCase("OSX"))
			{
				if(TestData.mobile_Browser.equalsIgnoreCase("Chrome"))
				{
					System.setProperty("webdriver.chrome.driver", osx_ChromeDriver);
					driver = new ChromeDriver();
				}
				else
				{
					System.setProperty("webdriver.chrome.driver", osx_GeckoDriver);
					driver = new FirefoxDriver();
				}
			}
			else if(TestData.deployment_Environment.equalsIgnoreCase("Linux"))
			{
				if(TestData.mobile_Browser.equalsIgnoreCase("Chrome"))
				{
					System.setProperty("webdriver.chrome.driver", linux_ChromeDriver);
					driver = new ChromeDriver();
				}
				else
				{
					System.setProperty("webdriver.chrome.driver", linux_GeckoDriver);
					driver = new FirefoxDriver();
				}
			}
			else
			{
				if(TestData.mobile_Browser.equalsIgnoreCase("Chrome"))
				{
					System.setProperty("webdriver.chrome.driver", windows_ChromeDriver);
					driver = new ChromeDriver();
				}
				else
				{
					System.setProperty("webdriver.chrome.driver", windows_GeckoDriver);
					driver = new FirefoxDriver();
				}
			}
		
			driver.manage().window().maximize();
			driver.get(TestData.mobile_URL);
			
			Thread.sleep(5000);

			//UserName Password Screen
			driver.findElement(By.xpath("//input[@id='ctl00_CPHSectionContent_Textbox_UserName']")).sendKeys(TestData.userName);
			driver.findElement(By.xpath("//input[@id='ctl00_CPHSectionContent_Text_Password']")).sendKeys(TestData.password);
			driver.findElement(By.xpath("//input[@id='ctl00_CPHSectionContent_Button_DummySubmit']")).click();
			
			Thread.sleep(5000);
	
			//Logout
			driver.findElement(By.xpath("//a[@id='mobile-header-user']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@id='ctl00_Profile_LogoutLink']")).click();
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			System.out.println("---ERROR MESSAGE---");
			System.out.println("");
			System.out.println(e);
			Assert.fail(); 
		}
		
	}
	@AfterTest
	public void EndTest()
	{
		driver.close();
	}
}

