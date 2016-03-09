package test;

public class TestBlogService extends AbstractTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		new TestBlogService();
	}

	protected void runTests() {
		this.testExpected = 10;
		try {
			testDeclaredMethods();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testDeclaredMethods() {
		assertDeclaredMethod(blog.BlogService.class, "getTitle", new Class[] {},
				"missing method getTitle() in interface BlogService");
		// TODO: check return type is 'String'

		assertDeclaredMethod(blog.BlogService.class, "post", new Class[] { blog.Publishable.class },
				"missing method post(Publishable) in interface BlogService");
		// TODO: check return type is 'void'

		assertDeclaredMethod(blog.BlogService.class, "getItems", new Class[] {},
				"missing method getItems() in interface BlogService");
		// TODO: check return type is 'List<Publishable>'

		assertDeclaredMethod(blog.BlogService.class, "getPublishableItemsCount", new Class[] {},
				"missing method getPublishableItemsCount() in interface BlogService");
		// TODO: check return type is 'int'

		assertDeclaredMethod(blog.BlogService.class, "getTaggableItemsCount", new Class[] {},
				"missing method getTaggableItemsCount() in interface BlogService");
		// TODO: check return type is 'int'

		assertDeclaredMethod(blog.BlogService.class, "findItemsByAuthor", new Class[] { String.class },
				"missing method findItemsByAuthor(String) in interface BlogService");
		// TODO: check return type is 'List<Publishable>'

		assertDeclaredMethod(blog.BlogService.class, "getLatestItem", new Class[] {},
				"missing method getLatestItem() in interface BlogService");
		// TODO: check return type is 'Publishable'

		assertDeclaredMethod(blog.BlogService.class, "findItemsByTags", new Class[] { String[].class },
				"missing method findItemsByTags(String[]) in interface BlogService");
		// TODO: check return type is 'List<Publishable>'

		assertDeclaredMethod(blog.BlogService.class, "findItemsByContent", new Class[] { String[].class },
				"missing method findItemsByContent(String[]) in interface BlogService");
		// TODO: check return type is 'List<Publishable>'

		assertDeclaredMethod(blog.BlogService.class, "findItemsByTagsOrContent", new Class[] { String[].class },
				"missing method findItemsByTagsOrContent(String[]) in interface BlogService");
		// TODO: check return type is 'List<Publishable>'

	}

}
