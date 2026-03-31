package testNGAnnotation;

import org.testng.annotations.Test;

public class DataProviderClass {

	@Test(dataProvider = "data_BookingTicket", dataProviderClass = DataProv_Example.class)
	public void getData(String src,String dest) {
		System.out.println("Booking from "+src+" To "+dest);
	}
	
}
