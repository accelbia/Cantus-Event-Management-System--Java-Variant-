package emsystem;


public class Administrator extends User
{
	//Data Members
	public String Admin_ID;
	
	protected String Position;
	


	//Constructor
	Administrator(String id, String pos, String UID, String Fname, String Lname, long mob, String pass)
	{
		super(UID, Fname, Lname, mob, pass);
		Admin_ID=id;
		Position=pos;
	}


	//Member Methods
	protected void Maintain_Details() throws InterruptedException
	{
		int ch=1;
        while(ch!=0)
        {
			Index.cls();
			Index.header();
			if (!(ch>=1&&ch<=7)) 
			{
				System.out.println("The choice entered is invalid!!\n\n");
			}
			System.out.println("Welcome Administrator "+super.First_Name+"! What do you wanna do today?");
			System.out.println("1) Create Event");
			System.out.println("2) Edit Event");
			System.out.println("3) Remove Event");
			System.out.println("4) Reschedule Event");
			System.out.println("5) Edit Venue Details");
			System.out.println("6) Edit Supplier Details");
			System.out.println("\n0) Exit and Log Out");
			System.out.print("\n\nInput\t:");
			ch=Index.in.nextInt();
			int uid=0;
			int oid=0;
			if(ch!=0)
			{
				System.out.print("Enter Host User ID\t:");
				uid = Index.in.nextInt();
				if (uid > 9) 
				{
					ch = -1;
				}
				else 
				{
					if (Index.h[uid] == null)
						ch = -1;
				}
			}
			switch (ch)
			{
				case -1:
					System.out.println("\nThe Host with the Host ID "+uid+" is not present");
					Thread.sleep(2500);
				break;

				case 0:
					Index.cls();
					Index.header();
					System.out.println("\nThank you for using our system! Logging Out. ");
					Thread.sleep(3000);
					Index.cls();
				break;

				case 1:
					Index.h[uid].Schedule_Event();
				break;

				case 2:
					System.out.print("Enter Order ID \t:");
					oid = Index.in.nextInt();
					if(Index.h[uid].o[oid]==null)
					{
						System.out.println("The Order ID you entered is invaid! Please try again!");
						Thread.sleep(1500);
					}
					else
						Index.h[uid].o[oid].e.Update_Details();
				break;

				case 3:
					Index.h[uid].Cancel_Event();
					System.out.println("\nThe order has been removed successfully!");
					Thread.sleep(3000);
				break;

				case 4:
					Index.h[uid].Reschedule_Event();
					System.out.println("\nThe order has been re-scheduled successfully!");
					Thread.sleep(3000);
				break;

				case 5:
					System.out.print("Enter Order ID\t:");
					oid = Index.in.nextInt();
					if (Index.h[uid].o[oid] == null) {
						System.out.println("The Order ID you entered is invaid!");
						Thread.sleep(1500);
					} 
					else
					{
						Index.h[uid].o[oid].v.Update_Details();
						System.out.println("\nThe Venue has been updated successfully!");
						Thread.sleep(3000);
					}
				break;

				case 6:
					System.out.print("Enter Order ID\t:");
					oid = Index.in.nextInt();
					int ind=0;
					System.out.println();
					for(int i=0;i<Index.h[uid].o[oid].s.length;i++)
					{
						System.out.println();
					}
					if (Index.h[uid].o[oid] == null) 
					{
						System.out.println("The Order ID you entered is invaid!");
						Thread.sleep(1500);
					} 
					else
					{
						for(int i=0;i<Index.h[uid].o[oid].s.length;i++)
						{
							System.out.println(Index.h[uid].o[oid].s[i].Supplier_ID+"\t"+Index.h[uid].o[oid].s[i].Supplier_name + "\t" + Index.h[uid].o[oid].s[i].Supplier_type);
						}
						System.out.println("\n\nEnter the Supplier Idex from the above list\t:");
						ind=Index.in.nextInt();
						if (Index.h[uid].o[oid].s[ind-1] == null) 
						{
							System.out.println("The Supplier index you entered is invaid!");
							Thread.sleep(1500);
						} 
						else
						{
							Index.h[uid].o[oid].s[ind-1].Update_Details();
							System.out.println("\nThe Supplier has been updated successfully!");
							Thread.sleep(3000);
						}
					}
				break;				

				default:
					Index.cls();
					Index.header();
					System.out.print("Input Error!\n\n");
					Thread.sleep(1500);
			}
		}
	}
}