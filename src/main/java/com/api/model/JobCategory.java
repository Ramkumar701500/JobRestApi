package com.api.model;
					
public class JobCategory
{
	
	private int id;
	
	private String category;
	
	private String description;

	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getCategory() 
	{
		return category;
	}

	public void setCategory(String category) 
	{
		this.category = category;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	@Override
	public String toString() 
	{
		return "JobCategory [Id=" + id + ", category=" + category + ", description=" + description + "]";
	}
	
}