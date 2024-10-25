package bank;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankAccount {

    // these 2 members are final because they are not supposed to be changed
    private final String accountHolderName;
    // random generated account number
    private final String accountNumber;

    private float accountBalance;
    // whether account is open or closed
    private boolean accountStatus;

    // when account was created/closed
    private String createdDate;
    private String closedDate;

    // transactions for operations performed on the account - a list of strings
    // this is how to create an array list
    // created when there is a requirement for a list without fixed indexes
    private List<String> operations = new ArrayList<>();

    // randomize account number
    // why secureRandom?
    // dk, is just the function for a random generator
    Random rand = new SecureRandom();

    // String.format is used instead of String.parseString because
    // we are converting an integer to a string within the code/program and not from
    // an input in terminal
    String bankNumber = String.format("%010d", rand.nextInt(1000000));

    // get the current date and time
    LocalDateTime now = LocalDateTime.now();

    // define date time format
    DateTimeFormatter formatted = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // format current date and time
    String formattedDateTime = now.format(formatted);

    // constructor with single parameter (String accHolderName),
    // initializes balance to 0
    // constructor name must be same as class name
    public BankAccount(String accHolderName) {
        this.accountHolderName = accHolderName;
        this.accountNumber = bankNumber;
        this.accountBalance = 0;
        this.accountStatus = true;
        this.createdDate = formattedDateTime;
    }

    // constructor with 2 parameters (String accHolderName
    // and Float accBalance) which is the initial account balance
    public BankAccount(String accHolderName, Float accBalance) {
        this.accountHolderName = accHolderName;
        this.accountNumber = bankNumber;
        this.accountBalance = accBalance;
        this.accountStatus = true;
        this.createdDate = formattedDateTime;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean isAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }

    public List<String> getOperations() {
        return operations;
    }

    public void setOperations(List<String> operations) {
        this.operations = operations;
    }

    // methods for deposit
    public void deposit(int amount) {
        if (amount < 0 || accountStatus == false) {
            throw new IllegalArgumentException("Invalid amount or account has been closed");
        } else {
            accountBalance = accountBalance + amount;
            // .add is a method for arrayList
            operations.add("Deposited " + amount + " at " + formattedDateTime);

        }
    }

    public void withdraw(int amount) {
        if (amount < 0 || accountStatus == false || amount > accountBalance) {
            throw new IllegalArgumentException("Invalid amount or account has been closed");
        } else {
            accountBalance = accountBalance - amount;
            operations.add("Withdrawn " + amount + " at" + formattedDateTime);
        }
    }

}
