import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AClassTests {

	@Test
	public void testSumMethod() {
		AClass obj = new AClass();
		int sum = obj.sum(1, 2);
		assertEquals(3, sum);
	}
}
