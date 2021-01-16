import java.sql.SQLOutput;
import java.util.Scanner;

public class Banking_Application {

    public static void main(String[] args){

    Loan_account obj1= new Loan_account("bzzii", 213456);
        obj1.showMenu();

    }
}


class Loan_account{
    int balance;
    int previousTransaction;
    String CustomerName;
    int CustomerID;

    Loan_account(String cname, int cid){
        CustomerName=cname;
        CustomerID=cid;
    }

    void loan(int amount){

        if(amount!=0){
            balance=balance+amount;
            previousTransaction=amount;
        }

    }

    void withdraw(int amount){

        if(amount!=0){
            balance=balance-amount;
            previousTransaction=-amount;
        }

    }

    void getPreviousTransaction(){

        if(previousTransaction>0){
            System.out.println("Deposited: "+previousTransaction);
        }
        else if(previousTransaction<0){
            System.out.println("Deposited: "+Math.abs(previousTransaction));
        }
        else{
            System.out.println("No transaction accured");
        }

    }

    void showMenu(){

        char option='\0';
        Scanner input=new Scanner(System.in);

        System.out.println("welcome"+CustomerName);
        System.out.println("Your ID is:"+CustomerID);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("===========================================================================");
            System.out.println("Enter an option: ");
            System.out.println("===========================================================================");
            option=input.next().charAt(0);
            System.out.println("\n");

            switch(option){

                case 'A':
                    System.out.println("------------------------------------------");
                    System.out.println("Balance= "+balance);
                    System.out.println("------------------------------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("------------------------------------------");
                    System.out.println("Enter an amount to deposit: ");
                    System.out.println("------------------------------------------");
                    int amount=input.nextInt();
                    loan(amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("------------------------------------------");
                    System.out.println("Enter an amount to withdraw: ");
                    System.out.println("------------------------------------------");
                    int amount2=input.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("------------------------------------------");
                    getPreviousTransaction();
                    System.out.println("------------------------------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("*******************************************");
                    break;

                default:
                    System.out.println("Invalid option!.Please enter again.");
                    break;
            }
        }

        while(option!='E');
            System.out.println("Thank you for using our services");





    }


}