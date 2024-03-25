package com.techelevator;

import Products.*;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Inventory {
    //  <?> is a wild card: it means it can accept any object type
    private TreeMap<String, List<?>> stock = new TreeMap<>();
    private final File FILE;
    private final int MAX_STOCK;
    public Inventory() {
        FILE = new File("vendingmachine.csv");
        MAX_STOCK = 5;
        generateInventory();  // Generates Full Inventory upon Instantiation
    }

    public void generateInventory() {
        try (BufferedReader buffR = new BufferedReader(new FileReader(FILE.getAbsolutePath()))) {
            String text = "";
            //read a line and store it in a variable. Keep looping til there's no more text
            while ((text = buffR.readLine()) != null) {
                String[] info = text.split(","); //split the line into an array

                String key = info[0];  //index 0 is always the key
                String itemName = info[1]; //index 1 is always the name of the item
                BigDecimal price = BigDecimal.valueOf(Double.parseDouble(info[2])); //index 2 is always the price
                String type = info[3]; //index 3 is always the type of animal the item is

                /*
                *Switch Case:
                * Checks for the animal 'type'.
                * Depending on the 'type' it instantiates a new List to contain
                * the specific animal object that is identified as the 'type'.
                * Then we instantiate the 'MAX_STOCK' of the 'type' of animal
                * object and put it into the list.
                * We then put the key, provided by index 0, and put the list into
                * the hashmap.
                */

                switch (type) {
                    case "Penguin":
                        List<Penguin> penguinsList = new ArrayList();
                        for (int i = 0; i < MAX_STOCK; i++) {
                            penguinsList.add(new Penguin(itemName, type, price));
                        }
                        stock.put(key, penguinsList);
                        break;
                    case "Duck":
                        List<Duck> ducksList = new ArrayList();
                        for (int i = 0; i < MAX_STOCK; i++) {
                            ducksList.add(new Duck(itemName, type, price));
                        }
                        stock.put(key, ducksList);
                        break;
                    case "Cat":
                        List<Cat> catsList = new ArrayList();
                        for (int i = 0; i < MAX_STOCK; i++) {
                            catsList.add(new Cat(itemName, type, price));
                        }
                        stock.put(key, catsList);
                        break;
                    case "Pony":
                        List<Pony> poniesList = new ArrayList();
                        for (int i = 0; i < MAX_STOCK; i++) {
                            poniesList.add(new Pony(itemName, type, price));
                        }
                        stock.put(key, poniesList);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("FILE WAS NOT FOUND! Exiting...");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("ERROR! Exiting...");
            System.exit(1);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    public void showInventory() {
        //********************************************************//
        //         HOW TO ACCESS THE VALUES FOR THE KEY           //
        //********************************************************//
        for (String key : stock.keySet()) {        //For Each Key
            List<?> list = stock.get(key);         //Create a List that accepts any <Type> = value associated with the 'key'
            Object animal;                         //Create an Object variable (animal) that will represent the List element
            if (list.size() != 0) {                //If the List has elements (items are in stock)
                animal = list.get(0);              //Set the Object variable (animal) to equal the first element in the list
                StuffedAnimal item = (StuffedAnimal) animal;     //Cast the StuffedAnimal class onto 'animal' so we can use the methods of the Duck class
                System.out.println(" [ " + key + " ] [ " + item.getItemName() + " | $" + item.getPrice().toString() + " ] [ STOCK: " + list.size() + " ] ");
            } else {
                System.out.println(" [ " + key + " ] [ ITEM OUT OF STOCK! ]");
            }
        }
    }
    public void showNumPad(String currentBalance) {
        System.out.println("*********************************************************");
        showInventory();
        int i = 0;          //declare counter i
        System.out.println("*********************************************************");
        for (String key : stock.keySet()) {        //For Each Key
            System.out.print(" [ " + key + " ] "); //print the key
            i++;                                   //add 1 to the counter (i)
            if(i % 4 == 0){                        //if the counter is perfectly divisible by 4
                System.out.println();              //print a blank line
            }
        }
        //Should come out like: [ A1 ] [ A2 ] [ A3 ] [ A4]
        System.out.println("*********************************************************");
        System.out.println("-----PLEASE INPUT A KEY!-----YOUR-BALANCE:--$--" + currentBalance + "-----");
        System.out.println("*********************************************************");
    }
    public void removeItem(String key) {
        List<?> list = stock.get(key);         //Create a List that accepts any <Type> = value associated with the 'key'
        Object animal;                         //Create an Object variable (animal) that will represent the List element
        animal = list.get(list.size() - 1);    //set to equal last list element
        list.remove(animal);                   //Remove the list element
    }
    public BigDecimal getPrice(String key){
            List<?> list = stock.get(key);         //Create a List that accepts any <Type> = value associated with the 'key'
            Object animal;                         //Create an Object variable (animal) that will represent the List element
            animal = list.get(list.size() - 1);    //set to equal last list element
            StuffedAnimal item = (StuffedAnimal) animal;  //Cast
            return item.getPrice();                       //return the item's price

    }
    public String makeSound(String key){
            List<?> list = stock.get(key);         //Create a List that accepts any <Type> = value associated with the 'key'
            Object animal;                         //Create an Object variable (animal) that will represent the List element
            animal = list.get(list.size() - 1);    //set to equal last list element
            StuffedAnimal item = (StuffedAnimal) animal;  //Cast
            return item.getSound();                      //return the item's sound
    }

    public String getItemName(String key){
        List<?> list = stock.get(key);         //Create a List that accepts any <Type> = value associated with the 'key'
        Object animal;                         //Create an Object variable (animal) that will represent the List element
        animal = list.get(list.size() - 1);    //set to equal last list element
        StuffedAnimal item = (StuffedAnimal) animal;  //Cast
        return item.getItemName();             //return the item's name
    }
    public boolean checkIfInStock(String key) {
        List<?> list = stock.get(key);         //Create a List that accepts any <Type> = value associated with the 'key'
        if (list.size() > 0) {                 //If list size is > 0
            return true;                       //return true
        }
        return false;                          //else return false
    }
    public Set getKeys(){
        return stock.keySet();
    }
}



