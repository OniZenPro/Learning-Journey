package com.techelevator;
import java.util.Scanner;

public class Application {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        ConsoleService console = new ConsoleService();
        Inventory inventory = new Inventory();
        Bank bank = new Bank();


        Logger logger = new Logger("Vending.log");

        boolean finishedWithVendingMachine = false; //Used to control the experience
        String userInput;

        //Print Welcome Messages
        System.out.println("***************************************************************");
        System.out.println("|  Welcome to the Team Orion Stuffed Animal Vending Machine!  |");
        System.out.println("***************************************************************");
        while (!finishedWithVendingMachine) {
            switch (console.inputStartMenu()) {
                case "1":
                    inventory.showInventory();
                    break;
                case "2":
                    boolean purchaseFlag = false;
                    while (!purchaseFlag) {
                        switch (console.inputPurchaseMenu()) {
                            case "1":
                                console.askMoney();
                                userInput = sc.nextLine();
                                if(bank.addMoney(userInput)) {
                                    logger.log(
                                            "FEED MONEY",
                                            userInput.concat(".00"),
                                            bank.getCurrentBalance().toString());
                                }
                                break;
                            case "2":
                                inventory.showNumPad(bank.getCurrentBalance().toString());
                                userInput = sc.nextLine().toUpperCase();
                                if (!inventory.getKeys().contains(userInput)) {
                                    console.doesNotExist();
                                    break;
                                } else {
                                    if (inventory.checkIfInStock(userInput)) {
                                        if (bank.purchase(inventory.getPrice(userInput))) {
                                            console.getFundsAfterPurchase(
                                                    inventory.getItemName(userInput),
                                                    inventory.getPrice(userInput).toString(),
                                                    bank.getCurrentBalance().toString(),
                                                    inventory.makeSound(userInput));
                                            logger.log(
                                                    inventory.getItemName(userInput),
                                                    userInput,
                                                    inventory.getPrice(userInput).toString(),
                                                    bank.getCurrentBalance().toString());
                                            inventory.removeItem(userInput);
                                        } else {
                                            console.fundsNotGreatEnough();
                                        }
                                    } else {
                                        console.outOfStock();
                                    }
                                }
                                break;
                            case "3":
                                logger.log(
                                        "GIVE CHANGE",
                                        bank.getCurrentBalance().toString(),
                                        "0.00");
                                bank.returnChange();
                                purchaseFlag = true;
                                break;
                            default:
                                System.out.println("INVALID INPUT!");
                                System.out.println("PLEASE USE 1-3\n");
                        }
                    }
                    continue;
                case "3":
                    System.out.println("Thank you! Come Again!");
                    finishedWithVendingMachine = true;
                    break;
                default:
                    System.out.println("INVALID INPUT!");
                    System.out.println("PLEASE USE 1-3\n");
            }
        }
    }
}
