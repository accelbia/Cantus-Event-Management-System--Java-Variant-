package System;

public class Venue 
{
	//Data Members
	public String Venue_ID;
	public String Venue_type;

	protected int Capacity;
	protected float Price_per_hour;
	protected String Address;
	protected String Email_ID;

	// Constructor
	Venue(String Venue_ID, String Venue_type, int Capacity, float Price_per_hour, String Address, String Email_ID) 
	{
		this.Venue_ID = Venue_ID;
		this.Venue_type = Venue_type;
		this.Capacity = Capacity;
		this.Price_per_hour = Price_per_hour;
		this.Address = Address;
		this.Email_ID = Email_ID;
	}

	// Member Methods

	private void Show_Details() {

		System.out.println("\n\nVenue ID\t:" + Venue_ID);
		System.out.println("Venue Type\t:"+Venue_type);
		System.out.println("Capacity\t:"+Capacity);
		System.out.println("Price_per_hour\t:"+Price_per_hour);
		System.out.println("Address\t:"+Address);
		System.out.println("Email_ID\t:"+Email_ID);
	}

	protected void Update_Details() throws InterruptedException
	{
		Index.cls();
		Index.header();
		System.out.print("What do you wanna update?\n\t1)Capacity\n\t2)Price Per Hour\n\t3)Email ID\nInput\t\t:");
		int ch=Index.in.nextInt();
		switch (ch)
		{
			case 1:
				System.out.print("Enter new capacity\t:");
				Capacity=Index.in.nextInt();
				Show_Details();
			break;

			case 2:
				System.out.print("Enter the new Price Per Hour\t:");
				Price_per_hour = Index.in.nextInt();
				Show_Details();
			break;

			case 3:
				System.out.print("Enter the new Email ID\t:");
				Email_ID = Index.in.nextLine();
				Show_Details();
			break;

			default:
				System.out.println("INPUT ERROR!!");
				Thread.sleep(4000);
				Index.cls();
		}
	}
}

