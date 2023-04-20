package prj5;
import student.TestCase;

/**
 * Test class for Month
 * @author henryauvil
 * @version 2022.04.20
 */
public class MonthTest extends TestCase
{
    private Month month1;
    
    /**
     * sets up for other test classes
     */
    public void setUp()
    {
        month1 = new Month(1, 2, 3, 4, 5, 7);
    }
    
    /**
     * Test for the getMonth method
     */
    public void testGetMonth()
    {
        assertEquals(month1.getMonth(), 1);
    }
    
    /**
     * Test for the getLikes method
     */
    public void testGetLikes()
    {
        assertEquals(month1.getLikes(), 2);
    }
    
    /**
     * Test for the getPosts method
     */
    public void testGetPosts()
    {
        assertEquals(month1.getPosts(), 3);
    }
    
    /**
     * Test for the getFollowers method
     */
    public void testGetFollowers()
    {
        assertEquals(month1.getFollowers(), 4);
    }
    
    /**
     * Test for the getComments method
     */
    public void testGetComments()
    {
        assertEquals(month1.getComments(), 5);
    }
    
    /**
     * Test for the getViews method
     */
    public void testGetViews()
    {
        assertEquals(month1.getViews(), 7);
    }
    
    /**
     * Test for the getTradRate method
     */
    public void testGetTradRate()
    {
        assertEquals(month1.getTradRate(), 175, 0.1);
    }
    
    /**
     * Test for the getReachRate method
     */
    public void testGetReachRate()
    {
        assertEquals(month1.getReachRate(), 100, 0.1);
    }
    
    /**
     * Test for the toString method
     */
    public void testToString()
    {
        assertEquals(month1.toString(), "(Month: 1, Likes: 2, Posts: 3, Followers: 4, "
            + "Comments: 5, Views: 7)");
    }
    
    
}
