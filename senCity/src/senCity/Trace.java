package senCity;

public class Trace {

	private String ts;
	private String ssid;
	private int signal;
	
	public Trace(String ts, String ssid, int signal) {
		this.ts = ts;
		this.ssid = ssid;
		this.signal = signal;
	}
	
	public String toString(){
		String Strace =  this.ts + ", "
				+ this.ssid + ", " 
				+ this.signal + ",";
		return Strace;
	} 
	
}
