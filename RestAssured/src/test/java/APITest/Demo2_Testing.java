package APITest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo2_Testing {
	@BeforeClass
	public void BC() 
	{
		System.out.println("This is my second Class");
		}
	
	@BeforeMethod
	public void BM()
	{
		System.out.println("This is before method");
	}
	
	@Test
	public void testcase3()
	{
		System.out.println("This is my second testcase");
	}
	
	
	@AfterTest
	public void AT()
	{
			System.out.println("This will execute after all test");
	}
	@AfterSuite
	public void AS()
	{
			System.out.println("This will Execute at end");
	}

}
