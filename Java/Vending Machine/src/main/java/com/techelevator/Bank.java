package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Bank {
    private BigDecimal currentBalance;

    public Bank() {
        currentBalance = BigDecimal.valueOf(0);
    }
    public BigDecimal getCurrentBalance() {
        return currentBalance.setScale(2, RoundingMode.CEILING);
    }
    // Checks if money is Valid Bill

    public boolean isMoneyValid(BigDecimal moneyAdded) {
        try {
            boolean valid;
            if (moneyAdded.compareTo(new BigDecimal("1.00")) == 0) {
                valid = true;
            } else if (moneyAdded.compareTo(new BigDecimal("5.00")) == 0) {
                valid = true;
            } else if (moneyAdded.compareTo(new BigDecimal("10.00")) == 0) {
                valid = true;
            } else if (moneyAdded.compareTo(new BigDecimal("20.00")) == 0) {
                valid = true;
            } else {
                valid = false;
            }
            return valid;
        } catch (NumberFormatException e){
            System.out.println("INVALID INPUT | PLEASE ENTER INTEGER VALUES (1, 5, 10, 20) ONLY");
            return false;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Adds money to Current Balance

    public boolean addMoney(String moneyAdded) {
        try {
            if (isMoneyValid(BigDecimal.valueOf(Long.parseLong(moneyAdded)))) {
                currentBalance = currentBalance.add(BigDecimal.valueOf(Long.parseLong(moneyAdded)));
                System.out.println("You Inserted: $" + moneyAdded.concat(".00") + " | Your New Funds are: $" + currentBalance);
                return true;
            } else {
                System.out.println("INVALID INPUT | PLEASE ENTER INTEGER VALUES (1, 5, 10, 20) ONLY");
                return false;
            }
        } catch (NumberFormatException e){
            System.out.println("INVALID INPUT | PLEASE ENTER INTEGER VALUES (1, 5, 10, 20) ONLY");
            return false;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Creates Purchase method.

    public boolean purchase(BigDecimal itemPrice) {

        if (getCurrentBalance().compareTo(itemPrice) == 1 ||
                getCurrentBalance().compareTo(itemPrice) == 0) {
            currentBalance = currentBalance.subtract(itemPrice);
            return true;
        }
        return false;
    }

    // Returns Change in as few coins as possible.

    public void returnChange() {
        int quartersToReturn = 0;
        int dimesToReturn = 0;
        int nickelsToReturn = 0;
        // If Current Balance > 0
        System.out.println("*****************************************");
        System.out.println("Thanks For Purchasing!");
        System.out.println("Your Change: $" + getCurrentBalance());

        if (currentBalance.compareTo(new BigDecimal("0.25")) == 1
                || currentBalance.compareTo(new BigDecimal("0.25")) == 0) {
            quartersToReturn = currentBalance.divide(new BigDecimal("0.25")).intValue();
            currentBalance = currentBalance.remainder(new BigDecimal("0.25"));
        }
        if (currentBalance.compareTo(new BigDecimal("0.10")) == 1
                || currentBalance.compareTo(new BigDecimal("0.10")) == 0) {
            dimesToReturn = currentBalance.divide(new BigDecimal("0.10")).intValue();
            currentBalance = currentBalance.remainder(new BigDecimal("0.10"));
        }
        if (currentBalance.compareTo(new BigDecimal("0.05")) == 1
                || currentBalance.compareTo(new BigDecimal("0.05")) == 0) {
            nickelsToReturn = currentBalance.divide(new BigDecimal("0.05")).intValue();
            currentBalance = currentBalance.remainder(new BigDecimal("0.05"));
        }

        System.out.println("Quarters: " + quartersToReturn + " | Dimes: " + dimesToReturn + " | Nickels: " + nickelsToReturn);
        System.out.println("*****************************************");
    }

}
