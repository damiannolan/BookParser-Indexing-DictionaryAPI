package gmit;

import java.util.*;
import java.io.*;

public class BookIndexer 
{
	Dictionary dictionary = new Dictionary("dictionary.csv");
	StopWords ignoreWords = new StopWords("stopwords.txt");
	
	Map<String, WordDetail> index = new HashMap<String, WordDetail>();
	
	//Default
	public BookIndexer()
	{
		//creates empty map
		this.index = new HashMap<String, WordDetail>();
	}
	
	public BookIndexer(String fileName) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		
		//Page number starts at 1
		int page = 1;
		int lineCounter = 0;
		String line = null;
		
		while((line = reader.readLine()) != null)
		{	
			//Increment lineCounter
			lineCounter++;
			
			//Every 40 Lines is = 1 page
			if(lineCounter % 40 == 0)
			{
				page++;
			}
			
			String[] words = line.split(" ");
			
			// Loop through the array of words in the line
			for(int i = 0; i < words.length; i++)
			{
				
				/*
				 * Big O
				 * Using the contains method on ignoreWords Treeset is guaranteed O(log (n))
				 * */
				if(ignoreWords.contains(words[i]))
				{
					//If the word is in stopwords.txt then skip
					continue;
				}
				
				/*
				 * Big O
				 * Using containsKey method on index - HashMap is done in - O(n)
				 * Accessing the value for a specified key using .get() is done in Constant Time - O(1) 
				 * Adding to an ArrayList is done in Constant Time - O(1)
				 * */
				if(index.containsKey(words[i].toUpperCase()))
				{
					//If the word is already in the map then add the page number
					WordDetail wd = index.get(words[i].toUpperCase());
					wd.addIndex(page);
				}
				else
				{
					//Otherwise new WordDetail() object
					//Add page number
					WordDetail wd = new WordDetail();
					wd.addIndex(page); // O(1)
					
					//Get definition
					List<String> definition = dictionary.getDefinition(words[i]);
					wd.setDefinition(definition);
					
					//Put into map
					index.put(words[i].toUpperCase(), wd); // O(1)
				}
				
			} //end for
		} //end while
		
		//close file
		reader.close();
	}
	
	public String searchWord(String word)
	{
		//Assign the word to the wd object and return wd.toString()
		WordDetail wd = index.get(word.toUpperCase());
				
		if(wd == null)
		{
			return "Could not find word specified";
		}
		else
		{
			return wd.toString();
		}
	}
	
	public Set<String> getWords()
	{
		//returns a set of all existing keys in the index map
		return index.keySet();
	}
} //end class
