package prj5;

import student.TestCase;

/**
 * tests the account test
 * @author dashiell budd
 * @version 4/24/2023
 *
 */
public class AccountTest extends TestCase {
    private Account act1;


    /**
     * 
     * This is the set up class
     */
    public void setUp() {
        act1 = new Account("Candoodlie", "Canada", "News");

    }


    /**
     * test getName method
     */
    public void testGetName() {
        assertEquals("Candoodlie", act1.getName());
    }


    /**
     * tests the getCountry method
     */
    public void testGetCountry() {
        assertEquals("Canada", act1.getCountry());
    }


    /**
     * tests the getTopic method
     */
    public void testGetTopic() {
        assertEquals("News", act1.getTopic());
    }

    /**
     * tests the get month
     */
    public void testGetMonth() {
        Month jan = new Month(1, 5000, 25, 150, 150, 150000);
        Month feb = new Month(2, 9000, 35, 550, 250, 200000);
        Month mar = new Month(3, 13000, 45, 950, 550, 950000);
        Month tes = new Month(3, 13000, 45, 950, 550, 950000);
        act1.setMonth(jan);
        act1.setMonth(feb);
        act1.setMonth(mar);

        assertEquals(act1.getMonth(3), tes);
    }

    /**
     * tests the equals method
     */
    public void testEquals() {
        Month feb = new Month(2, 9000, 35, 550, 250, 200000);
        assertTrue(feb.equals(feb));
    }
}
