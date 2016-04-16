package gmit;

import java.util.*;
import java.io.*;

public class Dictionary 
{
	//A HashMap to map words to a list of definitions
	Map<String, List<String>> dictionary = new HashMap<>();
	
	//Default
	public Dictionary()
	{
		//Create empty dictionary HashMap
		this.dictionary = new HashMap<String, List<String>>();
	}
	
	public Dictionary (String fileName)
	{
		//Provide the path to dictionary.csv and add to HashMap
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			
			//Use StringBuilder so that it can be appended with multiple lines
			StringBuilder definition = new StringBuilder();
			
			//Ignore first line (format line) in dictionary.csv
			reader.readLine();
			
			String nextLine = reader.readLine();
			
			//while the nextLine is not null - parse dictionary.csv and update map
			while(nextLine != null)
			{
				if(nextLine.charAt(0) == '"')
				{
					//Get the word which will be used as a key in the dictionary map
					//This is a substring of nextLine starting at index 1 (after the first quotation mark)
					//And ending at the second occurrence of a quotation mark
					String word = nextLine.substring(1, nextLine.indexOf('"', 1));
					
					do
					{
						//Append definition while the nextLine is not null and the first character is not '"'
						definition.append(nextLine + "\n");
						
						//Update nextLine
						nextLine = reader.readLine();
					} while(nextLine != null && nextLine.charAt(0) != '"');
					
					//do-while breaks when it sees '"' at the start of a new line, implying you have encountered a new word
					//Therefore, Add the current word to dictionary map
					//Convert the word to upper case to avoid case sensitivity problems
					addToDictionary(word.toUpperCase(), definition.toString());
										
					//Wipe String for next word
					definition = new StringBuilder();
				}
			}
			//close dictionary file
			reader.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void addToDictionary(String newWord, String definition)
	{
		//if dictionary does not contain the word, then create new arraylist for definitions, add the definitions and put in map
		if(dictionary.get(newWord) == null)
		{
			List<String> definitionList = new ArrayList<>();
			definitionList.add(definition);
			
			/*
			 * Big O
			 * Put into dictionary HashMap - Constant Time - O(1)
			 */
			dictionary.put(newWord, definitionList);
		}
		else
		{
			//otherwise, the word exists in the map, therefore update the definitions
			
			/*
			 * Big O
			 * Updating the definition list and acccessing it are both done in Constant Time - O(1)
			 */
			dictionary.get(newWord).add(definition);	//cascaded method call
		}
		
	}
	
	public List<String> getDefinition(String word)
	{
		//returns the word definition
		return dictionary.get(word.toUpperCase());
	}
	
	public int getSize()
	{
		//returns the dictionary map size
		return dictionary.size();
	}
	
	public Set<String> getWords()
	{
		//returns a set of all existing keys in the dictionary map
		return dictionary.keySet();
	}
	
	
} //end class
