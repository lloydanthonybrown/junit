/**
 * Created by Lloyd on 11/30/2015.
 */

import org.junit.*;
import org.junit.rules.ExpectedException;

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

    // It told me that this test should be static. Why?
    // I originally had this annotated as @AfterClass, but it didn't like that.
    @After
    public void happyMessage(){
        String message = "Where's your happy face?";
        assertEquals("Where's your happy face?",message);
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
    // Is this the wrong type of exception to be throwing?
    // Why is this test failing?
    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddPiranha(){
//        try {
            testTank.addPiranha(0, evan);
//        }
//        catch (Exception e){
//            System.out.println("The index cannot be negative.");
//        }

    }

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void throwsNothing(){
        // So this just says that if nothing is thrown, it passes this particular test?
    }

    @Test
    public void throwsExceptionWithSpecificType(){
        // I see that this test is referring to the rule, but I don't know what the NullPointerException does.
        // What expression is it expecting? I added .class to it, but I have no idea what that did.
        thrown.expect(NullPointerException.class);
        throw new NullPointerException();
    }

//    @Test
//    public void testJump() {
//
//    }

}
