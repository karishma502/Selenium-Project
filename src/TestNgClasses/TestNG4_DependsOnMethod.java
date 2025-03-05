package TestNgClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
/*
 * Depend on Methods
 */
public class TestNG4_DependsOnMethod {

	@Test(dependsOnMethods = "c")
	public void a() {
		System.out.println("Search");
	}

	@Test(dependsOnMethods = "c")
	public void b() {
		System.out.println("Logout");
	}

	@Test
	public void c() {
		Assert.fail();
		System.out.println("Login");
	}

}
