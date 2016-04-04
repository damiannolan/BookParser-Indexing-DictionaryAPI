package gmit;

import java.util.*;

public class WordDetail 
{
	private List<String> definition = new ArrayList<String>();
	private List<Integer> pages = new ArrayList<Integer>();
	
	//constructor
	public WordDetail()
	{
		//Creates empty lists
		this.definition = new ArrayList<String>();
		this.pages = new ArrayList<Integer>();
	}
	
	public WordDetail(int page)
	{
		addIndex(page);
	}
	
	//Getters and Setters
	public List<String> getDefinition()
	{
		return definition;
	}

	public void setDefinition(List<String> definition) 
	{
		this.definition = definition;
	}
	
	//to return the array list of pages
	public List<Integer> getPages()
	{
		return pages;
	}

	public void setPages(List<Integer> pages) 
	{
		this.pages = pages;
	}
	
	//addIndex to array list
	public void addIndex(int page)
	{
		this.pages.add(page);
	}
	
	@Override
	public String toString()
	{
		return "Definition: \n" + getDefinition() + "\n\n" + "Pages: \n" + getPages(); 
	}
	
} //end class
