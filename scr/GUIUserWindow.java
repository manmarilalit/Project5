package prj5;

import cs2.*;
import java.awt.Color;
import java.util.HashMap;

// -------------------------------------------------------------------------
/**
 * User window that displays all the information.
 * 
 * @author snvad, lalitmanmari, Kexin Zhang, Vaibhav Lokesh
 * @version Nov 14, 2024
 */
public class GUIUserWindow
{
    // ~ Fields ................................................................
    /**
     * This integer field is for the width of the bar, which we want to stay the
     * same for all the bars for aesthetics.
     */
    public static final int BAR_WIDTH = 40;
    private Window window;

    private SinglyLinkedList<Influencer> influencerList;

    private TextShape[] texts;

    private Shape[] bars;

    private Shape[] datas;

    private TextShape infoText1;
    private TextShape infoText2;
    private TextShape infoText3;

    private HashMap<String, Color> pair;

    // ~ Constructors ..........................................................
    /**
     * Constructs the User Window with bars, texts, color, and buttons.
     * 
     * @param list
     *            to receive data from the list
     */
    public GUIUserWindow(SinglyLinkedList<Influencer> list)
    {
        influencerList = list;

        window = new Window();
        window.setSize(1000, 700);

        Shape bar1 = new Shape(1, 1);
        Shape bar2 = new Shape(1, 1);
        Shape bar3 = new Shape(1, 1);
        Shape bar4 = new Shape(1, 1);

        bars = new Shape[] { bar1, bar2, bar3, bar4 };

        TextShape text1 = new TextShape(1, 1, "");
        TextShape text2 = new TextShape(1, 1, "");
        TextShape text3 = new TextShape(1, 1, "");
        TextShape text4 = new TextShape(1, 1, "");

        texts = new TextShape[] { text1, text2, text3, text4 };

        TextShape data1 = new TextShape(1, 1, "");
        TextShape data2 = new TextShape(1, 1, "");
        TextShape data3 = new TextShape(1, 1, "");
        TextShape data4 = new TextShape(1, 1, "");

        datas = new TextShape[] { data1, data2, data3, data4 };

        Color color1 = Color.RED;
        Color color2 = Color.BLUE;
        Color color3 = Color.GREEN;
        Color color4 = Color.ORANGE;

        Color[] colors = new Color[] { color1, color2, color3, color4 };

        // SORT BY CHANNEL NAME BUTTON
        Button sortChannelNameButton = new Button("Sort by Channel Name");
        sortChannelNameButton.onClick(this, "clickedSortChannelName");
        window.addButton(sortChannelNameButton, WindowSide.NORTH);
        // SORT BY ENGAMENT RATE
        Button sortEngagementRateButton = new Button("Sort by Engagement Rate");
        sortEngagementRateButton.onClick(this, "clickedSortEngagementRate");
        window.addButton(sortEngagementRateButton, WindowSide.NORTH);
        // QUIT BUTTON BUTTON
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);
        // TRADITIONAL ENGAGEMENT RATE BUTTON
        Button traditionEngagementRateButton =
            new Button("Traditional Engagement Rate");
        traditionEngagementRateButton
            .onClick(this, "clickedTraditionEngagementRate");
        window.addButton(traditionEngagementRateButton, WindowSide.WEST);
        // REACH ENGAGEMENT RATE BUTTON
        Button reachEngagementRateButton = new Button("Reach Engagement Rate");
        reachEngagementRateButton.onClick(this, "clickedReachEngagementRate");
        window.addButton(reachEngagementRateButton, WindowSide.WEST);

        Button januaryButton = new Button("January");
        januaryButton.onClick(this, "clickedJanuary");
        window.addButton(januaryButton, WindowSide.SOUTH);

        Button februaryButton = new Button("February");
        februaryButton.onClick(this, "clickedFebruary");
        window.addButton(februaryButton, WindowSide.SOUTH);

        Button marchButton = new Button("March");
        marchButton.onClick(this, "clickedMarch");
        window.addButton(marchButton, WindowSide.SOUTH);

        Button q1Button = new Button("First Quarter (Jan - March)");
        q1Button.onClick(this, "clickedQ1");
        window.addButton(q1Button, WindowSide.SOUTH);

        infoText1 = new TextShape(5, 5, "First Quarter (Jan-March)");
        infoText2 = new TextShape(5, 20, "Traditional Engagement Rate");
        infoText3 = new TextShape(5, 35, "Sorting by Channel Name");
        window.addShape(infoText1);
        window.addShape(infoText2);
        window.addShape(infoText3);
        pair = new HashMap<>();

        for (int i = 0; i < influencerList.size(); i++)
        {
            Influencer influencer = influencerList.get(i);
            pair.put(influencer.getChannelName(), colors[i % colors.length]);
        }

        influencerList.sort(new CompareByChannelName());

        for (int i = 0; i < influencerList.size(); i++)
        {
            window.removeShape(texts[i]);
            Influencer influencer = influencerList.get(i);
            Color barColor = pair.get(influencer.getChannelName());

            String name = influencer.getChannelName();
            if (influencer.getChannelName().length() > 12)
            {
                name =
                    influencer.getChannelName().substring(0, 12).toLowerCase();
            }
            else
            {
                name = influencer.getChannelName().toLowerCase();
            }
            texts[i] = (TextShape)buildText(i + 1, name);

            double data = 0;

            if (infoText2.getText().equals("Traditional Engagement Rate")
                && infoText1.getText().equals("First Quarter (Jan-March)"))
            {
                data = influencer.getEngagementRate();
            }
            int value = (int)data;
            window.removeShape(bars[i]);
            window.removeShape(datas[i]);
            bars[i] = buildShape(i + 1, value, barColor);
            datas[i] = buildData(i + 1, "" + value);
        }
    }
    // ~Public Methods ........................................................


    /**
     * Builds 4 bars for influencers and sorts them alphabetically.
     * 
     * @param button
     *            for when sort by channel name is clicked
     */
    public void clickedSortChannelName(Button button)
    {
        infoText3.setText("Sorting by Channel Name");

        influencerList.sort(new CompareByChannelName());

        for (int i = 0; i < influencerList.size(); i++)
        {
            window.removeShape(texts[i]);
            Influencer influencer = influencerList.get(i);
            Color barColor = pair.get(influencer.getChannelName());

            String name = influencer.getChannelName();
            if (influencer.getChannelName().length() > 12)
            {
                name =
                    influencer.getChannelName().substring(0, 12).toLowerCase();
            }
            else
            {
                name = influencer.getChannelName().toLowerCase();
            }
            texts[i] = (TextShape)buildText(i + 1, name);

            double data = 0;

            if (infoText2.getText().equals("Traditional Engagement Rate")
                && infoText1.getText().equals("First Quarter (Jan-March)"))
            {
                data = influencer.getEngagementRate();
            }
            else if (infoText2.getText().equals("Reach Engagement Rate")
                && infoText1.getText().equals("First Quarter (Jan-March)"))
            {
                data = influencer.getEngagementRateByReach();
            }
            else if (infoText2.getText().equals("Traditional Engagement Rate")
                && infoText1.getText().equals("January"))
            {
                data = influencer.getEngagementRateByMonth("January");
            }
            else if (infoText2.getText().equals("Reach Engagement Rate")
                && infoText1.getText().equals("January"))
            {
                data = influencer.getEngagementRateByReachByMonth("January");
            }
            else if (infoText2.getText().equals("Traditional Engagement Rate")
                && infoText1.getText().equals("February"))
            {
                data = influencer.getEngagementRateByMonth("February");
            }
            else if (infoText2.getText().equals("Reach Engagement Rate")
                && infoText1.getText().equals("February"))
            {
                data = influencer.getEngagementRateByReachByMonth("February");
            }
            else if (infoText2.getText().equals("Traditional Engagement Rate")
                && infoText1.getText().equals("March"))
            {
                data = influencer.getEngagementRateByMonth("March");
            }
            else if (infoText2.getText().equals("Reach Engagement Rate")
                && infoText1.getText().equals("March"))
            {
                data = influencer.getEngagementRateByReachByMonth("March");
            }
            int value = (int)data;
            window.removeShape(bars[i]);
            window.removeShape(datas[i]);
            bars[i] = buildShape(i + 1, value, barColor);
            datas[i] = buildData(i + 1, "" + value);

        }
    }


    /**
     * Builds 4 bars for influencers and sorts them by their engagement.
     * 
     * @param button
     *            for when sort by engagement rate is clicked
     */
    public void clickedSortEngagementRate(Button button)
    {
        infoText3.setText("Sorting by Engagement Rate");
        if (infoText2.getText().equals("Traditional Engagement Rate")
            && infoText1.getText().equals("First Quarter (Jan-March)"))
        {
            influencerList.sort(new CompareByEngagementRate());
        }
        else if (infoText2.getText().equals("Reach Engagement Rate")
            && infoText1.getText().equals("First Quarter (Jan-March)"))
        {
            influencerList.sort(new CompareByReach());
        }

        if (infoText2.getText().equals("Traditional Engagement Rate")
            && infoText1.getText().equals("January"))
        {
            influencerList.sort(new CompareByEngagementRateByMonth("January"));
        }
        else if (infoText2.getText().equals("Reach Engagement Rate")
            && infoText1.getText().equals("January"))
        {
            influencerList.sort(new CompareByReachByMonth("January"));
        }
        // ---------------------------------------------------------------------
        else if (infoText2.getText().equals("Traditional Engagement Rate")
            && infoText1.getText().equals("February"))
        {
            influencerList.sort(new CompareByEngagementRateByMonth("February"));
        }
        else if (infoText2.getText().equals("Reach Engagement Rate")
            && infoText1.getText().equals("February"))
        {
            influencerList.sort(new CompareByReachByMonth("February"));
        }

        else if (infoText2.getText().equals("Traditional Engagement Rate")
            && infoText1.getText().equals("March"))
        {
            influencerList.sort(new CompareByEngagementRateByMonth("March"));
        }
        else if (infoText2.getText().equals("Reach Engagement Rate")
            && infoText1.getText().equals("March"))
        {
            influencerList.sort(new CompareByReachByMonth("March"));
        }

        for (int i = 0; i < influencerList.size(); i++)
        {
            window.removeShape(texts[i]);
            Influencer influencer = influencerList.get(i);
            Color barColor = pair.get(influencer.getChannelName());

            String name = influencer.getChannelName();
            if (influencer.getChannelName().length() > 12)
            {
                name =
                    influencer.getChannelName().substring(0, 12).toLowerCase();
            }
            else
            {
                name = influencer.getChannelName().toLowerCase();
            }
            texts[i] = (TextShape)buildText(i + 1, name);

            double data = 0;
            if (infoText2.getText().equals("Traditional Engagement Rate")
                && infoText1.getText().equals("First Quarter (Jan-March)"))
            {
                data = influencer.getEngagementRate();
            }
            else if (infoText2.getText().equals("Reach Engagement Rate")
                && infoText1.getText().equals("First Quarter (Jan-March)"))
            {
                data = influencer.getEngagementRateByReach();
            }
            else if (infoText2.getText().equals("Traditional Engagement Rate")
                && infoText1.getText().equals("January"))
            {
                data = influencer.getEngagementRateByMonth("January");
            }
            else if (infoText2.getText().equals("Reach Engagement Rate")
                && infoText1.getText().equals("January"))
            {
                data = influencer.getEngagementRateByReachByMonth("January");
            }
            else if (infoText2.getText().equals("Traditional Engagement Rate")
                && infoText1.getText().equals("February"))
            {
                data = influencer.getEngagementRateByMonth("February");
            }
            else if (infoText2.getText().equals("Reach Engagement Rate")
                && infoText1.getText().equals("February"))
            {
                data = influencer.getEngagementRateByReachByMonth("February");
            }
            else if (infoText2.getText().equals("Traditional Engagement Rate")
                && infoText1.getText().equals("March"))
            {
                data = influencer.getEngagementRateByMonth("March");
            }
            else if (infoText2.getText().equals("Reach Engagement Rate")
                && infoText1.getText().equals("March"))
            {
                data = influencer.getEngagementRateByReachByMonth("March");
            }
            int value = (int)data;
            window.removeShape(bars[i]);
            bars[i] = buildShape(i + 1, value, barColor);
            datas[i] = buildData(i + 1, "" + value);
        }
    }


    /**
     * Private helper method that displays data by traditional engagement rate
     * depending on if sort by name or sort by engagement rate is selected.
     * 
     * @param button
     *            for when Tradition Engagement Rate is clicked
     */
    public void clickedTraditionEngagementRate(Button button)
    {
        infoText2.setText("Traditional Engagement Rate");
        if (infoText3.getText().equals("Sorting by Channel Name"))
        {
            clickedSortChannelName(button);
        }
        else if (infoText3.getText().equals("Sorting by Engagement Rate"))
        {
            clickedSortEngagementRate(button);
        }

    }


    /**
     * Private helper method that displays data by reach engagement rate
     * depending on if sort by name or sort by engagement rate is selected.
     * 
     * @param button
     *            for when Reach Engagement Rate is clicked
     */
    public void clickedReachEngagementRate(Button button)
    {
        infoText2.setText("Reach Engagement Rate");
        if (infoText3.getText().equals("Sorting by Channel Name"))
        {
            clickedSortChannelName(button);
        }
        else if (infoText3.getText().equals("Sorting by Engagement Rate"))
        {
            clickedSortEngagementRate(button);
        }
    }


    /**
     * Private helper method which builds text under the designated bar.
     * 
     * @param numberText
     *            for how many text you want to build
     * @param text
     *            for the text you want to display
     */
    private Shape buildText(int numberText, String text)
    {
        int x = window.getGraphPanelWidth() / 5;
        Shape textShape =
            new TextShape((x * numberText) - BAR_WIDTH / 2, 500, text);
        window.removeShape(textShape);
        window.addShape(textShape);
        return textShape;
    }


    /**
     * Private helper method which builds text under the designated bar that
     * represents the data
     * 
     * @param numberData
     *            how many texts you want to build
     * @param data
     *            the string being displayed
     */
    private Shape buildData(int numberData, String data)
    {
        int x = (window.getGraphPanelWidth() / 5);
        Shape textShape =
            new TextShape((x * numberData) - BAR_WIDTH / 2, 515, data);
        window.removeShape(textShape);
        window.addShape(textShape);
        return textShape;
    }


    /**
     * Private helper method that build the bars displaying the data
     * 
     * @param numberBar
     *            for how many bars you want to build
     * @param data
     *            for the height of the bar
     * @param color
     *            for the color of the bar
     */
    private Shape buildShape(int numberBar, int data, Color color)
    {
        int x = window.getGraphPanelWidth() / 5;
        Shape bar1 = new Shape(
            (x * numberBar) - BAR_WIDTH / 2,
            500 - data,
            BAR_WIDTH,
            data,
            color);
        window.removeShape(bar1);
        window.addShape(bar1);
        return bar1;
    }

    // NORTH BUTTON METHODS


    /**
     * Exists the window with executed
     * 
     * @param button
     *            for when quit is clicked
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }

    // WEST BUTTON METHODS


    // SOUTH BUTTON METHODS
    /**
     * Shows info from January when executed.
     * 
     * @param button
     *            for when January is clicked
     */
    public void clickedJanuary(Button button)
    {
        infoText1.setText("January");
        if (infoText3.getText().equals("Sorting by Channel Name"))
        {
            clickedSortChannelName(button);
        }
        else if (infoText3.getText().equals("Sorting by Engagement Rate"))
        {
            clickedSortEngagementRate(button);
        }

    }


    /**
     * Shows info from February when executed
     * 
     * @param button
     *            for when February is clicked
     */
    public void clickedFebruary(Button button)
    {
        infoText1.setText("February");
        if (infoText3.getText().equals("Sorting by Channel Name"))
        {
            clickedSortChannelName(button);
        }
        else if (infoText3.getText().equals("Sorting by Engagement Rate"))
        {
            clickedSortEngagementRate(button);
        }
    }


    /**
     * Shows info from March when executed
     * 
     * @param button
     *            for when march is clicked
     */
    public void clickedMarch(Button button)
    {
        infoText1.setText("March");
        if (infoText3.getText().equals("Sorting by Channel Name"))
        {
            clickedSortChannelName(button);
        }
        else if (infoText3.getText().equals("Sorting by Engagement Rate"))
        {
            clickedSortEngagementRate(button);
        }
    }


    /**
     * Shows info from Quarter 1 when executed
     * 
     * @param button
     *            for when Q1 is clicked
     */
    public void clickedQ1(Button button)
    {
        infoText1.setText("First Quarter (Jan-March)");
        if (infoText3.getText().equals("Sorting by Channel Name"))
        {
            clickedSortChannelName(button);
        }
        else if (infoText3.getText().equals("Sorting by Engagement Rate"))
        {
            clickedSortEngagementRate(button);
        }
    }

}
