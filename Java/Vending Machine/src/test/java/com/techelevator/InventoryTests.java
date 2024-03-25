package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.math.RoundingMode;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InventoryTests {

    private Inventory inv;

    @Before
    public void setInventory() {
        inv = new Inventory();
    }

    //getPrice()
    @Test
    public void GetItemPrice(){
        //Valid Keys
        Assert.assertEquals(BigDecimal.valueOf(0.90).setScale(2, RoundingMode.CEILING), inv.getPrice("A1"));
        Assert.assertEquals(BigDecimal.valueOf(2.25).setScale(2, RoundingMode.CEILING), inv.getPrice("B2"));
        Assert.assertEquals(BigDecimal.valueOf(2.50).setScale(2, RoundingMode.CEILING), inv.getPrice("C3"));
        Assert.assertEquals(BigDecimal.valueOf(1.35).setScale(2, RoundingMode.CEILING), inv.getPrice("D4"));

        //Invalid Keys should not be accepted due to conditionals in the switch case already
    }

    //getItemName() Test
    @Test
    public void GetItemName(){
        //Returns correct Item Name associated to the Key
        Assert.assertEquals("Yellow Duck", inv.getItemName("A1"));
        Assert.assertEquals("Macaroni Penguin", inv.getItemName("B2"));
        Assert.assertEquals("Tabby Cat", inv.getItemName("C3"));
        Assert.assertEquals("Rainbow Horse", inv.getItemName("D4"));
        //Invalid inputs should already be handled by our conditionals in the switch case
    }
    //makeSound() Test
    @Test
    public void ReturnAnimalSound(){
        //Returns correct Animal Sound associated to the Key
        Assert.assertEquals("Quack, Quack, Splash!", inv.makeSound("A1"));
        Assert.assertEquals("Squawk, Squawk, Whee!", inv.makeSound("B2"));
        Assert.assertEquals("Meow, Meow, Meow!", inv.makeSound("C3"));
        Assert.assertEquals("Neigh, Neigh, Yay!", inv.makeSound("D4"));
        //Invalid inputs should already be handled by our conditionals in the switch case
    }

    //checkIfInStock() Test |
    @Test
    public void RemoveItemThenCheckIfInStock(){
        //Removes the item 5 times.
        Assert.assertTrue(inv.checkIfInStock("A1"));    //Return True if item is in stock
        inv.removeItem("A1");                           //Remove the item
        Assert.assertTrue(inv.checkIfInStock("A1"));
        inv.removeItem("A1");
        Assert.assertTrue(inv.checkIfInStock("A1"));
        inv.removeItem("A1");
        Assert.assertTrue(inv.checkIfInStock("A1"));
        inv.removeItem("A1");
        Assert.assertTrue(inv.checkIfInStock("A1"));
        inv.removeItem("A1");
        Assert.assertFalse(inv.checkIfInStock("A1"));
        //After removing 5 times, item is no longer in stock. Return False.
        //We have conditionals to check if the key input exists before this runs elsewhere
    }

}
