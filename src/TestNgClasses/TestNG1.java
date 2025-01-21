package TestNgClasses;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG1 {

	@Test //reduce the dependency of java main method.
	public void a2() {
		System.out.println("Hey,a2 Test method...");
	}

	@BeforeTest
	public void b() {
		System.out.println("Hey,BeforeTest method...");
	}

	@BeforeSuite
	public void c() {
		System.out.println("Hey,Before Suite method...");
	}

	@AfterSuite
	public void d() {
		System.out.println("Hey, After suite method...");
	}

	@BeforeMethod
	public void e() {
		System.out.println("Hey,Before method...");
	}

	@BeforeClass
	public void f() {
		System.out.println("Hey,Before Class method...");
	}

	@AfterTest
	public void g() {
		System.out.println("Hey,After test method...");
	}

	@AfterClass
	public void h() {
		System.out.println("Hey,Afte Class method...");
	}
	@AfterMethod
	public void i() {
		System.out.println("Hey,After method...");
	}

	@Test //reduce the dependency of java main method.
	public void a1() {
		System.out.println("Hey,a1 Test method...");
	}
}
