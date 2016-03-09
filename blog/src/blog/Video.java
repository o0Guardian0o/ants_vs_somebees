package blog;

public class Video extends AbstractItem {
	
	private String url;
	
	public Video(long Date, String author, String url) {
		super(Date, author);
		this.url = url;
	}
	
	
	public String getURL() {
		return url;
	}

}
