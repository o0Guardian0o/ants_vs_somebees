package blog;

import java.util.List;

public interface Taggable {
	
	public void addTag(String tag);
	
	public void removeTag(String tag);
	
	public int tagCount();
	
	public List<String> getTags();
	
	
}
