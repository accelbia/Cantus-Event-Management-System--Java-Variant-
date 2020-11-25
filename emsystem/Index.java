package EMSystem;
import java.util.*;

public class Index 
{
    
    static final Scanner in = new Scanner(System.in);
    
    //Screen cleaner
    public static void cls()
    {
        System.out.print("\u001b[2J\u001b[H");        
        System.out.flush();
    }

    //Header
    public static void header()
    {
        System.out.println("===========================================================================================");
        System.out.println("=======================  Welcome to Cantus Event Management System  =======================");
        System.out.println("===========================================================================================\n\n");
    }

    static Host h[] = new Host[10];
    
    public static void main(String[] args) throws Exception
    {
        


        //Admin Registration
        Administrator admin[]=new Administrator[4];

        admin[0] = new Administrator("X00", "Developer", "X00", "Ayush", "Barik", 12345, "Leviathan#01");
        admin[1] = new Administrator("X01", "Leader", "X01", "Shreya", "Nandigam", 67890, "Artemis#02");
        admin[2] = new Administrator("X02", "Designer", "X02", "Sai", "Prasad", 12121, "Chronos#03");
        admin[3] = new Administrator("X03", "Testing and Documentation", "X03", "Meka", "Dasharna", 98765, "Crysynthia#01");

        String un;
        String pw;
        int flag=0;
        int uid=0;


        //Clearing Screen
        cls();

        int ch=1;
        while(ch!=0)
        {
            cls();
            header();
            if (ch != 1 && ch != 2 && ch != 3) 
            {
                System.out.println("The choice entered is invalid!!\n\n");
            }
            System.out.print("What do you wanna do today?\n\n\t1)Host Login\n\t2)Administrator Login\n\t3)Register as Host\n\n\t0)Exit System\n\nInput\t:");
            ch=in.nextInt();

            switch (ch)
            {
                case 0:
                    cls();
                    header();
                    System.out.println("\nThank you for using our system! Have a great day ahead! ;) ");
                    Thread.sleep(3000);
                    cls();
                break;

                case 1:
                    cls();
                    header();


                    //Host Login
                    System.out.println("LOGIN SECTION\n");
                    System.out.print("Enter your User ID\t:");
                    String id = in.next();
                    System.out.print("Enter your password\t:");
                    pw = in.next();

                    for(int i=0;i<10;i++)
                    {
                        if(h[i]==null)
                        {
                            continue;
                        }
                        if ((h[i].User_ID.equals(id))&&(h[i].Password.equals(pw)))
                        {
                            flag=1;
                            h[i].Maintain_Details();
                            break;
                        }
                    }
                    if (flag == 0) 
                    {
                        System.out.println("No User with this credential combination is present....");
                        Thread.sleep(2500);
                    }

                break;

                case 2:
                    cls();
                    header();

                    // Administrator Login
                    System.out.println("ADMIN LOGIN SECTION\n");
                    System.out.print("Enter Admin ID\t:");
                    un = in.next();
                    System.out.print("Enter Password\t:");
                    pw = in.next();

                    for(int i=0;i<4;i++)
                    {
                        if(un.equals(admin[i].Admin_ID)&&pw.equals(admin[i].Password))
                        {
                            flag=1;
                            admin[i].Maintain_Details();
                        }
                    }
                    if(flag==0)
                    {
                        System.out.println("No Administrator with this credential combination is present....");
                        Thread.sleep(2500);
                    }

                    break;

                case 3:
                    cls();
                    header();
                    
                    String UID;
                    String Fname;
                    String Lname;
                    long mob;
                    String pass="";
                    String DOB;
                    String Email_ID;
                    int Bank_acc_no; 
                    String Address;

                    System.out.println("HOST REGISTRATION\n");
                    System.out.print("Enter your First Name\t\t\t:");
                    Fname = in.next();
                    System.out.print("Enter your Last Name\t\t\t:");
                    Lname = in.next();
                    System.out.print("Enter your Mobile Number\t\t:");
                    mob = in.nextLong();
                    System.out.print("Enter your Date of Birth (DD/MM/YYYY)\t:");
                    DOB = in.next();
                    System.out.print("Enter your Email ID\t\t\t:");
                    Email_ID = in.next();
                    System.out.print("Enter your Bank Account Number\t\t:");
                    Bank_acc_no = in.nextInt();
                    System.out.print("Enter your Address\t\t\t:");
                    Address = in.next();
                    System.out.print("Enter the password. The password should be at least 8 characters long, should have a number, contain both upper and lower case alphabets and a special symbol : ");
                    pass = in.next();
                        while (!Verify(pass)) 
                    {
                        System.out.println("Password is weak. Try another one!!\n");
                        System.out.print("Enter the password. The password should be at least 8 characters long, should have a number, contain both upper and lower case alphabets and a special symbol : ");
                        pass = in.next();
                    }
                    UID="H"+Integer.toString(uid);
                    uid++;

                    h[uid]=new Host(UID, Fname, Lname, mob, pass, DOB, Email_ID, Bank_acc_no, Address);
                    cls();
                    header();
                    System.out.println("User has been registered! Welcome to the Cantus family!\n\nYour User ID is :\t" + UID);
                    Thread.sleep(5000);

                    break;

                default:
                    cls();
                    header();
                    System.out.print("Input Error!\n\n");
                    Thread.sleep(1500);
            }
            flag=0;
        }
        in.close();
    }

    private static boolean Verify(String pw) 
    {
        boolean digit = false;
        boolean length = false;
        boolean symbol = false;
        boolean upper = false;
        boolean lower = false;
        if (pw.length() > 8)
            length = true;
        for (int i = 0; i < pw.length(); i++) {
            if (Character.isDigit(pw.charAt(i)))
                digit = true;
            if (Character.isUpperCase(pw.charAt(i)))
                upper = true;
            if (Character.isLowerCase(pw.charAt(i)))
                lower = true;
            if ((int) (pw.charAt(i)) < 65 || ((int) (pw.charAt(i)) > 90 && (int) (pw.charAt(i)) < 97) || (int) (pw.charAt(i)) > 122)
                symbol = true;
        }
        return (digit && length && symbol && upper && lower);
    }
}
