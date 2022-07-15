
import java.util.*;//language package
class Bank
{//class begins
    static String name,type_acc;//global variables
    static int acc_no,ch;
    static double dept,int_bal,cur_bal,new_bal;
    static double with_amt;
    static char ch2;
    static boolean error=false;
    public static void main()
    {
        System.out.println("Welcome to SCHOOL BANK");
        Scanner sc=new Scanner(System.in);//Scanner class
        System.out.println("Enter Depositer name:");
            String name1=sc.nextLine();//accepting details
        System.out.println("Enter Account number:");
            int acc_no1=sc.nextInt();
        System.out.println("Enter Account type:");
          System.out.println("SB for Savings Bank");//listing account types
        System.out.println("FD for Fixed Deposit");
          System.out.println("RD for Regular Deposit");
        System.out.println("FD and RD are not available");
            String type_acc1=sc.next();
         if(type_acc1.equals("FD")||type_acc1.equals("RD"))//checking account type
         {
           System.out.println("Account unavailable");
           System.exit(0);
         }
        System.out.println("Enter Initial balance:");
            double int_bal1=sc.nextDouble();
        Bank obj=new Bank( name1, acc_no1, type_acc1, int_bal1);//sending values to constructor
        do
        {
         System.out.println("Press 1 to deposit amount");
          System.out.println("Press 2 to withdraw amount");
         System.out.println("Press 3 to check current balance");
          System.out.println("Press 4 to exit transaction");
         System.out.println("Enter your choice");
          ch=sc.nextInt();//accepting choice
         switch(ch)//switch statement
         {
            case 1:obj.amt_dept();//function call through object 
                   break;
            case 2:obj.amt_with();
            case 3:obj.cur2_balance();
                   break;//break statement
            case 4:System.exit(0);//exit statement
                   break;
            default:System.out.println("Wrong choice!");
         }
         obj.display();
         System.out.println("\nTo continue, press Y");
         System.out.println("To end press, N");
         ch2 =sc.next().charAt(0);
        }while(ch2!='N');
    }
    public Bank(String name1,int acc_no1,String type_acc1,double int_bal1)//constructor method
    {
        name=name1;//assigning values
        acc_no=acc_no1;
        type_acc=type_acc1;
        int_bal=int_bal1; 
    }
    void amt_dept()//function to deposit amount
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter amount to deposit");
        dept=sc.nextDouble();
    }
    void amt_with()//function to withdraw amount
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Current balance: "+(dept+int_bal ));
        System.out.println("Enter amount to withdraw");
        with_amt=sc.nextDouble();  
        if(with_amt>(dept+int_bal))
        {
            System.out.println("ERROR!");
            error=true;
        }
    }
    void cur2_balance()//function to check current balance
    {
        new_bal=(int_bal+dept)-with_amt;
    }
    void display()
    {
        System.out.println("Depositer name: "+name);
        System.out.println("Account number: "+acc_no);
        System.out.println("Type of account: "+type_acc);
        if(ch!=3)
        System.out.println("Initial balance: "+int_bal);
        switch(ch)
        {
            case 1:System.out.println("Amount deposited: "+dept);
                   System.out.println("New balance: "+(dept+int_bal ));
                   break;
            case 2:if(error!=true)//checking condition
                    {
                     System.out.println("Amount withdrawn: "+with_amt);
                     System.out.println("New Balance: "+new_bal);
                    }
                    else
                    System.out.println("ERROR!");
                     break;
            case 3:System.out.println("Current balance: "+new_bal);
                   break;
            default:System.out.println("ERROR!");
        }      
    }
}//class closed
