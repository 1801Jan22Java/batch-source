package com.revature.ctrlcctrlv;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;

public class ExLDT {

   public static void main(String args[]) {
      ExLDT testLDT = new ExLDT();
      testLDT.testLocalDateTime();
   }
	
   public void testLocalDateTime() {
      // Get the current date and time
      LocalDateTime currentTime = LocalDateTime.now();
      System.out.println("Current DateTime: " + currentTime);
		
      LocalDate date1 = currentTime.toLocalDate();
      System.out.println("date1: " + date1);
		
      Month month = currentTime.getMonth();
      int day = currentTime.getDayOfMonth();
      int seconds = currentTime.getSecond();
		
      System.out.println("Month: " + month +" day: " + day +" seconds: " + seconds);
		
      LocalDateTime date2 = currentTime.withDayOfMonth(31).withYear(2020);
      System.out.println("date2: " + date2);
		
      LocalDate date3 = LocalDate.of(2016, Month.NOVEMBER, 9);
      System.out.println("date3: " + date3);
		
      //22 hour 15 minutes
      LocalTime date4 = LocalTime.of(13, 45);
      System.out.println("date4: " + date4);
		
      //parse a string
      LocalTime date5 = LocalTime.parse("13:40:30");
      System.out.println("date5: " + date5);
   }
}