package EMSystem;

public class Host extends User {
    // Data Members
    public String DOB;
    public String Email_ID;
    public int Bank_acc_no;
    public String Address;

    Host(String UID, String Fname, String Lname, long mob, String pass, String DOB, String Email_ID, int Bank_acc_no, String Address) 
    {
        super(UID, Fname, Lname, mob, pass);
        this.DOB = DOB;
        this.Email_ID = Email_ID;
        this.Bank_acc_no = Bank_acc_no;
        this.Address = Address;
    }

    int oid = 0;
    public int arr[];

    // Objects
    public Order o[];

    public void Schedule_Event() {
        // Local
        int dur, att;
        String type, org, st, et, sd, ed, vid="";

        Index.cls();
        Index.header();

        // Entering User Details

        System.out.print("Enter the event type                  \t:");
        type = Index.in.nextLine();
        System.out.print("Enter the event date  (DD/MM/YYYY)    \t:");
        sd = Index.in.nextLine();
        System.out.print("Enter the event time  (0000)          \t:");
        st = Index.in.nextLine();
        System.out.print("Enter the event end date  (DD/MM/YYYY)\t:");
        ed = Index.in.nextLine();
        System.out.print("Enter the event end time  (0000)      \t:");
        et = Index.in.nextLine();
        System.out.print("Enter the event duration (Hours)      \t:");
        dur = Index.in.nextInt();
        System.out.print("Enter the number of attendees         \t:");
        att = Index.in.nextInt();

        org = super.First_Name + " " + super.Last_Name;

        System.out.print("Enter number of suppliers required\t:");
        int n = Index.in.nextInt();
        String[] sup=new String[n];
        if (n != 0) 
        {
            String sn[] = { "Taj Catering", "Snap Photography", "Crown Boutique and Decor", "OmniPrint Printing and co.", "Amplify Music" };
            String id[] = { "TC", "SP", "CBD", "OPC", "AM" };
            String su[] = { "Catering", "Media", "Decoration", "Printing", "Music and Sounds" };
            float pr[] = { 30000, 20000, 30000, 15000, 35000 };
            String em[] = { "catering@taj.com", "pics@snapmedia.com", "crownboutique@gamil.com", "help@omniprint.com", "events@amplify.com" };
            String pm[] = { "Netbanking", "Cheque", "Cash", "Cash", "Cheque" };

            for (int i = 0; i < 5; i++) 
            {
                System.out.println(i + 1 + ")\t" + id[i] + "\t" + sn[i] + "\t" + su[i] + "/t" + pr[i] + "/t" + em[i] + "/t" + pm[i]);
            }
            System.out.println();
            for(int i=0;i<n;i++)
            {
                int flag=0;
                while(flag==0)
                {
                    System.out.println("Enter supplier ID of your choice ["+(i+1)+"]\t:");
                    sup[i]=Index.in.next();
                    for(int j=0;j<5;j++)
                    {
                        if(sup[i].equals(id[j]))
                            flag=1;
                    }
                    if(flag==0)
                        System.out.println("\nThe supplier ID entered is invalid! Try Again...");
                }
            }
        }
        else 
        {
            sup=null;
        }

        String VID[] = { "VVT", "LG", "TGC" };
        String VT[] = { "Indoor", "Outdoor", "Indoor" };
        int cap[] = { 200, 300, 150 };
        float ppr[] = { 5000, 3000, 4100 };
        String add[] = { "Riverfront", "Aliganj", "Gomti Nagar" };
        String email[] = { "vivanta@taj.com", "gardens@lucknowtours.com", "thegrandcharior@staraliance.com" };

        for (int i = 0; i < 3; i++) 
        {
            System.out.println(i + 1 + ")\t" + VID[i] + "\t" + VT[i] + "/t" + cap[i] + "/t" + ppr[i] + "/t" + add[i] + "/t" + email[i]);
        }
        int flag = 0;
        while (flag == 0) 
        {
            System.out.println("Enter venue ID of your choice\t:");
            vid = Index.in.next();
            for (int j = 0; j < 3; j++) 
            {
                if (vid.equals(VID[j]))
                    flag = 1;
            }
            if (flag == 0)
                System.out.println("\nThe supplier ID entered is invalid! Try Again...");
        }

        o[oid]=new Order(oid, sup, vid, oid, dur, att, type, org, st, et, sd, ed);
        oid++;
    }

    protected void Cancel_Event() throws InterruptedException {
        Index.cls();
        Index.header();
        System.out.print("Enter the Event Code you want to cancel\t:");
        int code = Index.in.nextInt();
        int flag = 0;
        for (int i = 0; i < 100; i++) {
            if (o[i] == null) {
                continue;
            }
            if (o[i].e.Event_ID == code) {
                flag = 1;
                o[i] = null;
            }
        }

        if (flag == 0) {
            System.out.println("\nThe event you mentioned does not exist! Please try again later.");
            Thread.sleep(2500);
        }

    }

    protected void Reschedule_Event() throws InterruptedException {
        Index.cls();
        Index.header();
        int flag = 0;
        System.out.print("Enter the Event Code you want to reschedule\t:");
        int code = Index.in.nextInt();
        for (int i = 0; i < 100; i++) {
            if (o[i] == null) {
                continue;
            }
            if (o[i].e.Event_ID == code) {
                flag = 1;
                System.out.println("Current Event Date\t:" + o[i].e.Start_date);
                System.out.println("Current Event Time\t:" + o[i].e.Start_time);
                System.out.println("Current Event End Date\t:" + o[i].e.End_date);
                System.out.println("Current Event End Time\t:" + o[i].e.End_time);

                System.out.println("\nEnter new Date (DD/YY/MM)\t:");
                o[i].e.Start_date = Index.in.next();
                System.out.println("\nEnter new Time (0000)    \t:");
                o[i].e.Start_time = Index.in.next();
                System.out.println("\nEnter new End Date (DD/YY/MM)\t:");
                o[i].e.End_date = Index.in.next();
                System.out.println("\nEnter new End Time (0000)    \t:");
                o[i].e.End_time = Index.in.next();
            }
        }
        if (flag == 0) {
            System.out.println("\nThe event you mentioned does not exist! Please try again later.");
            Thread.sleep(2500);
        }
    }

    public void Maintain_Details() throws InterruptedException {
        int ch = 1;
        while (ch != 0) {
            Index.cls();
            Index.header();
            if (ch != 1 && ch != 2 && ch != 3) {
                System.out.println("The choice entered is invalid!!\n\n");
            }
            System.out.println("Hello Host " + super.First_Name + "! How can we help you today?");
            System.out.println("\n1)Schedule Event");
            System.out.println("2)Cancel Event");
            System.out.println("3)Reschedule Event");
            System.out.println("0)Exit Menu and Logout");
            System.out.print("\nInput\t:");
            ch = Index.in.nextInt();

            switch (ch) {
                case 0:
                    Index.cls();
                    Index.header();
                    System.out.println("\nThank you for using our system! Logging out of your system now. ");
                    Thread.sleep(3000);
                    Index.cls();
                    break;

                case 1:
                    Schedule_Event();
                    break;
                case 2:
                    Cancel_Event();
                    break;
                case 3:
                    Reschedule_Event();
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
