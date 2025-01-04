package TestNgClasses;

import org.testng.annotations.*;
/*
 * Sequencing and Prioritized
 */
public class TestNG2_Sequencing_and_Priorotized {

	@Test(priority = -10)
	public void a() {
		System.out.println("Hey,a Test method...");
	}
	
	@Test(priority = 0)
	public void b() {
		System.out.println("Hey,b Test method...");
	}
	@Test(priority = 2)
	public void c() {
		System.out.println("Hey,c Test method...");
	}
	@Test
	public void d() {
		System.out.println("Hey,d Test method...");
	}

}
