package com.techelevator;

import java.util.Scanner;

public class ConsoleService {
    //Scanner for all user input
    Scanner userInput = new Scanner(System.in);
    boolean validInput;
    private String selected = "";

    public void setValidInput(boolean validInput) {
        this.validInput = validInput;
    }

    //Print Main Menu
    public String inputStartMenu() {
        validInput = false;
        while (!validInput) {
            System.out.println("\nPlease select from the following options (numeric value only) to begin:");
            System.out.println("(1) Display Vending Machine Options");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");
            if (userInput.hasNextLine()) {
                selected = userInput.nextLine();
                setValidInput(true);
            }
        }
        return selected;
    }

    //Print Purchase Menu
    public String inputPurchaseMenu() {
        validInput = false;
        while (!validInput) {
            System.out.println("Welcome to the purchase menu!");
            System.out.println("Please select from the following options (numeric value only) to begin:");
            System.out.println("(1) Feed Money");
            System.out.println("(2) Select Product");
            System.out.println("(3) Finish Transaction");
            if (userInput.hasNextLine()) {
                selected = userInput.nextLine();
                setValidInput(true);
            }
        }
        return selected;
    }

    public void getFundsAfterPurchase(String itemName, String itemPrice, String currentBalance, String noise) {
        if (itemName.equals("")) {
            System.out.println("**********************");
            System.out.println("| ITEM OUT OF STOCK! |");
            System.out.println("**********************");
            System.out.println("Current Funds: $" + currentBalance); //Updated funds after making a selection
        } else {
            System.out.println("*******************************************************************************************");
            System.out.println("Get Your Bag Out!!!! Dispensing....");
            System.out.println(noise);
            System.out.println("You Selected: " + itemName + " | For the Price Of: $" + itemPrice + " | Your Updated Funds Are: $" + currentBalance); //Updated funds after making a selection
            System.out.println("*******************************************************************************************");
        }
    }

    // Out of stock Message
    public void outOfStock() {
        System.out.println("This product is out of stock! We're so sorry!");
    }

    //Item doesn't exist Message
    public void doesNotExist() {
        System.out.println("It appears that the item you selected does not exist!");
    }

    //Insufficient funds Message
    public void fundsNotGreatEnough() {
        System.out.println("***********************");
        System.out.println("| INSUFFICIENT FUNDS! |");
        System.out.println("***********************");
    }

    // Prints Prompt for funds to insert
    public void askMoney() {
        System.out.println("How Much Do You Want To Insert? ( Numeric Values Only! )");
        System.out.println(" [ $1 ]  [ $5 ]  [ $10 ]  [ $20 ]");
    }

}