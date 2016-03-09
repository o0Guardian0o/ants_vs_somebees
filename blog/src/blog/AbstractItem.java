package blog;

import java.util.List;
import java.util.ArrayList;

public abstract class AbstractItem extends AbstractPublishableItem implements Taggable {
	
	protected List<String> tags;
	
	public AbstractItem(long date, String author) {
		super(date,author);
		tags = null;
	}
	
	public void addTag(String tag) {
		if (!(this.tags.contains(tag))) {
			this.tags.add(tag);
		}		
	}
	
	public void removeTag(String tag) {
		for (String str : this.tags) {
			if (str == tag) {
				tags.remove(str);
			}
		}
	}
	
	public int tagCount() {
		return this.tags.size();
	}
	
	public List<String> getTags() {
		if (this.tags == null) {
			return new ArrayList<String>();
		}
		return this.tags;
	}
	
}
