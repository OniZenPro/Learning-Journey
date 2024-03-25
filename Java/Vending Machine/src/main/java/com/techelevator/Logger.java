package com.techelevator;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private final File FILE;
    private final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("M/dd/u");
    private final DateTimeFormatter TF = DateTimeFormatter.ofPattern("hh:mm:ss a");
    public Logger(String file){
        FILE = new File(file);
    }

    //actions - FEED MONEY / GIVE CHANGE
    public void log(String action, String moneyInUse, String currentBalance) {

        String msgDate = DTF.format(LocalDate.now()) + " " + TF.format(LocalTime.now());
        String output = msgDate + " " + action + " $" + moneyInUse + " $" + currentBalance;
        try (PrintWriter printW = new PrintWriter(new BufferedOutputStream(new FileOutputStream(FILE, true)))) {
            printW.println(output);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    // Actions - Purchase
    public void log(String itemName, String key, String moneyInUse, String currentBalance) {

        String msgDate = DTF.format(LocalDate.now()) + " " + TF.format(LocalTime.now());
        String output = msgDate + " " + itemName + " " + key + " $" + moneyInUse + " $" + currentBalance;

        try (PrintWriter printW = new PrintWriter(new BufferedOutputStream(new FileOutputStream(FILE, true)))) {
            printW.println(output);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
