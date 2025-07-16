package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 *  Comparator for Influencer that compares based on the channel name
 * 
 *  @author snvad, lalitmanmari, Kexin Zhang, Vaibhav Lokesh
 *  @version Nov 14, 2024
 */
public class CompareByChannelName implements Comparator<Influencer> {

    // ----------------------------------------------------------
    /**
     * Compare two Influencers based on channel name
     * @param left
     *          The left-hand side of the comparison
     * @param right
     *          The right-hand side of the comparison
     * @return a negative integer if the left Influencer's channel name 
     *          precedes the right's, 
     *          a positive if it follows, 
     *          or 0 if they are the same
     */
    @Override
    public int compare(Influencer left, Influencer right) {
        return left.getChannelName().toLowerCase()
            .compareTo(right.getChannelName().toLowerCase());
    }
}
