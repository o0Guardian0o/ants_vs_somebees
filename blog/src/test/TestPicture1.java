package test;

public class TestPicture1 extends AbstractTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		new TestPicture1();
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
		assertDeclaredMethod(blog.Picture.class, "getURL", new Class[] { }, "missing method getURL() in class Picture");
		// TODO: check return type is 'String'
	}

	public void testDeclaredConstructors() {		
		assertDeclaredConstructor(blog.Message.class, new Class[] { long.class, String.class, String.class }, "missing constructor Picture(long, String, String) in class Picture");
	}
	
	public void testSuperTypes() {
		blog.Picture p = new blog.Picture(1259838000, "Jean-Luc Picard", "http://www.startrek.com/img/logo.png");
		assertInstanceOf(p, blog.AbstractItem.class);
		assertInstanceOf(p, blog.Taggable.class);
		assertInstanceOf(p, blog.Publishable.class);
	}


}
