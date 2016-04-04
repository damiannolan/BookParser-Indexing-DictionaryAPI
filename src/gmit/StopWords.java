package gmit;

import java.io.*;
import java.util.*;

public class StopWords
{
	Set<String> stopWords = new TreeSet<String>();
	
	//Default
	public StopWords()
	{
		this.stopWords = new TreeSet<String>();
	}
	
	public StopWords(String fileName)
	{
	//Provide the path to stopwords.txt and add to TreeSet	
		try 
		{
			Scanner ignoreFile = new Scanner(new File(fileName));
			
			while(ignoreFile.hasNext())
			{
				//while stopwords.txt hasNext() then add to TreeSet and convert to upper case to avoid case sensitivity problems
				/*
				 * Big O
				 * Adding to a Treeset is gauranteed O(log (n))
				 * */
				stopWords.add(ignoreFile.next().toUpperCase());
			}
			
			//close ignoreFile
			ignoreFile.close();
			
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getSize()
	{
		//returns the size of the stopWords set
		return stopWords.size();
	}
	
	public Set<String> getStopWords()
	{
		//returns a set of the stopWords
		return stopWords;
	}
	
	@Override
	public String toString()
	{	
		return "StopWords contains " + stopWords.size() + " words.";
	}
			
	public boolean contains(String word)
	{
		return stopWords.contains(word.toUpperCase());
	}
} //end class
