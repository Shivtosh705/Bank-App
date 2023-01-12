import java.util.Objects;
import java.util.UUID;

public class SBIuser implements BankInterface {
    //attributes

    private String name;
    private String accountNo;
    private double balance;
    private String password;
    private double rateOfInterest;


    public SBIuser(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;

        this.rateOfInterest=6.5;
        this.accountNo=String.valueOf(UUID.randomUUID());
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int amount) {
       balance=balance+amount;
       return "Your new balance is: "+balance;
    }

    @Override
    public String withdrawMoney(int amount, String enteredpassword) {
        if(Objects.equals(enteredpassword,password)){
           if(amount>balance){
               return "Sorry bro! insufficient money";
           }
           else
           {
               balance=balance-amount;
               return "paisa hi paisa";
           }
        }
        else{
            return "Wrong password";
        }
    }

    @Override
    public double calculateInterest(int years) {
        return (balance*years*rateOfInterest)/100;
    }
}
