package System;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Receipt 
{
	//Data Members
	protected String Receipt_no;
	protected float Final_Amount;
	protected float Amount_Paid;
	protected float Amount_Due;
	protected String Issue_Date;

	protected float Venue_price;
	protected float Total_supplier_price;

	//Constructor
	Receipt()
	{
		Receipt_no="";
		Final_Amount=0;
		Amount_Due=0;
		Amount_Paid=0;
		Issue_Date="01/01/2000";
		Venue_price=0;
		Total_supplier_price=0;
	}

	Receipt(String Receipt_no, float Venue_price, float Total_supplier_price)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();

		this.Receipt_no=Receipt_no;
		this.Venue_price=Venue_price;
		this.Total_supplier_price=Total_supplier_price;
		Final_Amount=Venue_price+Total_supplier_price;

		Issue_Date=dtf.format(now);
	}



}