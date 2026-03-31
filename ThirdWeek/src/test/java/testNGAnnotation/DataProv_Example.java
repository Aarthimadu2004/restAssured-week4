package testNGAnnotation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProv_Example {
	@DataProvider
	public Object[][] data_BookingTicket(){
		Object[][] obj=new Object[5][2];
		obj[0][0]="TN";
		obj[0][1]="Karnataka";
		
		obj[1][0]="MP";
		obj[1][1]="Delhi";
		
		obj[2][0]="Kerala";
		obj[2][1]="Andhra";
		
		obj[3][0]="Gujarat";
		obj[3][1]="Kashmir";
		
		obj[4][0]="TN";
		obj[4][1]="America";
		return obj;
	}
	
	@Test(dataProvider="data_BookingTicket")
	public void test(String src,String dest) {
		System.out.println(src+" To "+dest);
		
	}

}
