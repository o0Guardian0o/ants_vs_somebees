package test;

public class TestVideo2 extends AbstractTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		new TestVideo2();
	}

	protected void runTests() {
		this.testExpected = 2;
		try {
			testGetURL();
		} catch (Exception e) { e.printStackTrace(); }
	}

	public void testGetURL() {
		blog.Video v = new blog.Video(1259838000, "Jean-Luc Picard", "http://www.startrek.com/vids/trailer.mpg");
		String expectedS = "http://www.startrek.com/vids/trailer.mpg";
		String valueS = v.getURL();
		assertEquals(expectedS, valueS);
	
		blog.Video v2 = new blog.Video(1259838000, "Jean-Luc Picard", "http://www.startrek.com/vids/trailer-hq.mp4");
		expectedS = "http://www.startrek.com/vids/trailer-hq.mp4";
		valueS = v2.getURL();
		assertEquals(expectedS, valueS);		
	}

}
