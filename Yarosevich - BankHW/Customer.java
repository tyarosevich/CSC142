package BankHW;

import java.util.Random;

import static com.sun.xml.internal.ws.util.StringUtils.capitalize;


// The customer class. It's a class. Of customers.
public class Customer {

    private String fullName;
    private Account customerAccount;
    private boolean accountOpen;


    public Customer() {

    }
    //The principle constructor. Sets the customer name
    // and also creates and sets an instance of the Account
    // class.
    public  Customer(String first, String last) {
        this.fullName = (first + " " + last);
        openAccount();
    }
    // A method to open an account for an already
    // existing customer instance.
    public void openAccount(){
        this.customerAccount = new Account();

    }

    // A method to close a customer instance's account
    // without removing the customer instance.
    public void closeAccount(){
        this.customerAccount = null;
    }
    // A method to set a customer's name. Not used,
    // but figured it should be there.
    public void setName(String first, String last){
        this.fullName = (first + " " + last);
    }
    // A get method for the fullName field.
    public String getName() {
        return fullName;

    }
    // Returns the Customer instance's account instance
    // field. Note that the program does assume this can
    // return null.
    public Account getAccount(){
        return this.customerAccount;
    }
}
