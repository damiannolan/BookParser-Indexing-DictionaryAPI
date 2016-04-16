package gmit;

import java.util.*;
import java.io.*;

public class WordSearch 
{

	public static void main(String[] args) throws IOException
	{
		Scanner console = new Scanner(System.in);
		
		String word = " ";
		String filename;
		
		/* 
		 * Test Code below testing object instantiated with the StopWords, Dictionary and BookIndexer classes
		 * */
		
		//StopWords ignore = new StopWords("stopwords.txt");
		
		//System.out.println(ignore.getStopWords());
		//System.out.println(ignore.toString());
		
		//Dictionary dictionary = new Dictionary("dictionary.csv");
		
		//System.out.println(dictionary.getSize());
		//System.out.println(dictionary.getWords());
		//System.out.println(dictionary.getDefinition("plague"));
		
		//Create new indexing map with text book - War And Peace
		//BookIndexer map = new BookIndexer("WarAndPeace-LeoTolstoy.txt");
		
		System.out.println("==========A Java Indexing and Dictionary API==========");
				
		while(word.equalsIgnoreCase("EXIT") == false)
		{
			try
			{
				System.out.print("\nEnter Filename: ");
				filename = console.next();
				
				BookIndexer map = new BookIndexer(filename);
				
				System.out.print("\nEnter word to search: ");
				word = console.next();
				
				while(word.equalsIgnoreCase("EXIT") == false)
				{
					System.out.println(map.searchWord(word));
					
					System.out.print("\nEnter word to search: ");
					word = console.next();
					
				} //end while
			}
			catch(IOException e) //If the filename could not be found, catch the IOException and print appropriate message to user
			{
				//System.out.println(e.toString());
				System.out.println("\nError!\nThe filename specified could not be found. Please try again.");
			}
		}		
		
	} //end main
	
} //end class
