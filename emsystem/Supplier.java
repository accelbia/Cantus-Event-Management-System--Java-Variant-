package emsystem;

public class Supplier 
{
	//Data Members
	public String Supplier_name;
	public String Supplier_ID;
	public String Supplier_type;

	protected int Bank_acc_no;
	protected long Mobile_no;
	protected float Price;
	protected String Email_ID;
	protected String Payment_Mode;



	public Supplier(String Supplier_name, String Supplier_ID, String Supplier_type, int Bank_acc_no, long Mobile_no, float Price, String Email_ID, String Payment_Mode)
	{
		this.Supplier_name=Supplier_name;
		this.Supplier_ID=Supplier_ID;
		this.Supplier_type=Supplier_type;
		this.Mobile_no= Mobile_no;
		this.Bank_acc_no= Bank_acc_no;
		this.Price= Price;
		this.Email_ID=Email_ID;
		this.Payment_Mode=Payment_Mode;
	}

	private void Show_Details()
	{
		System.out.println("Supplier Name\t:" + Supplier_name);
		System.out.println("Supplier ID\t:" + Supplier_ID);
		System.out.println("Supplier Type\t:" + Supplier_type);
		System.out.println("\nMobile No.\t:" + Mobile_no);
		System.out.println("Bank Account no.\t:" + Bank_acc_no);
		System.out.println("Price\t:" + Price);
		System.out.println("Email ID\t:" + Email_ID);
		System.out.println("Payment Mode\t:" + Payment_Mode);

	}

	protected void Update_Details() throws InterruptedException
	{
		Index.cls();
		Index.header();
		System.out.print("What do you wanna update?\n\t1)Mobile number\n\t2)Bank Account Number\n\t3)Price\n\t4)Email ID\n\t5)Payment Mode  \nInput\t\t:");
		int ch = Index.in.nextInt();
		switch (ch) {
			case 1:
				System.out.print("Enter new Mobile Number\t:");
				Mobile_no = Index.in.nextLong();
				Show_Details();
				break;

			case 2:
				System.out.print("Enter the new Bank Account Number\t:");
				Bank_acc_no = Index.in.nextInt();
				Show_Details();
				break;

			case 3:
				System.out.print("Enter the new Price\t:");
				Price = Index.in.nextInt();
				Show_Details();
				break;

			case 4:
				System.out.print("Enter the new Email ID\t:");
				Email_ID = Index.in.nextLine();
				Show_Details();
				break;

			case 5:
				System.out.print("Enter the new Payment Mode\t:");
				Payment_Mode = Index.in.nextLine();
				Show_Details();
				break;

			default:
				System.out.println("INPUT ERROR!!");
				Thread.sleep(4000);
				Index.cls();
		}
	}

}
