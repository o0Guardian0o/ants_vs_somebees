package test;

public class TestMessage2 extends AbstractTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		new TestMessage2();
	}

	protected void runTests() {
		this.testExpected = 2;
		try {
			testGetContent();
		} catch (Exception e) { e.printStackTrace(); }
	}

	public void testGetContent() {
		blog.Message m = new blog.Message(1259838000, "Jean-Luc Picard", "Space the final frontier");
		String expectedS = "Space the final frontier";
		String valueS = m.getContent();
		assertEquals(expectedS, valueS);
	
		blog.Message m2 = new blog.Message(1259838000, "Quark", "Ferengi rules");
		expectedS = "Ferengi rules";
		valueS = m2.getContent();
		assertEquals(expectedS, valueS);		
	}

}
