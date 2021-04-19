package com.api.model;
					
public class JobSeeker 
{
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private String education;

	private String address;

	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	public String getEducation() 
	{
		return education;
	}

	public void setEducation(String education) 
	{
		this.education = education;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	@Override
	public String toString() 
	{
		return "JobSeeker [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", education=" + education + ", address=" + address + "]";
	}
	
}