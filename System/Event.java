package System;

public class Event 
{
	//Data Members

	public int Event_ID;

	protected int Duration;
	protected int No_of_attendees;
	protected String Event_Type;
	protected String Organizer;

	protected String Start_time;
	protected String End_time;
	protected String Start_date;
	protected String End_date;

	//Constructor

	Event()
	{

	}
	
	Event(int eid, int dur, int att, String type, String org, String st, String et, String sd, String ed)
	{
		Event_ID=eid;
		Duration=dur;
		No_of_attendees=att;
		Event_Type=type;
		Organizer=org;

		Start_time=st;
		Start_date=sd;
		End_time=et;
		End_date=ed;
	}

	protected void Update_Details() throws InterruptedException 
	{
		Index.cls();
		Index.header();
		System.out.print("What do you wanna update?\n\t1)Duration\n\t2)Date and Time\n\t3)No. of Attendees  \n\nInput\t\t:");
		int ch = Index.in.nextInt();
		System.out.println();
		switch (ch) {
			case 1:
				System.out.println("Old Duration\t:"+Duration);
				System.out.print("Enter new Duration\t:");
				Duration = Index.in.nextInt();
			break;

			case 2:
				System.out.println("Old Start Date\t:" + Start_date);
				System.out.println("Old Start Time\t:" + Start_time);
				System.out.println("New Start Date\t:"); Start_date=Index.in.nextLine();
				System.out.println("New Start Time\t:"); Start_time=Index.in.nextLine();

				System.out.println();


				System.out.println("Old End Date\t:" + End_date);
				System.out.println("Old End Time\t:" + End_time);
				System.out.println("New End Date\t:"); End_date=Index.in.nextLine();
				System.out.println("New End Time\t:"); End_time=Index.in.nextLine();
			break;

			case 3:
				System.out.print("Old number of Attendees\t:"+No_of_attendees);
				System.out.print("New number of Attendees\t:");No_of_attendees=Index.in.nextInt();
			break;

			default:
				System.out.println("INPUT ERROR!!");
				Thread.sleep(3000);
				Index.cls();
		}
	}

}
