package blog;

public abstract class AbstractPublishableItem implements Publishable {
	
	protected long date;
	protected String author;
	
	public AbstractPublishableItem(long datepublication, String author) {
		this.date = datepublication;
		this.author = author;
	}
	
	public long getPublicationDate() {
		return this.date;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	

}
