package prj5;

import student.TestCase;

/**
 * This class is a test class for the MonthlyData class. It tests all the
 * methods in the class.
 * 
 * @author snvad, lalitmanmari, Kexin Zhang, Vaibhav Lokesh
 * @version Nov 19, 2024
 */
public class MonthlyDataTest
    extends TestCase
{
    private MonthlyData md;

    /**
     * Method to test setup a monthlyData object.
     */
    public void setUp()
    {
        md = new MonthlyData("January", 1000, 100, 2000, 100, 3000);
    }


    /**
     * Method to test the getMonth method.
     */
    public void testGetMonth()
    {
        assertEquals("January", md.getMonth());
    }


    /**
     * Method to test the getLikes method.
     */
    public void testGetLikes()
    {
        assertEquals(1000, md.getLikes());
    }


    /**
     * Method to test the getPosts method.
     */
    public void testGetPosts()
    {
        assertEquals(100, md.getPosts());
    }


    /**
     * Method to test the getFollowers method.
     */
    public void testGetFollowers()
    {
        assertEquals(2000, md.getFollowers());
    }


    /**
     * Method to test the getComments method.
     */
    public void testGetComments()
    {
        assertEquals(100, md.getComments());
    }


    /**
     * Method to test the getViews method.
     */
    public void testGetViews()
    {
        assertEquals(3000, md.getViews());
    }

}
