package senCity_premiers_tests;

import java.io.FileNotFoundException;

public class Test {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		ScanneFile scanfile = new ScanneFile("capture_wifi.csv","Ros Timestamp","1438174357035008615");
		String a = scanfile.getWifiCapt(true);
		
		System.out.println(a);
	}
}
