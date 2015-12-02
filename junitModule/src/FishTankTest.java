/**
 * Created by Lloyd on 11/30/2015.
 */
import static junit.framework.Assert.assertEquals;
import org.junit.*;

import java.util.ArrayList;

public class GoldfishTest {
    FishTank testTank;
    GoldfishBean alberto, hansol;
    PirahnaBean lloyd, evan;


    @Before
    public void startUp() throws Exception{
        testTank = new Goldfish();

        // int fins, int gills, int lungs, String color, String nemesis, int size
        alberto = new GoldfishBean(2,4,2,"blue","cats",6);
        hansol  = new GoldfishBean(1,4,2,"red","dogs",6);

        // int fins, int gills, int lungs, boolean hasTeeth, String waterPreference, String foodPreference
        lloyd   = new PirahnaBean(3,4,2,true,"salt","cows");
        evan    = new PirahnaBean(2,4,2,false,"fresh","spoons");
    }

    @Test
    public void testGoldfishHashMap(){
        // Add a specific goldfish to the testTank.
        testTank.addGoldfish(alberto);
        int size = testTank.returnGHashMapSize();
        assertEquals(1,size);
        // Add another fish.
        testTank.addGoldfish(alberto);
        int size = testTank.returnGHashMapSize();
        assertEquals(1,size);

    }

//    @Test
//    public void testAddGoldfish(){
//
//    }

//    Goldfish calculation = new Goldfish();
//    int sum = calculation.sum(2,5);
//    int testSum = 7;
//
//    @Test
//    public void testSum(){
//        System.out.println("@Test sum(): " + sum + " = " + testSum);
//        assertEquals(sum, testSum);
//    }
//
//    // Why does this not return an error when running it? It doesn't meet the requirements for the original method.
//    @Test(expected = IllegalArgumentException.class)
//    public void testExceptionIsThrown(){
//        Goldfish tester = new Goldfish();
//        tester.multiply(1000,5);
//    }
//
//    @Test
//    public void testMultiply(){
//        Goldfish tester = new Goldfish();
//        assertEquals("10 x 5 must be 50", 50, tester.multiply(10,5));
//    }
//
//
//    @Test
//    public void testJump() {
//
//    }

}
