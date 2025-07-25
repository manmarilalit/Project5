package prj5;

// -------------------------------------------------------------------------
/**
 * tests the CompareByEngagementRate class
 * 
 * @author snvad, lalitmanmari, Kexin Zhang, Vaibhav Lokesh
 * @version Nov 19, 2024
 */
public class CompareByEngagmentRateTest
    extends student.TestCase
{
    // ~ Fields ................................................................
    private CompareByEngagementRate compare;
    private Influencer influencer1;
    private Influencer influencer2;
   

    // ~ Constructors ..........................................................
    /**
     * setup method for the test
     */
    public void setUp()
    {
        compare = new CompareByEngagementRate();
        influencer1 =
            new Influencer("Username1", "Channel1", "Country1", "MainTopic1");
        influencer2 =
            new Influencer("Username2", "Channel2", "Country2", "MainTopic2");
        MonthlyData statistics1 = new MonthlyData(
            "March", 100, 40, 100, 10, 100);
        MonthlyData statistics2 = new MonthlyData(
            "March", 120, 10, 90, 20, 200);
        
        influencer1.addEntry(statistics1);
        influencer2.addEntry(statistics2);

    }
    // ~Public Methods ........................................................
    /**
     * tests compare method
     */
    public void testCompare()
    {
        System.out.println(influencer1.getEngagementRate());
        System.out.println(influencer1.getEngagementRate());
        assertEquals(1, compare.compare(influencer1, influencer2));
        assertEquals(0, compare.compare(influencer1, influencer1));
        assertEquals(-1, compare.compare(influencer2, influencer1));

    }
}
