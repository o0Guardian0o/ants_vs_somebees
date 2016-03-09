package test;

public class TestPublishable extends AbstractTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		new TestPublishable();
	}

	protected void runTests() {
		this.testExpected = 2;
		try {
			testDeclaredMethods();
		} catch (Exception e) { e.printStackTrace(); }
	}

	public void testDeclaredMethods() {		
		assertDeclaredMethod(blog.Publishable.class, "getAuthor", new Class[] {}, "missing method getAuthor() in interface Publishable");
		// TODO: check return type is 'void'
		
		assertDeclaredMethod(blog.Publishable.class, "getPublicationDate", new Class[] {}, "missing method getPublicationDate() in interface Publishable");		
		// TODO: check return type is 'long'
	}

}
