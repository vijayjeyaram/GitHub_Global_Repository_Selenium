package helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Assert;

public class TestData 
{
	public static String mobile_Browser = null;  
	public static String deployment_Environment = null;
  	public static String mobile_URL = null;  
  	public static String memberNo = null;
	public static String userName = null;
  	public static String password = null;
  	
  	public static void general_TestData() 
	{
		try
		{
			File file = new File("./src/test/resources/Properties_Files/TestData.Properties");
			FileInputStream fileInput=null;
			fileInput = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fileInput);
	        
	      
			mobile_Browser=prop.getProperty("mobile_Browser").trim();	  
			deployment_Environment=prop.getProperty("deployment_Environment").trim();
	      	mobile_URL=prop.getProperty("mobile_URL").trim();
	      	memberNo=prop.getProperty("memberNo").trim();
	      	userName=prop.getProperty("userName").trim();
	      	password=prop.getProperty("password").trim();
	      	     	
		}
		catch (Exception e)
		{
			System.out.println("---ERROR MESSAGE---");
			System.out.println("Unable to Retrieve Data from the Properties file.Issue in general_TestData() method.");
			System.out.println(e);
			Assert.fail(); 
		}
	}
}
