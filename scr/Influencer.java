package prj5;

// -------------------------------------------------------------------------
/**
 * Class for the Influencer object
 * 
 * @author snvad, lalitmanmari, Kexin Zhang, Vaibhav Lokesh
 * @version Nov 14, 2024
 */
public class Influencer
{

    private String username;
    private String channelName;
    private String country;
    private String mainTopic;
    private MonthlyData[] statistics;
    private int currIndex;
    private double engagementRate;
    private double engagementRateByReach;

    // ----------------------------------------------------------
    /**
     * Create a new Influencer object.
     * 
     * @param username
     *            The username of the Influencer
     * @param channelName
     *            The channel name of the Influencer
     * @param country
     *            The country of the Influencer
     * @param mainTopic
     *            The main topic of the Influencer
     */
    public Influencer(
        String username,
        String channelName,
        String country,
        String mainTopic)
    {
        this.username = username;
        this.channelName = channelName;
        this.country = country;
        this.mainTopic = mainTopic;
        this.statistics = new MonthlyData[12];
        this.currIndex = 0;
    }


    // ----------------------------------------------------------
    /**
     * Returns the username of the Influencer.
     * 
     * @return username
     */
    public String getUsername()
    {
        return this.username;
    }


    // ----------------------------------------------------------
    /**
     * Returns the channel name of the Influencer.
     * 
     * @return channelName
     */
    public String getChannelName()
    {
        return this.channelName;
    }


    // ----------------------------------------------------------
    /**
     * Returns the country of the Influencer.
     * 
     * @return country
     */
    public String getCountry()
    {
        return this.country;
    }


    // ----------------------------------------------------------
    /**
     * Returns the main topic of the Influencer.
     * 
     * @return mainTopic
     */
    public String getMainTopic()
    {
        return this.mainTopic;
    }


    // ----------------------------------------------------------
    /**
     * Returns the statistics of the Influencer.
     * 
     * @return statistics
     */
    public MonthlyData[] getStatistics()
    {
        return this.statistics;
    }


    // ----------------------------------------------------------
    /**
     * Returns the engagement rate of the Influencer.
     * 
     * @return engagementRate
     */
    public double getEngagementRate()
    {
        int followers = 0;
        int likes = 0;
        int comments = 0;
        for (int i = 0; i < statistics.length; i++)
        {
            if (statistics[i] != null)
            {
                String currMonth = statistics[i].getMonth();

                if (currMonth.equals("January") || currMonth.equals("February")
                    || currMonth.equals("March"))
                {
                    likes += statistics[i].getLikes();
                    comments += statistics[i].getComments();

                    if (currMonth.equals("March"))
                    {
                        followers = statistics[i].getFollowers();
                    }
                }
            }
        }
        if (followers == 0)
        {
            this.engagementRate = -1;
        }
        else
        {
            this.engagementRate = ((double)comments + likes) / followers * 100;
        }
        return this.engagementRate;
    }


    // ----------------------------------------------------------
    /**
     * Returns the engagement rate by reach of the Influencer.
     * 
     * @return engagementRateByReach
     */
    public double getEngagementRateByReach()
    {
        int views = 0;
        int likes = 0;
        int comments = 0;
        for (int i = 0; i < statistics.length; i++)
        {
            if (statistics[i] != null)
            {
                String currMonth = statistics[i].getMonth();
                if (currMonth.equals("January") || currMonth.equals("February")
                    || currMonth.equals("March"))
                {
                    views += statistics[i].getViews();
                    likes += statistics[i].getLikes();
                    comments += statistics[i].getComments();
                }
            }
        }
        if (views == 0)
        {
            this.engagementRateByReach = -1;
        }
        else
        {
            this.engagementRateByReach =
                ((double)comments + likes) / views * 100;
        }
        return this.engagementRateByReach;
    }


    // ----------------------------------------------------------
    /**
     * Adds a new MonthlyData object to the statistics for the Influencer
     * 
     * @param md
     *            The new MonthlyData object
     */
    public void addEntry(MonthlyData md)
    {
        this.statistics[currIndex++] = md;
    }


    /**
     * Returns the traditional engagement rate of the Influencer.
     * @param month to know what months data to get
     * 
     * @return engagementRate
     */
    public double getEngagementRateByMonth(String month)
    {
        int followers = 0;
        int likes = 0;
        int comments = 0;
        for (int i = 0; i < statistics.length; i++)
        {
            if (statistics[i] != null)
            {
                String currMonth = statistics[i].getMonth();

                if (currMonth.equals(month))
                {
                    likes += statistics[i].getLikes();
                    comments += statistics[i].getComments();
                    followers = statistics[i].getFollowers();
                }
            }
        }

        if (followers == 0)
        {
            this.engagementRate = -1;
        }
        else
        {
            this.engagementRate = ((double)comments + likes) / followers * 100;
        }
        return this.engagementRate;
    }
    /**
     * Returns the reach engagement rate of the Influencer.
     * @param month to know what months data to get
     * @return engagementRateByReach
     */
    public double getEngagementRateByReachByMonth(String month)
    {
        int views = 0;
        int likes = 0;
        int comments = 0;
        for (int i = 0; i < statistics.length; i++)
        {
            if (statistics[i] != null)
            {
                String currMonth = statistics[i].getMonth();
                if (currMonth.equals(month))
                { 
                    views += statistics[i].getViews();
                    likes += statistics[i].getLikes();
                    comments += statistics[i].getComments();
                }
            }
        }
        if (views == 0)
        {
            this.engagementRateByReach = -1;
        }
        else
        {
            this.engagementRateByReach =
                ((double)comments + likes) / views * 100;
        }
        return this.engagementRateByReach;
    }
}
