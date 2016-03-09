package test;

public class TestAbstractItem1 extends AbstractTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		new TestAbstractItem1();
	}

	protected void runTests() {
		this.testExpected = 5;
		try {
			testDeclaredMethods();
		} catch (Exception e) { e.printStackTrace(); }
		try {
			testDeclaredConstructors();
		} catch (Exception e) { e.printStackTrace(); }
	}
	
	public void testDeclaredMethods() {		
		assertDeclaredMethod(blog.AbstractItem.class, "addTag", new Class[] { String.class }, "missing method addTag(String) in class AbstractItem");
		// TODO: check return type is 'void'
		
		assertDeclaredMethod(blog.AbstractItem.class, "removeTag", new Class[] { String.class }, "missing method removeTag(String) in class AbstractItem");		
		// TODO: check return type is 'void'

		assertDeclaredMethod(blog.AbstractItem.class, "tagCount", new Class[] { }, "missing method tagCount() in class AbstractItem");		
		// TODO: check return type is 'int'

		assertDeclaredMethod(blog.AbstractItem.class, "getTags", new Class[] { }, "missing method getTas() in class AbstractItem");		
		// TODO: check return type is 'List<String>'
	}

	
	public void testDeclaredConstructors() {		
		assertDeclaredConstructor(blog.AbstractItem.class, new Class[] { long.class, String.class }, "missing constructor AbstractItem(long, String) in class AbstractItem");
	}

}
