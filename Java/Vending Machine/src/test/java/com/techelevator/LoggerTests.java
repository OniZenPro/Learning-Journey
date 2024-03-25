package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoggerTests {
    private Logger logger;
    private final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("M/dd/u");
    private final DateTimeFormatter TF = DateTimeFormatter.ofPattern("hh:mm:ss a");
    @Before
    public void setLogger() {
        logger = new Logger("LoggingTest.log");
    }
    @Test
    public void LogActionTest(){
        logger.log("FEED MONEY", "5.00", "5.00");
        String msgDate = DTF.format(LocalDate.now()) + " " + TF.format(LocalTime.now());
        String output = msgDate + " FEED MONEY $5.00 $5.00";
        try(BufferedReader buffR = new BufferedReader(new FileReader("LoggingTest.log"))){
            String text;
            while((text = buffR.readLine()) != null){
                if(buffR.readLine() == null){
                    Assert.assertEquals(output, text);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void LogPurchaseTest(){
        logger.log("Cube Duck", "A2", "2.50", "7.50");
        String msgDate = DTF.format(LocalDate.now()) + " " + TF.format(LocalTime.now());
        String output = msgDate + " Cube Duck A2 $2.50 $7.50";
        try(BufferedReader buffR = new BufferedReader(new FileReader("LoggingTest.log"))){
            String text;
            while((text = buffR.readLine()) != null){
                if(buffR.readLine() == null){
                    Assert.assertEquals(text,output);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
