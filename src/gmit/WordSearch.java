package gmit;

import java.util.*;
import java.io.*;

public class WordSearch 
{

	public static void main(String[] args) throws IOException
	{
		Scanner console = new Scanner(System.in);
		
		String word;
		//StopWords ignore = new StopWords("stopwords.txt");
		
		//System.out.println(ignore.getStopWords());
		//System.out.println(ignore.toString());
		
		//Dictionary dictionary = new Dictionary("dictionary.csv");
		
		//System.out.println(dictionary.getSize());
		//System.out.println(dictionary.getWords());
		//System.out.println(dictionary.getDefinition("plague"));
		
		//Create new indexing map with text book - War And Peace
		BookIndexer map = new BookIndexer("WarAndPeace-LeoTolstoy.txt");
		
		System.out.println("==========A Java Indexing and Dictionary API==========");
		
		System.out.print("\nEnter word to search: ");
		word = console.next();
		
		while(word.equalsIgnoreCase("EXIT") == false)
		{
			System.out.println(map.searchWord(word));
			
			System.out.print("\nEnter word to search: ");
			word = console.next();
			
		} //end while
		
	} //end main
	
} //end class
