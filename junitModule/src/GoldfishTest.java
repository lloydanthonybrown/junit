/**
 * Created by Lloyd on 11/30/2015.
 */
import static junit.framework.Assert.assertEquals;
import org.junit.*;
public class GoldfishTest {
    Goldfish goldfishTest = new Goldfish();

    Goldfish calculation = new Goldfish();
    int sum = calculation.sum(2,5);
    int testSum = 7;

    @Test
    public void testSum(){
        System.out.println("@Test sum(): " + sum + " = " + testSum);
        assertEquals(sum, testSum);
    }

    // Why does this not return an error when running it? It doesn't meet the requirements for the original method.
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrown(){
        Goldfish tester = new Goldfish();
        tester.multiply(1000,5);
    }

    @Test
    public void testMultiply(){
        Goldfish tester = new Goldfish();
        assertEquals("10 x 5 must be 50", 50, tester.multiply(10,5));
    }
}
