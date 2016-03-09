package test;

public class TestVideo1 extends AbstractTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		new TestVideo1();
	}

	protected void runTests() {
		this.testExpected = 5;
		try {
			testDeclaredMethods();
		} catch (Exception e) { e.printStackTrace(); }
		try {
			testDeclaredConstructors();
		} catch (Exception e) { e.printStackTrace(); }
		try {
			testSuperTypes();
		} catch (Exception e) { e.printStackTrace(); }
	}
	
	public void testDeclaredMethods() {		
		assertDeclaredMethod(blog.Video.class, "getURL", new Class[] { }, "missing method getURL() in class Video");
		// TODO: check return type is 'String'
	}

	public void testDeclaredConstructors() {		
		assertDeclaredConstructor(blog.Video.class, new Class[] { long.class, String.class, String.class }, "missing constructor Video(long, String, String) in class Video");
	}
	
	public void testSuperTypes() {
		blog.Video v = new blog.Video(1259838000, "Jean-Luc Picard", "http://www.startrek.com/vids/trailer.mpg");
		assertInstanceOf(v, blog.AbstractItem.class);
		assertInstanceOf(v, blog.Taggable.class);
		assertInstanceOf(v, blog.Publishable.class);
	}


}
