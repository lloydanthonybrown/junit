/**
 * Created by Lloyd on 11/30/2015.
 */
import static org.junit.*;
import org.junit.*;
public class GoldfishTest {
    Goldfish calculation = new Goldfish();
    int sum = calculation.sum(2,5);
    int testSum = 7;

    @Test
    public void testSum(){
        System.out.println("@Test sum(): " + sum + " = " + testSum);
        assertEquals(sum, testSum);
    }
}
