package prj5;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * InputFileReader reads influencer data from a CSV file, and populates
 * valid data into a SingularLinkedList of Influencer objects.
 * 
 *  @author snvad, lalitmanmari, Kexin Zhang, Vaibhav Lokesh
 *  @version Nov 14, 2024
 */
public class InputFileReader
{
    private SinglyLinkedList<Influencer> lList;
    
    /**
     * Constructor that initializes and processes the input file.
     * @param fileName the name of the input file
     * @throws FileNotFoundException if the file is not found
     */
    public InputFileReader(String fileName) throws FileNotFoundException {
        lList = new SinglyLinkedList<>(); 
        readInfluencersFile(fileName);
    }
    
    /**
     * Helper method to convert a string to an integer.
     * @param str the string to convert
     * @return the integer value, or 0 if the string is invalid
     */
    private int toInt(String str){

        try{
            return Integer.parseInt(str);
        }
        catch(Exception e){
            return 0;
        }
    }
    
    
    /**
     * Method to read the file and to populate the
     * SingularLinkedList of influencers.
     * @param fileName the name of the input file
     * @throws FileNotFoundException if the file is not found
     */
    private void readInfluencersFile(String fileName) throws
    FileNotFoundException {
        File iFile = new File(fileName);
        Scanner inStream = new Scanner(iFile);
        inStream.nextLine();
        
        while (inStream.hasNextLine()) {
            String line = inStream.nextLine().replaceAll(" ", "");
            String[] values = line.split(",");
            if (values.length == 10) {
                String month = values[0];
                String username = values[1];
                String channel = values[2];
                String country = values[3];
                String mainTopic = values[4];
                int likes = toInt(values[5]);
                int posts = toInt(values[6]);
                int followers = toInt(values[7]);
                int comments = toInt(values[8]);
                int views = toInt(values[9]);
                
                if (isValidMonth(month)) {
                    MonthlyData stats = new MonthlyData(
                        month, likes, posts, followers, comments, views);
                    Influencer influencer = findInfluencer(username);
                    if (influencer != null) {
                        influencer.addEntry(stats);
                    }
                    else {
                        Influencer newInfluencer = new Influencer(
                            username, channel, country, mainTopic);
                        newInfluencer.addEntry(stats);
                        lList.add(newInfluencer);
                    }
                }
            }
        }
        inStream.close();
    }
    
    /**
     * Helper method to validate if the month is valid (January to December).
     * @param month the month string to validate
     * @return true if the month is valid, false otherwise
     */
    private boolean isValidMonth(String month) {
        switch (month) {
            case "January":
            case "February":
            case "March":
            case "April":
            case "May":
            case "June":
            case "July":
            case "August":
            case "September":
            case "October":
            case "November":
            case "December":
                return true;
            default:
                return false;
        }
    }

    
    /**
     * Helper method to find an existing Influencer 
     * in the linked list by username.
     * @param username the username of the influencer to find
     * @return the Influencer if found, null otherwise
     */
    private Influencer findInfluencer(String username) {
        for (int i = 0; i < lList.size(); i++) {
            if (lList.get(i).getUsername().equals(username)) {
                return lList.get(i);
            }
        }
        return null;
    }
    
    /**
     * Method to get the linked list of influencers
     * @return the linked list of influencers
     */
    public SinglyLinkedList<Influencer> getInfluencerLinkedList() {
        return lList;
    }
   
}
