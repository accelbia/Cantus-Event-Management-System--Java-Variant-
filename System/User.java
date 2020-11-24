package System;

public abstract class User
{
	//Data Members
	public String User_ID;
	
	protected String First_Name;
	protected String Last_Name;
	protected long Mobile_no;
	
	protected String Password;

	//Constructor
	User()
	{
		User_ID="";
		First_Name="";
		Last_Name="";
		Mobile_no=0;
		Password="";
	}

	User(String UID, String Fname, String Lname, long mob, String pass)
	{
		User_ID = UID;
		First_Name = Fname;
		Last_Name = Lname;
		Mobile_no = mob;
		Password = pass;
	}

}

