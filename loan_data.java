import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class loan_data {

    public static void main(String[] args) {
        LinkedList<Customer> custlist = getCustomerDetails("C:\\Users\\User\\Desktop\\loan_final313.csv");
        for (Customer cust : custlist) {
            System.out.println(cust);
        }

        Scanner user = new Scanner(System.in);
        int id = user.nextInt();
        Customer customer = getCustomerById(id, custlist);
    }

    private static LinkedList<Customer> getCustomerDetails(String file) {
        LinkedList<Customer> custlist = new LinkedList<>();
        Path pathtofile = Paths.get(file);
        try (BufferedReader br = Files.newBufferedReader(pathtofile)) {
            String row = br.readLine();
            while (row != null) {
                String[] attributes = row.split(",");
                Customer cust = getOneCustomer(attributes);
                custlist.add(cust);
                row = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return custlist;
    }


    private static Customer getOneCustomer(String[] attributes) {

        int ID = Integer.parseInt(attributes[0]);
        double income = Double.parseDouble(attributes[1]);
        double loan_amount = Double.parseDouble(attributes[2]);
        String loan_condition = attributes[3];
        double interest_rate = Double.parseDouble(attributes[4]);
        double total_payment = Double.parseDouble(attributes[5]);
        Customer cust = new Customer(ID, income, loan_amount, loan_condition, interest_rate, total_payment);
        return cust;
    }

    public static Customer getCustomerById(int id, LinkedList<Customer> customers) {
        Customer cust = new Customer();
        for(Customer customer : customers) {
            if(customer.getID() == id) {
                cust =  customer;
            }
        }
        return cust;
    }

    public static List<MyDoubleClass> getInterestRatesofAllCustomers(LinkedList<Customer> customers) {
        List<MyDoubleClass> interestRatesofAllCusts = new ArrayList<>();
        for(Customer customer : customers) {
            double intRate = customer.getInterest_rate();
            MyDoubleClass doubleRate = new MyDoubleClass(intRate);
            interestRatesofAllCusts.add(doubleRate);
        }
        return interestRatesofAllCusts;
    }

    public static double averageInterestRate(List<MyDoubleClass> interestRateList) {
        double averageIntRate;
        double sum = 0;
        for(MyDoubleClass intRate : interestRateList) {
            sum += intRate.getMyInt();
        }
        averageIntRate = sum / interestRateList.size();
        return averageIntRate;
    }

    void showMenu(){

        char option='\0';
        Scanner input=new Scanner(System.in);

        System.out.println("welcome");
        System.out.println("Your ID is:"+getOneCustomer().ID);
        System.out.println("\n");
        System.out.println("A. Check Debt Amount");
        System.out.println("B. Interest Rate info");
        System.out.println("C. Check Loan Condition");
        System.out.println("D. Exit");


        do {
            System.out.println("===========================================================================");
            System.out.println("Enter an option: ");
            System.out.println("===========================================================================");
            option=input.next().charAt(0);
            System.out.println("\n");

            switch(option){

                case 'A':
                    System.out.println("------------------------------------------");
                    System.out.println("income= "+getOneCustomer().getTotal_payment());
                    System.out.println("------------------------------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("------------------------------------------");
                    System.out.println("Your loan's interest rate is equal to: "+getOneCustomer().getInterest_rate());
                    System.out.println("------------------------------------------");
                    System.out.println("Average interest rate of loan is equal to: "+getInterestRatesofAllCustomers().averageIntRate);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("------------------------------------------");
                    System.out.println("Loan Condition: "+getOneCustomer().getLoan_condition());
                    System.out.println("------------------------------------------");
                    System.out.println("\n");
                    break;


                case 'D':
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

