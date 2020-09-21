/**
 * This program is designed to read a file, and display the content of a file
 * Also it adds a record to a file. 
 * @author Saule Buhler
 * @version 2.0
 */
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Saule_Buhler_GamesReport 
{
	public static void main(String[] args) throws IOException
	{
		File fileName = new File("//Applications//Path//GameScore.csv");
		gameReport(fileName); //method for reading a file
		addGamer(fileName, "Jimmy", 189, 190, 197, 199, 198, 193, 199, 199, 188, 196);//method to add a record to a file 
		gameReport(fileName);
	}
	//method to add a record to a file 
	private static void addGamer(File fileName, String name, int score1, int score2, int score3, int score4, int score5, 
				int score6, int score7, int score8, int score9, int score10) throws IOException
	{
		//instantiate the filewriter 
		FileWriter csvWriter = new FileWriter(fileName, true);
		csvWriter.write("\n" + name + "," + score1 + "," + score2 + "," + score3 + "," + score4 + "," + score5 + "," + score6 + "," 
		+ score7 + "," + score8 + "," + score9 + "," + score2 + "\r\n");
		csvWriter.close();
		printLine(95);
		System.out.println("Gamer " + name + " record added.");
	}
	 //method for reading a file
	private static void gameReport(File fileName) throws IOException
	{
		if(fileName.exists()) 
		{
			//declare and initialize variables 
			int score = 0;
		    int recordCount = 0;
		    String topPlayer = "";
		    int topScore = 0;
		    int num = 0;
	        String cvsSplitBy = ",";
	        //instantiate the BufferedReader
	        BufferedReader br = new BufferedReader(new FileReader(fileName));
	        printLine(95);//method dashlines 
	        System.out.println("Game Report");
	        printLine(95);
	        System.out.print("Gamer\t");
	        /**
	         * After "gamer" is printed, in the same line numbers through 1-10 
	         * will be listed horizontally. Best way would be to not do x<11,
	         * I did it because I already knew the numbers of rows, but I couldn't figure out how to
	         * do the row.length correctly.
	         */
	        for(int x = 1; x < 11; x++) 
	        {
	            System.out.printf("%d\t", x);
	        }
	        System.out.print("Total\n");
	        printLine(95);
	        String line = "";
	        while((line = br.readLine())!= null) 
	        {
	           num = line.length();
	           String tmp[] = line.split(cvsSplitBy);
	           System.out.print(tmp[0] + "\t");
	           int total = 0;
	           for(int i = 1; i < tmp.length; i++)
	           {
	            	score = Integer.parseInt(tmp[i]);
	            	System.out.print(tmp[i] + "\t"); 
	            	total = total + score;
	           }
	           recordCount++;
	           System.out.println(total + "\n");
	           System.out.println();
	           if(total>topScore) 
	           {
	        	   topScore = total;
	        	   topPlayer = tmp[0];
	           }
	         }
	         printLine(95);
	         System.out.println("# of Gamers: " + recordCount);
	         System.out.println("Top Gamer: " + topPlayer);
	         br.close();
	         fileName = null;
		}
	}
	//method for printing dashes 
	private static void printLine(int dashes) 
	{
		for(int i = 1; i <= dashes; i++) 
		{
			System.out.print("-");
		}
		System.out.println("\n");
	}
}

