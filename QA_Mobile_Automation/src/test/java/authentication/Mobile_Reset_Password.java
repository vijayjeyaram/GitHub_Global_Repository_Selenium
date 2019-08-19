package authentication;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mobile_Reset_Password
{
	@BeforeTest
	public void GetTestData()
	{
		System.out.println("@BeforeTest Block has been Executed.");
	}
	@Test
	public void LoginFlow()
	{
		System.out.println("@Test Block has been Executed.");
	}
	@AfterTest
	public void EndTest()
	{
		System.out.println("@AfterTest Block has been Executed.");
	}
}
