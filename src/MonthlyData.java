package prj5;

// -------------------------------------------------------------------------
/**
 *  Object that stores the monthly data for the Influencer
 * 
 *  @author snvad, lalitmanmari, Kexin Zhang, Vaibhav Lokesh
 *  @version Nov 14, 2024
 */
public class MonthlyData {

    private String month;
    private int likes;
    private int posts;
    private int followers;
    private int comments;
    private int views;
    
    // ----------------------------------------------------------
    /**
     * Create a new MonthlyData object.
     * @param month
     *          The month for the data stored
     * @param likes
     *          The total number of likes
     * @param posts
     *          The total number of posts
     * @param followers
     *          The total number of followers that month
     * @param comments
     *          The total number of comments
     * @param views
     *          The total number of views
     */
    public MonthlyData(String month, int likes, int posts, 
        int followers, int comments, int views) { 
        
        this.month = month;
        this.likes = likes;
        this.posts = posts;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
    }
    
    // ----------------------------------------------------------
    /**
     * Returns the month
     * @return month
     */
    public String getMonth() {
        return this.month;
    }
    
    // ----------------------------------------------------------
    /**
     * Returns the total number of likes.
     * @return likes
     */
    public int getLikes() {
        return this.likes;
    }
    
    // ----------------------------------------------------------
    /**
     * Returns the total number of posts.
     * @return posts
     */
    public int getPosts() {
        return this.posts;
    }

    // ----------------------------------------------------------
    /**
     * Returns the total number of followers
     * @return followers
     */
    public int getFollowers() {
        return this.followers;
    }

    // ----------------------------------------------------------
    /**
     * Returns the total number of comments.
     * @return comments
     */
    public int getComments() {
        return this.comments;
    }

    // ----------------------------------------------------------
    /**
     * Returns the total number of views.
     * @return views
     */
    public int getViews() {
        return this.views;
    }    
    
}
