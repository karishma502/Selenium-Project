package TestNgClasses;

import org.testng.Assert;
import org.testng.annotations.*;
/*
 * Sequencing and Prioritized
 */
public class TestNG4_DependsOnMethod {

	@Test()
	public void a() {
		Assert.assertTrue(3>12);
		System.out.println("Hey,a Test method...");
	}

	@Test(dependsOnMethods = "a")
	public void b() {
		Assert.assertTrue(3>12);
		System.out.println("Hey,b Test method...");
	}

}
