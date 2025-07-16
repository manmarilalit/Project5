package prj5;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Test Class for Influencer
 * 
 *  @author snvad, lalitmanmari, Kexin Zhang, Vaibhav Lokesh
 *  @version Nov 19, 2024
 */
public class InfluencerTest extends TestCase {
    private Influencer i1;
    private MonthlyData[] statistics;
    private Influencer i2;
    
    
    // ----------------------------------------------------------
    /**
     * Sets up the test cases
     */
    public void setUp() {
        i1 = new Influencer("user1", "ArtAllDay", "US", "art");
        statistics = i1.getStatistics();
        i1.addEntry(new MonthlyData("January", 1000, 10, 500, 1000, 10000));
        i1.addEntry(new MonthlyData("February", 1000, 10, 750, 1000, 15000));
        i1.addEntry(new MonthlyData("March", 1000, 10, 1000, 1000, 20000));
        i1.addEntry(new MonthlyData("April", 1000, 10, 500, 1000, 30000));
        
        i2 = new Influencer("user1", "ArtAllDay", "US", "art");
        
        i2.addEntry(new MonthlyData("January", 1000, 10, 500, 1000, 0));
        i2.addEntry(new MonthlyData("February", 1000, 10, 750, 1000, 0));
        i2.addEntry(new MonthlyData("March", 1000, 10, 0, 1000, 0));
        i2.addEntry(new MonthlyData("April", 1000, 10, 500, 1000, 30000));

        
    }
    
    // ----------------------------------------------------------
    /**
     * Tests getUsername()
     */
    public void testGetUsername() { 
        assertEquals("user1", i1.getUsername());
    }
    
    // ----------------------------------------------------------
    /**
     * Tests getChannelName()
     */
    public void testGetChannelName() { 
        assertEquals("ArtAllDay", i1.getChannelName());
    }
    
    // ----------------------------------------------------------
    /**
     * Tests getCountry()
     */
    public void testGetCountry() { 
        assertEquals("US", i1.getCountry());
    }
    
    // ----------------------------------------------------------
    /**
     * Tests getMainTopic()
     */
    public void testGetMainTopic() { 
        assertEquals("art", i1.getMainTopic());
    }
    
    // ----------------------------------------------------------
    /**
     * Tests getStatistics()
     */
    public void testGetStatistics() { 
        assertEquals(statistics, i1.getStatistics());
    }
    
    // ----------------------------------------------------------
    /**
     * Tests getEngagementRate()
     */
    public void testGetEngagementRate() {
        assertEquals(600, i1.getEngagementRate(), 0.01);
        assertEquals(-1, i2.getEngagementRate(), 0.01);
    }
    
    // ----------------------------------------------------------
    /**
     * Tests getEngagementRateByReach()
     */
    public void testGetEngagementRateByReach() {
        assertEquals(13.333, i1.getEngagementRateByReach(), 0.001);
        assertEquals(-1, i2.getEngagementRateByReach(), 0.01);
    }
    
    // ----------------------------------------------------------
    /**
     * Tests addEntry()
     */
    public void testAddEntry() { 
        MonthlyData newMonth = new MonthlyData("May", 1, 1, 1, 1, 1);
        i1.addEntry(newMonth);
        assertEquals(newMonth, statistics[4]);
    }
    /**
     * Tests getEngagementRateByReachByMonth(String month)
     */
    public void testGetEngagementRateByReachByMonth()
    {
        assertEquals(10.0, i1.getEngagementRateByReachByMonth("March"), 0.001);
        assertEquals(-1, i2.getEngagementRateByReachByMonth("March"), 0.01);
    }
    /**
     * Tests getEngagementRateByMonth(String month) 
     */
    public void testGetEngagementRateByMonth()
    {
        assertEquals(200.0, i1.getEngagementRateByMonth("March"), 0.001);
        assertEquals(-1, i2.getEngagementRateByMonth("March"), 0.01);
    }
}
