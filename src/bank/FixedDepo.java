package bank;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FixedDepo {

    private final String fixedAccHolderName;
    private final String fixedAccNumber;
    private float fixedAccBalance;
    private List<String> fixedOperations = new ArrayList<>();
    private boolean fixedAccStatus;
    private String fixedCreatedDate;
    private String fixedClosedDate;
    private float fixedInterest;
    private int monthDuration;

    private boolean interestRateChanged;
    private boolean monthDurationChanged;

    // randomize account number
    // why secureRandom?
    Random rand = new SecureRandom();

    String bankNumber = String.format("%010d", rand.nextInt(1000000));

    // get the current date and time
    LocalDateTime now = LocalDateTime.now();

    // define date time format
    DateTimeFormatter formatted = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // format current date and time
    String formattedDateTime = now.format(formatted);

    // default interest is 3 and duration is 6
    // once balance set, cannto be changed
    public FixedDepo(String name) {
        this.fixedAccHolderName = name;
        this.fixedAccNumber = bankNumber;
        this.fixedAccBalance = 0;
        this.fixedInterest = 3;
        this.monthDuration = 6;
        this.interestRateChanged = false;
        this.monthDurationChanged = false;

    }

    public FixedDepo(String name, Float balance) {
        this.fixedAccHolderName = name;
        this.fixedAccNumber = bankNumber;
        this.fixedAccBalance = balance;
        this.fixedInterest = 3;
        this.monthDuration = 6;
        this.interestRateChanged = false;
        this.monthDurationChanged = false;

    }

    public FixedDepo(String name, Float balance, Float interest) {
        this.fixedAccHolderName = name;
        this.fixedAccNumber = bankNumber;
        this.fixedAccBalance = balance;
        this.fixedInterest = interest;
        this.monthDuration = 6;
        if (fixedInterest != 3)
            this.interestRateChanged = true;
        this.monthDurationChanged = false;

    }

    public FixedDepo(String name, Float balance, Float interest, Integer duration) {
        this.fixedAccHolderName = name;
        this.fixedAccNumber = bankNumber;
        this.fixedAccBalance = balance;
        this.fixedInterest = interest;
        this.monthDuration = duration;
        if (fixedInterest != 3)
            this.interestRateChanged = true;
        if (monthDuration != 6)
            this.monthDurationChanged = true;

    }

    public String getFixedAccHolderName() {
        return fixedAccHolderName;
    }

    public String getFixedAccNumber() {
        return fixedAccNumber;
    }

    public float getFixedAccBalance() {
        return fixedAccBalance;
    }

    public void setFixedAccBalance(float fixedAccBalance) {
        this.fixedAccBalance = fixedAccBalance;
    }

    public List<String> getFixedOperations() {
        return fixedOperations;
    }

    public void setFixedOperations(List<String> fixedOperations) {
        this.fixedOperations = fixedOperations;
    }

    public boolean isFixedAccStatus() {
        return fixedAccStatus;
    }

    public void setFixedAccStatus(boolean fixedAccStatus) {
        this.fixedAccStatus = fixedAccStatus;
    }

    public String getFixedCreatedDate() {
        return fixedCreatedDate;
    }

    public void setFixedCreatedDate(String fixedCreatedDate) {
        this.fixedCreatedDate = fixedCreatedDate;
    }

    public String getFixedClosedDate() {
        return fixedClosedDate;
    }

    public void setFixedClosedDate(String fixedClosedDate) {
        this.fixedClosedDate = fixedClosedDate;
    }

    public float getFixedInterest() {
        return fixedInterest;
    }

    public void setFixedInterest(float fixedInterest) {
        this.fixedInterest = fixedInterest;
    }

    public int getMonthDuration() {
        return monthDuration;
    }

    public void setMonthDuration(int monthDuration) {
        this.monthDuration = monthDuration;
    }

    public boolean isInterestRateChanged() {
        return interestRateChanged;
    }

    public void setInterestRateChanged(boolean interestRateChanged) {
        this.interestRateChanged = interestRateChanged;
    }

    public boolean isMonthDurationChanged() {
        return monthDurationChanged;
    }

    public void setMonthDurationChanged(boolean monthDurationChanged) {
        this.monthDurationChanged = monthDurationChanged;
    }

    public void withdraw() {

    }

    public void deposit() {

    }

    public float getBalance() {
        float balance = this.fixedAccBalance +=(this.fixedAccBalance*fixedInterest);
        return balance;
    }

}
