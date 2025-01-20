import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleTest {

    @Test
    public void testExample() {
        int expected = 5;
        int actual = 2 + 3; // Sample operation
        Assert.assertEquals(actual, expected, "Test failed: Values do not match!");
    }
}
