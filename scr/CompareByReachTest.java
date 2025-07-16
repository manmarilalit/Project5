package prj5;
import student.TestCase;
// -------------------------------------------------------------------------
/**
 *  Test class for CompareByReach
 * 
 *  @author snvad, lalitmanmari, Kexin Zhang, Vaibhav Lokesh
 *  @version Nov 19, 2024
 */
public class CompareByReachTest
    extends TestCase
{
    private CompareByReach compareCase;
    private Influencer influencerA;
    private Influencer influencerB;
    //~ Fields ................................................................

    /**
     * setup for the tests
     */
    public void setUp() {
        compareCase = new CompareByReach();
        this.influencerA = 
            new Influencer("Bob", "Bob's Channel", "US", "Food");
        this.influencerB = 
            new Influencer("Sarah", "Sarah's Channel", "US", "Sport");
        MonthlyData monthlyDataA = 
            new MonthlyData("January", 10000, 200, 2000, 100, 3000);
        MonthlyData monthlyDataB = 
            new MonthlyData("February", 20000, 300, 4000, 200, 4000);
        influencerA.addEntry(monthlyDataA);
        influencerB.addEntry(monthlyDataB);
    }
    
    /**
     * tests for the compare method
     */
    public void testCompare() {
        assertEquals(compareCase.compare(influencerA, influencerB), 1);
        assertEquals(compareCase.compare(influencerB, influencerA), -1);
        assertEquals(compareCase.compare(influencerA, influencerA), 0);
    }

}
