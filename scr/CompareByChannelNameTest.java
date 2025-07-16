package prj5;

// -------------------------------------------------------------------------
/**
 * Test the CompareByChannelName class
 * 
 * @author snvad, lalitmanmari, Kexin Zhang, Vaibhav Lokesh
 * @version Nov 19, 2024
 */
public class CompareByChannelNameTest
    extends student.TestCase
{
    // ~ Fields ................................................................
    private CompareByChannelName compare;
    private Influencer influencer1;
    private Influencer influencer2;

    // ~ Constructors ..........................................................
    /**
     * Set up method for the comparator and influencer. 
     */
    public void setUp()
    {
        compare = new CompareByChannelName();
        influencer1 =
            new Influencer("Username1", "Channel1", "Country1", "MainTopic1");
        influencer2 =
            new Influencer("Username2", "Channel2", "Country2", "MainTopic2");
    }


    
    /**
     * Tests the compare method.// 
     */
    public void testCompare()
    {
        assertEquals(-1, compare.compare(influencer1, influencer2));
    }

}
