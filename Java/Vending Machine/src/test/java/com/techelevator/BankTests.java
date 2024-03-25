package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankTests {
    Bank bank;
    @Before
    public void setBank() {
        bank = new Bank();
    }

    // isMoneyValid() Tests
    @Test
    public void Money_Inserted_Is_Invalid(){
        //User inputs a Negative Number
        Assert.assertFalse(bank.isMoneyValid(BigDecimal.valueOf(-1)));
        //User inputs a Decimal
        Assert.assertFalse(bank.isMoneyValid(BigDecimal.valueOf(2.0)));
        //User inputs null
        Assert.assertFalse(bank.isMoneyValid(null));
        //User inputs a $50 bill (Invalid)
        Assert.assertFalse(bank.isMoneyValid(BigDecimal.valueOf(50)));
        //User inputs 0
        Assert.assertFalse(bank.isMoneyValid(BigDecimal.valueOf(0)));
    }
    @Test
    public void Money_Inserted_Is_Valid(){
        //User inputs All the Valid Bills
        Assert.assertTrue(bank.isMoneyValid(BigDecimal.valueOf(1)));
        Assert.assertTrue(bank.isMoneyValid(BigDecimal.valueOf(5)));
        Assert.assertTrue(bank.isMoneyValid(BigDecimal.valueOf(10)));
        Assert.assertTrue(bank.isMoneyValid(BigDecimal.valueOf(20)));
    }
    //getMoney() at Program Start
    @Test
    public void Starting_Balance() {
        //Balance should be 0 upon program start
        Assert.assertEquals("0.00", bank.getCurrentBalance().toString());
    }

    //addMoney() Tests | By Proxy: getMoney() Tests
    @Test
    public void Add_Valid_Bills(){
        //Add $5 -> 5.00
        bank.addMoney("5");
        Assert.assertEquals("5.00", bank.getCurrentBalance().toString());
        //Add $10 -> 15.00
        bank.addMoney("10");
        Assert.assertEquals("15.00", bank.getCurrentBalance().toString());
        //Add $20 -> 35.00
        bank.addMoney("20");
        Assert.assertEquals("35.00", bank.getCurrentBalance().toString());
        //Add $1 -> 36.00
        bank.addMoney("1");
        Assert.assertEquals("36.00", bank.getCurrentBalance().toString());
    }

    @Test
    public void Add_Invalid_Bills(){
        //Adding all Invalid Bills should keep balance at 0
        bank.addMoney("a");
        bank.addMoney("25");
        bank.addMoney("-1");
        bank.addMoney("1.0");
        bank.addMoney("");
        bank.addMoney(null);

        Assert.assertEquals("0.00", bank.getCurrentBalance().toString());
    }

    //purchase() Tests
    @Test
    public void Purchase_Is_Valid(){
        //Adding money so we have funds to work with
        bank.addMoney("20");
        //Buying item at $.90 should update balance to $19.10
        Assert.assertTrue(bank.purchase(BigDecimal.valueOf(.90)));
        Assert.assertEquals("19.10",bank.getCurrentBalance().toString());
        //Buying item at $2.50 should update balance to $16.10
        Assert.assertTrue(bank.purchase(BigDecimal.valueOf(2.50)));
        Assert.assertEquals("16.60",bank.getCurrentBalance().toString());
        //Buying item at exact balance should update balance to $0.00
        Assert.assertTrue(bank.purchase(BigDecimal.valueOf(16.60)));
        Assert.assertEquals("0.00",bank.getCurrentBalance().toString());

    }

    @Test
    public void Purchase_Is_Invalid(){
        //Can't Buy when Funds are at $0.00
        Assert.assertFalse(bank.purchase(BigDecimal.valueOf(.90)));
        Assert.assertEquals("0.00",bank.getCurrentBalance().toString());
        //Can't Buy when Item Price is Greater than our Available Funds
        bank.addMoney("20");
        Assert.assertFalse(bank.purchase(BigDecimal.valueOf(21.1)));
        Assert.assertEquals("20.00",bank.getCurrentBalance().toString());
    }
}
