package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 *  Comparator for Influencer that compares based on the Engagement Rate by 
 *  reach
 *   
 *  @author snvad, lalitmanmari, Kexin Zhang, Vaibhav Lokesh
 *  @version Nov 19, 2024
 */
public class CompareByReach implements Comparator<Influencer> {

    // ----------------------------------------------------------
    /**
     * Compare two Influencers based on engagement rate
     * @param left
     *          The left-hand side of the comparison
     * @param right
     *          The right-hand side of the comparison
     * @return a negative integer if the left Influencer's E.R. is less than 
     *          the right's, 
     *          a positive integer if it's greater, 
     *          or 0 if they are equal
     */
    @Override
    public int compare(Influencer left, Influencer right) {
        double diff = right.getEngagementRateByReach() - 
            left.getEngagementRateByReach();
        if (diff < 0) {
            return -1;
        }
        if (diff > 0) {
            return 1;
        }
        return 0;
    }
}
