package blog;

public class Message extends AbstractPublishableItem {
	
	private String corps;
	
	public Message(long date, String author, String corps) {
		super(date,author);
		this.corps = corps;
	}
	
	public String getContent() {
		return this.corps;
	}
}
