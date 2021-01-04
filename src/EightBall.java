/**
 * this program responds to the users question with a random answer that comes from the 
 * novelty magic 8ball toys
 */
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EightBall {   
	
	 
    public static final int opti = 20;
    //limit for array
    static String[] magic = new String[opti];
    //sets up an array with limit opti
    public static String foresight = "answers.txt";
    //makes it so that the text file can be read in the future
       /**
        * This is the main method of the magic eight ball
        * it runs the methods fileOptions and MagicShow
        * @param args
        * @throws IOException
        */
    public static void main(String[] args) throws IOException {
    	fileOptions(foresight);
        //puts every line in the text file in its own array location
         MagicShow(magic);
        //asks user to input a question then it chooses a random line from the array to output
    }
    /**
     * this method reads the text file answers.txt and stores it into the array magic
     * @param foresight
     * @throws IOException
     */
    public static void fileOptions(String foresight) throws IOException {
        int count = 0;//initializes count
        Path reader = Paths.get(foresight);
        //creates a path to read the text file
        Scanner predictions = new Scanner(reader);
        //reads file
        while (predictions.hasNextLine()) {
            //differentiates each line into its own spot in the array
            String indiv = predictions.nextLine();
            //moves on to the next line
            magic[count] = indiv;
            //adds the string from the text file into the array
            count++;
            //adds to count
        }   
         
       
    }
    /**
     * this method randomly picks from the Strings in the array magic and displays it as the prediction
     * @param magic
     */
    public static void MagicShow(String[] magic) {
        Scanner examination = new Scanner(System.in);
        //sets up scanner that will be used for user input
        boolean fortune = true;
        //set up for the while loop
        while(fortune) {
            System.out.println("Ask the Magic Ball a question.");
            System.out.println("If you don't have any questions, type no");
            //asks user to input a question or a no
            String inquiry = examination.nextLine();
            //user's input
            if(inquiry.equalsIgnoreCase("no")) {
            	System.out.println("Come back if you need the wisdom of the magic ball.");
                fortune = false;
                //ends the while loop
                break;
                //without the break, the program will give a response when the user inputs "no"
            }

            Random truth = new Random();
            //sets up variable for random number
            int genie = truth.nextInt(19);
            //variable decides and houses random number
            System.out.println(magic[genie]);
            //prints the string stored in the array magic
            System.out.println();
            //goes to next line
            
            }
    }
}
