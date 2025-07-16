package prj5;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author snvad, lalitmanmari, Kexin Zhang, Vaibhav Lokesh
 * @version Nov 14, 2024
 */
public class ProjectRunner
{
    /**
     * constant field for rate
     */
    public static final double CONSTANT_RATE = -1.0;

    // ----------------------------------------------------------
    /**
     * The main method processes the influencer data and displays user views.
     * 
     * @param args
     *            The first argument is the file name.
     * @throws FileNotFoundException
     *             If the specified file is not found.
     */
    public static void main(String[] args)
        throws FileNotFoundException
    {

        InputFileReader filer;

        if (args.length > 0)// should this be args.length == 1 instead? I may be
                            // wrong
        // just that I saw it on the instructions
        {
            filer = new InputFileReader(args[0]);
        }
        else
        {
            filer = new InputFileReader("SampleInput1_2023.csv");
        } 
        SinglyLinkedList<Influencer> influencerList =
            filer.getInfluencerLinkedList();

        boolean showConsole = true;
        boolean showGUI = true;

        // TODO: For intermediate Submission - Should print the data on the
        // console
        if (showConsole)
        {
            printTraditionalEngagementRate(influencerList);
            printReachEngagementRate(influencerList);
            //printTraditionalEngagementRateByMonth(influencerList, "January");
            //printReachEngagementRateByMonth(influencerList, "January");
        }

        // TODO: For final Submission - Should have the GUI display for the
        // input data
        if (showGUI)
        {
            GUIUserWindow window = new GUIUserWindow(influencerList);
            
        }
    } 


    

    /**
     * Displays influencers with their traditional engagement rates.
     * 
     * @param influencerList
     *            The list of influencers to display.
     */
    private static void printTraditionalEngagementRate(
        SinglyLinkedList<Influencer> influencerList)
    {
        influencerList.sort(new CompareByChannelName());
        DecimalFormat dformat = new DecimalFormat("#.#");
        for (int i = 0; i < influencerList.size(); i++)
        {
            Influencer influencer = influencerList.get(i);
            double traditionalRate = influencer.getEngagementRate();
            String formatted;
            if (traditionalRate == CONSTANT_RATE)
            {
                formatted = "N/A";
            }
            else
            {
                formatted = dformat.format(traditionalRate);
            }
            System.out.println(influencer.getChannelName());
            System.out.println("traditional: " + formatted);
            System.out.println("==========");

        }
        System.out.println("**********");
        System.out.println("**********");
    }


    /**
     * Displays influencers with Reach Engagement Rate.
     * 
     * @param influencerList
     *            The list of influencers to display.
     */
    private static void printReachEngagementRate(
        SinglyLinkedList<Influencer> influencerList)
    {
        DecimalFormat df = new DecimalFormat("#.#");
        influencerList.sort(new CompareByReach());
        for (int i = 0; i < influencerList.size(); i++)
        { 
            Influencer influencer = influencerList.get(i);
            double reachRate = influencer.getEngagementRateByReach();
            String formattedReach;
            if (reachRate == CONSTANT_RATE)
            {
                formattedReach = "N/A";
            }
            else
            {
                formattedReach = df.format(reachRate);
            }
            System.out.println(influencer.getChannelName());
            System.out.println("reach: " + formattedReach);
            System.out.println("==========");
        }
    }
    /**
     * Displays influencers with their traditional engagement rates.
     * 
     * @param influencerList
     *            The list of influencers to display.
     */
    private static void printTraditionalEngagementRateByMonth(
        SinglyLinkedList<Influencer> influencerList, String month)
    {
        influencerList.sort(new CompareByChannelName());
        DecimalFormat dformat = new DecimalFormat("#.#");
        for (int i = 0; i < influencerList.size(); i++)
        {
            Influencer influencer = influencerList.get(i);
            double traditionalRate = influencer.getEngagementRateByMonth(month);
            String formatted;
            if (traditionalRate == CONSTANT_RATE)
            {
                formatted = "N/A";
            }
            else
            {
                formatted = dformat.format(traditionalRate);
            }
            System.out.println(influencer.getChannelName());
            System.out.println("traditional: " + formatted);
            System.out.println("==========");

        }
        System.out.println("**********");
        System.out.println("**********");
    }


    /**
     * Displays influencers with Reach Engagement Rate.
     * 
     * @param influencerList
     *            The list of influencers to display.
     */
    private static void printReachEngagementRateByMonth(
        SinglyLinkedList<Influencer> influencerList, String month)
    {
        DecimalFormat df = new DecimalFormat("#.#");
        influencerList.sort(new CompareByReach());
        for (int i = 0; i < influencerList.size(); i++)
        { 
            Influencer influencer = influencerList.get(i);
            double reachRate = influencer.getEngagementRateByReachByMonth(month);
            String formattedReach;
            if (reachRate == CONSTANT_RATE)
            {
                formattedReach = "N/A";
            }
            else
            {
                formattedReach = df.format(reachRate);
            }
            System.out.println(influencer.getChannelName());
            System.out.println("reach: " + formattedReach);
            System.out.println("==========");
        }
    }

}
