package emsystem;

public class Order 
{
    public static int Order_ID;

    Event e; //Fulfilled
    Receipt r; //Fulfilled
    Venue v; //Fulfilled
    Supplier[] s; //Fulfilled

    Order(int Order_ID, String[] sup, String ven, int evid, int dur, int att, String type, String org, String st, String et, String sd, String ed)
    {

        float scost=0;
        int vid=0;
        //Venue Designator
        String[] VID={"VVT","LG","TGC"};
		String[] VT={"Indoor","Outdoor","Indoor"};
		int[] cap={200,300,150};
		float[] ppr={5000,3000,4100};
		String[] add={"Riverfront","Aliganj","Gomti Nagar"};
        String[] email={"vivanta@taj.com","gardens@lucknowtours.com","thegrandcharior@staraliance.com"};
        for(int i=0;i<3;i++)
        {
            if(ven.equals(VID[i]))
            {
                v=new Venue(VID[i], VT[i], cap[i], ppr[i], add[i], email[i]);
                vid=i;
            }
        }


        //Supplier Designator
        String[] sn = { "Taj Catering", "Snap Photography", "Crown Boutique and Decor", "OmniPrint Printing and co.",
                "Amplify Music" };
        String[] id = { "TC", "SP", "CBD", "OPC", "AM" };
        String[] su = { "Catering", "Media", "Decoration", "Printing", "Music and Sounds" };
        int[] ban = { 123, 234, 345, 456, 567 };
        long[] mn = { 12345, 23456, 34567, 45678, 56789 };
        float[] pr = { 30000, 20000, 30000, 15000, 35000 };
        String[] em = { "catering@taj.com", "pics@snapmedia.com", "crownboutique@gamil.com", "help@omniprint.com",
                "events@amplify.com" };
        String[] pm = { "Netbanking", "Cheque", "Cash", "Cash", "Cheque" };

        for(int i=0;i<sup.length;i++)
        {
            for(int j=0;j<id.length;j++)
            {
                if(sup[i].equals(id[j]))
                {
                    s[i]=new Supplier(sn[j], id[j], su[j], ban[j], mn[j], pr[j], em[j], pm[j]);
                    scost+=pr[j];
                    break;
                }
            }
        }

        e=new Event(evid, dur, att, type, org, st, et, sd, ed);

        r=new Receipt(evid+VID[vid]+Integer.toString(Order_ID), ppr[vid]*dur, scost);
    }
}
