/**
 * Created by Lloyd on 11/30/2015.
 */

import org.junit.*;

import java.lang.reflect.Field;

import static junit.framework.Assert.*;

public class FishTankTest {
    FishTank testTank;
    GoldfishBean alberto, hansol;
    PiranhaBean lloyd, evan;

    @Before
    public void startUp() throws Exception{
        testTank = new FishTank();

        // int name, int gills, int lungs, String color, String nemesis, int size
        alberto = new GoldfishBean("alberto",4,2,"blue","cats",6);
        hansol  = new GoldfishBean("hansol",4,2,"red","dogs",6);
        // int name, int gills, int lungs, boolean hasTeeth, String waterPreference, String foodPreference
        lloyd   = new PiranhaBean("lloyd",4,2,true,"salt","cows");
        evan    = new PiranhaBean("evan",4,2,false,"fresh","spoons");
    }

    @Test
    public void testAddGoldfish(){
        // Add a specific goldfish to the testTank.
        testTank.addGoldfish(alberto);
        testTank.addGoldfish(alberto);
        int size = testTank.getCount();
        assertEquals(2,size);
        // Add another fish.
        // Do I really need to repeat this variable? Well, override it?
        testTank.addGoldfish(hansol);
        size = testTank.getCount();
        assertEquals(3,size);
        // Can I not use several asserts in a row?
        assertNotNull(testTank);
        assertNotSame(alberto,hansol);
        assertSame(alberto,alberto);
        // This is where I'm failing the test. What is going wrong?
//        assertNull(evan);
        // Remove a fish.
//        testTank.removeGoldfish(hansol);
//        assertEquals(1,size);
    }

    @Test
    // This test accesses a private variable by manually setting it as accessible, changing the value, and
    // making sure the value changed to what I wanted.
    public void testFinalGoal(){
        try{
            FishTank fishTankTest = new FishTank();
            Field finalGoalField = FishTank.class.getDeclaredField("finalGoal");
            finalGoalField.setAccessible(true);
            // Why does this give me an IllegalAccessException error?
            String aFinalGoalField = (String)finalGoalField.get(fishTankTest);
            aFinalGoalField = "Groovy";
            assertEquals("Groovy", aFinalGoalField);
        }
        catch (NoSuchFieldException e){
            e.printStackTrace();
        }
        catch (IllegalAccessException iae){
            iae.printStackTrace();
        }
    }

    // Make sure that an exception was successfully thrown
    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddPiranha(){
        testTank.addPiranha(-1, evan);

    }


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
//    @Test
//    public void testJump() {
//
//    }

}
