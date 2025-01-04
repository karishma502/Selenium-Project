package TestNgClasses;

import org.testng.SkipException;
import org.testng.annotations.*;
/*
 * Skip test case.
 */
public class TestNG3_SkippingTC {

	//@Test  //1st way to skip test case  - comment the @Test
	public void a() {
		System.out.println("Hey,a Test method...");
	}

	//2nd way - widely used in market
	@Test(enabled=false)
	public void b() {
		System.out.println("Hey,b Test method...");
	}

	@Test(enabled=true)
	public void c() {
		System.out.println("Hey,c Test method...");

	}

	@Test(invocationCount = 2)  //way to run tc multiple time
	public void d() {
		System.out.println("Hey,d Test method...");

	}

	// 3rd way to skipp test case
	@Test(invocationCount = 0)  //way to run tc multiple time
	public void e() {
		System.out.println("Hey,e Test method...");

	}

	// correct way -  not recommended
	@Test
	public void f() {
		System.out.println("Hey,f Test method...");
		throw new SkipException("Skipped test method..");
	}
}