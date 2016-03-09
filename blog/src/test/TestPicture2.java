package test;

public class TestPicture2 extends AbstractTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		new TestPicture2();
	}

	protected void runTests() {
		this.testExpected = 2;
		try {
			testGetURL();
		} catch (Exception e) { e.printStackTrace(); }
	}

	public void testGetURL() {
		blog.Picture p = new blog.Picture(1259838000, "Jean-Luc Picard", "http://www.startrek.com/img/logo.png");
		String expectedS = "http://www.startrek.com/img/logo.png";
		String valueS = p.getURL();
		assertEquals(expectedS, valueS);
	
		blog.Picture p2 = new blog.Picture(1259838000, "Jean-Luc Picard", "http://www.startrek.com/img/banner.png");
		expectedS = "http://www.startrek.com/img/banner.png";
		valueS = p2.getURL();
		assertEquals(expectedS, valueS);		
	}

}
