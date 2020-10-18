package BankHW;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Created by zennsunni on 2/22/2017.
 */
public class Bank {

    // A make believe routing number.
    private static final int ROUTING_NUMBER = 0210001212;
    private static List<Customer> customerList = new ArrayList<Customer>();

    // A method to conduct transactions.
    public static void transaction(Customer transactionCustomer) {
        boolean transactionStatus = true;
        int userChoice;
        Account tempAccount = transactionCustomer.getAccount();
        Scanner scanner = new Scanner(System.in);

        // A while loop to conduct transactions.
        while (transactionStatus) {

            // Checks to make sure there is an established temporary account. If not,
            // offers to create one.
            if (tempAccount == null) {
                System.out.print("You do not have an account open with us. Choose one of the following: \n1.) Create an account.\n2.) Exit.");
                if (scanner.nextInt() == 1) {
                    transactionCustomer.openAccount();
                } else {
                    return;
                }
            }

            // Solicits the transaction type.
            System.out.println("Please choose from the following:\n1.) Close Account.\n2.) Make a deposit.\n3.) Make a withdrawal.\n4.) Check balance.\n5.) Print account information.\n6.) Main menu.");
            userChoice = scanner.nextInt();

            // Switch statement based on user choice.
            switch (userChoice) {
                case 1: {
                    // Closes the user's account.
                    System.out.println("Are you sure you want to close your account?\n1.) Yes.\n2.) No.");
                    userChoice = scanner.nextInt();
                    if (userChoice == 1) {
                        transactionCustomer.closeAccount();
                        System.out.println("The account belonging to " + transactionCustomer.getName() + " has been closed.");
                    }
                    break;
                }
                // Makes a deposit to the current customer's account.
                case 2: {
                    System.out.println("Please input the amount you would like to deposit: ");
                    tempAccount.depositFunds(scanner.nextDouble());
                    break;
                }
                case 3: {
                    System.out.println("Please input the amount you would like to withdraw: ");
                    tempAccount.withdrawFunds(scanner.nextDouble());
                    break;
                }
                // Displays the customer's balance.
                case 4: {
                    transactionCustomer.getAccount().getBalance();
                    break;
                }
                // Prints out the account holder's name, account number, and balance.
                case 5: {
                    System.out.println("The name on the currently accessed account is " + transactionCustomer.getName() + ".");
                    tempAccount.printAccountInfo();
                    break;
                }
                case 6: {
                    transactionStatus = false;
                    break;
                }
                default:
                    break;
            }
            // Offers to let the customer continue or return to the main menu.
            System.out.println("Would you like to make another transaction, or return to the main menu?\n1.) Another transaction.\n2.) Main Menu.");
            userChoice = scanner.nextInt();
            if (userChoice == 2) {
                transactionStatus = false;
            }
        }
    }

    // A method to create customer instances.
    public static Customer createCustomer() {
        Scanner scanner = new Scanner(System.in);
        String firstName, lastName;
        Customer tempCustomer;

        // Collects first and last name, creates the customer instnace
        // using them, and adds this customer instance to the Bank class'
        // customer array list.
        System.out.println("Time to join Hello World Bank! Please input your first name: ");
        firstName = scanner.next();
        System.out.println("Please input your last name: ");
        lastName = scanner.next();
        tempCustomer = new Customer(firstName, lastName);
        customerList.add(tempCustomer);
        return tempCustomer;
    }

    // Searches the customer array lst based on first and last name.
    // by iterating through the customer list looking for a match.
    // Note, returns null if the custmer is not found.
    public static Customer findCustomer(String first, String last) {
        for (Customer listItem : customerList) {
            if (listItem.getName().equals((first + " " + last))) {
                return listItem;
            }
        }
        return null;
    }

    // Searches for a customer in the same way, but based on
    // account number.
    public static Customer findCustomer(int account) {
        for (Customer listItem : customerList) {
            if (listItem.getAccount().getAccountNumber() == account) {
                return listItem;
            }

        }
        return null;
    }

    public static void main(String[] args) {
        int userChoice;
        Scanner scanner = new Scanner(System.in);
        boolean customerStatus = true;
        Customer currentCustomer;

        // Main method while loop. Checks to see if user is a customer, and if not
        // lets them call the appropriate methods to create a customer instance.
        while (customerStatus) {
            System.out.println("Welcome to Hello World Bank. Are you already a customer? \n 1.) Yes.\n 2.) No\n 3.) Exit and quit.");
            userChoice = scanner.nextInt();


            if (userChoice == 1) {
                int searchChoice;
                System.out.println("Let's pull up your information. Do you want to search by name or account number? \n 1.) Name.\n2.) Account number.\n");
                searchChoice = scanner.nextInt();

                // If user is already a customer, this brings up their class instance
                // and establishes it as the current customer.
                if (searchChoice == 1) {
                    System.out.println("Please input your first name: ");
                    String first = scanner.next();
                    System.out.println("Please input your last name: ");
                    String last = scanner.next();

                    // If the search returns null, it alerts the user.
                    if (findCustomer(first, last) == null) {
                        System.out.println("Couldn't find a customer with that name.");

                    // If the search does not return null, it references them
                    // to the currentCustomer variable and calls the transaction
                    // method.
                    } else {
                        currentCustomer = findCustomer(first, last);
                        transaction(currentCustomer);
                    }

                // Searches by account number.
                } else if (searchChoice == 2) {
                    System.out.println("Please input your account number: ");
                    int accountNumber = scanner.nextInt();
                    if (findCustomer(accountNumber) == null) {
                        System.out.println("Couldn't find an account with that number.");
                    } else {
                        currentCustomer = findCustomer(accountNumber);
                        transaction(currentCustomer);
                    }
                }

            // Creates a customer instance if they do not already have one.
            } else if (userChoice == 2) {
                currentCustomer = createCustomer();
                customerList.add(currentCustomer);
                transaction(currentCustomer);

            // Ends the main loop.
            } else if (userChoice == 3) {
                customerStatus = false;

            }
        }
    }
}
