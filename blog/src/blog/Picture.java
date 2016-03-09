package blog;

public class Picture extends AbstractItem {
	
	private String url;
	
	public Picture(long Date, String author, String url) {
		super(Date, author);
		this.url = url;
	}
	
	
	public String getURL() {
		return url;
	}
}
