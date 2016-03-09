package blog;

import java.util.List;
import java.util.ArrayList;

public class BlogServiceImpl implements BlogService {
		
	private String title;
	private List<Publishable> blogs;
	
	public BlogServiceImpl(String title) {
		this.title = title;
		blogs = null;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void Post(blog.Publishable billet) {
		this.blogs.add(billet);
	}
	
	public List<Publishable> getItems() {
		return this.blogs;
	}
	
	public int getPublishableItemsCount() {
		return this.blogs.size();
	}
	
	public int getTaggableItemsCount() {
		int count = 0;
		for(Publishable pub : this.blogs) {
			if (pub instanceof Taggable) {
				count ++;
			}
		}
		return count;
	}
	
	public List<Publishable> findItemsByAuthor(String author) {
		List<Publishable> items = new ArrayList<Publishable>();
		for (Publishable pub : this.blogs) {
			if(pub.getAuthor() == author) {
				items.add(pub);
			}
		}
		return items;
	}
	
	public Publishable getLatestItem() {
		Publishable latest_pub = blogs.get(0);
		for (Publishable pub : this.blogs) {
			if (pub.getPublicationDate() < latest_pub.getPublicationDate()) {
				latest_pub = pub;
			}	
		}
		return latest_pub;
	}
	
	public List<Publishable> findItemsByTags(String[] tags) {
		List<Publishable> items = new ArrayList<Publishable>();
		List<Taggable> items_taggable = new ArrayList<Taggable>();
		for (Publishable pub : this.blogs) {
			if (pub instanceof Taggable) {
				Taggable pub_tag = (Taggable) pub;
				items_taggable.add(pub_tag);
			}
		}
		for (Taggable pub_tag : items_taggable) {
			List<String> item_tags = pub_tag.getTags();
			for (String tag : item_tags) {
				for (int i=0; i< tags.length ; i++) {
					if (tag == tags[i]) {
						Publishable pub_pub = (Publishable) pub_tag;
 						items.add(pub_pub);
					}
				}
			}
		}
		return items;
	}
	
	
}
