package APITest;

import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo_TestNG {
	
	
	@BeforeSuite
	public void BS()
	{
		System.out.println("This is going to execute before any test");
	}
	@BeforeTest
	public void BT()
	{
		System.out.println("This will run after testsuite");
	}
	
	@BeforeClass
	public void BC()
	{
		System.out.println("This will execute before class");
	}
	
	@BeforeMethod
	public void BM()
	{
		System.out.println("This will execute before  every test");
	}
	@Test
	public void TestCase1()
	{
		System.out.println("This is my test case");
		Assert.assertEquals("Sanju","Sanju");
	}
	
	@AfterMethod
	public void AM()
	{
		System.out.println("After each method");
	}
	
	@AfterClass
	public void AC()
	{
		System.out.println("This will execute after class");
	}
	
	

	}

