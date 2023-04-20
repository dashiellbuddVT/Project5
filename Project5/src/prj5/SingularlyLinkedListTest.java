package prj5;

import student.TestCase;

/**
 * This class intends to test the singularly linked list class
 * @author George Liu (GeorgeLiu)
 * @version 20 April 2023
 *
 */
public class SingularlyLinkedListTest extends TestCase{
    private SingularlyLinkedList<String> list1;
    private SingularlyLinkedList<String> list2;
    
    /**
     * Sets up the tester
     */
    public void setUp() {
        list1 = new SingularlyLinkedList<String>();
        list1.add("Harry");
        list1.add("Ron");
        list1.add("Herminie");
        list2 = new SingularlyLinkedList<String>();
    }
    
    /**
     * tests the get size method
     */
    public void testGetSize() {
        assertEquals(3,list1.getSize());
    }
    
    public void testAdd() {
        list2.add("Luke");
        assertEquals(1,list2.getSize());
        assertEquals(3,list1.getSize());
        list1.add("Ginny");
        assertEquals(4,list1.getSize());
        list1.add(2,"Malfoy");
        assertEquals(5,list1.getSize());
        assertEquals("Malfoy",list1.get(5));
        list1.add(0,"Luna");
        assertEquals(6,list1.getSize());
        assertEquals("Luna",list1.get(0));
        
        
        try { // index out of bounds
            list1.add(15,"Fred");
        }
        catch(Exception e) {
            assertNotNull(e);
        }
        
        try { // invalid input
            list1.add(5,null);
        }
        catch(Exception k) {
            assertNotNull(k);
        }
    }
    
    /**
     * this  tests the isEmpty method
     */
    public void testIsEmpty() {
        assertTrue(list2.isEmpty());
        assertFalse(list1.isEmpty());
    }
    
    public void testRemove() {
        list1.remove(0);
        assertEquals(2,list1.getSize());
        list1.remove(1);
        assertEquals(1,list1.getSize());
        try {
            list1.remove(1);
        }
        catch (Exception e){
            assertNotNull(e);
        }
    }
    
    /**
     * this test the get method
     */
    public void testGet() {
        assertEquals("Herminie",list1.get(0));
        assertEquals("Ron",list1.get(2));
        
        try {
            list1.get(15);
        }
        catch (Exception e) {
            assertNotNull(e);
        }
    }
    
    /**
     * tests the clear method
     */
    public void testClear() {
        list1.clear();
        assertEquals(0,list1.getSize());
    }
    
    /**
     * tests the getLastIndexOf Method
     */
    public void testGetLastIndexOf() {
        list2.add("Luke");
        list2.add("Leia");
        list2.add("Kenobi");
        list2.add("Han");
        list2.add("Chewie");
        list2.add("Yoda");
        list2.add("Ahsoka");
        list2.add("Kenobi");
        list2.add("Anakin");
        list2.add("Sidious");
        assertEquals(7,list2.getLastIndexOf("Kenobi"));
    }
    
    /**
     * tests the toString method
     */
    public void testToString() {
        assertEquals("[]",list2.toString());
        System.out.println(list1.toString());
        assertEquals("[Herminie, Ron, Harry]",list1.toString());
    }
}

