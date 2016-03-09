package blog;

import java.util.List;

public interface BlogService {

	public String getTitle();
	
	public void post(blog.Publishable billet);
	
	public List<Publishable> getItems();
	
	public int getPublishableItemsCount();
	
	public int getTaggableItemsCount();
	
	public List<Publishable> findItemsByAuthor(String author);
	
	public blog.Publishable getLatestItem();
	
	public List<Publishable> findItemsByTags(String[] tags);
	
	public List<Publishable> findItemsByContent(String[] tab);
	
	public List<Publishable> findItemsByTagsOrContent(String[] tag);
}
