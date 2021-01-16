
public class Customer {
   private int ID;
   private double income;
   private double loan_amount;
   private String loan_condition;
   private double interest_rate;
   private double total_payment;

   public Customer() {

   }

   public Customer(int ID,double income,double loan_amount,String loan_condition,
                   double interest_rate, double total_payment){
       super();
       this.ID=ID;
       this.income=income;
       this.loan_amount=loan_amount;
       this.loan_condition=loan_condition;
       this.interest_rate=interest_rate;
       this.total_payment=total_payment;
   }
   @Override
   public String toString(){
       return "Customer[ID="+ID+",income="+income+",loan_amount="+loan_amount
               +",loan_condition="+loan_condition+",interest_rate="+interest_rate+
               ",total_payment="+total_payment+"]";
   }

   public int getID(){
       return ID;
   }
   public void setID(int ID){
       this.ID=ID;
   }

   public double getIncome(){
       return income;
   }
   public void setIncome(double income){
       this.income=income;
   }

   public double getLoan_amount(){
       return loan_amount;
   }
   public void setLoan_amount(double loan_amount){
       this.loan_amount=loan_amount;
   }

   public String getLoan_condition(){
       return loan_condition;
   }
   public void setLoan_condition(String loan_condition){
       this.loan_condition=loan_condition;
   }

    public double getInterest_rate(){
        return interest_rate;
    }
    public void setInterest_rate(double interest_rate){
        this.interest_rate=interest_rate;
    }

    public double getTotal_payment(){
        return total_payment;
    }
    public void setTotal_payment(double total_payment){
        this.total_payment=total_payment;
    }
}
