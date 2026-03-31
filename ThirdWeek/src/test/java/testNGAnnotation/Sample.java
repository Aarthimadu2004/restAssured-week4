package testNGAnnotation;

import org.testng.annotations.*;

public class Sample {
	@BeforeSuite
	public void bs() {
		System.out.println("BS");
	}
	
	@AfterSuite
	public void as() {
		System.out.println("AS");
	}
	
	@BeforeMethod
	public void bm() {
		System.out.println("BM");
	}
	
	@AfterMethod
	public void am() {
		System.out.println("AM");
	}
	
	@Test
	public void tm1() {
		System.out.println("TM1");
	}
	
	@Test
	public void tm2() {
		System.out.println("TM2");
	}
	
	@BeforeClass
	public void bc1() {
		System.out.println("BC1");
	}
	
	@AfterClass
	public void ac1() {
		System.out.println("AC1");
	}
	
	@BeforeClass
	public void bc2() {
		System.out.println("BC2");
	}
	
	@AfterClass
	public void ac2() {
		System.out.println("AC2");
	}
	
	@BeforeTest
	public void bt1() {
		System.out.println("BT1");
	}
	
	@AfterTest
	public void at1() {
		System.out.println("AT1");
	}
	@BeforeTest
	public void bt2() {
		System.out.println("BT2");
	}
	
	@AfterTest
	public void at2() {
		System.out.println("AT2");
	}
	

}
