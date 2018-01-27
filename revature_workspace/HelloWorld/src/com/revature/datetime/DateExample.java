package com.revature.datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
/*DateTime - Corrects older not-thread safe, 
 * difficult time-zone handling, and poor design DateTime API

Includes Local and Zoned Dates

Import ZonedDateTime and ZoneID to implement time zones
ZoneID Class can be serialized
*/
import java.time.temporal.ChronoUnit;

public class DateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LocalDateTime.now().toString());
		System.out.println(LocalDate.now().toString());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.ofInstant(Instant.now(),ZoneId.systemDefault()));
		System.out.println(ZoneId.systemDefault().toString());
		System.out.println(LocalDateTime.now().plusMonths(6));
		System.out.println(ZonedDateTime.now(ZoneId.of("Europe/Berlin")));
		System.out.println(ZonedDateTime.now(ZoneId.of("Europe/Moscow")));
		System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Tokyo")));
		LocalDate ldt1= LocalDate.now();
		LocalDate ldt2 = LocalDate.now().plusMonths(1);
		ldt2 = ldt2.plusWeeks(9);
		System.out.println(ldt1.toString());
		System.out.println(ldt2.toString());
		System.out.println(Period.between(ldt1,ldt2).getMonths());
		System.out.println(ChronoUnit.DAYS.between(ldt1, ldt2));
		LocalDateTime ldt3= LocalDateTime.now();
		LocalDateTime ldt4 = LocalDateTime.now().plusWeeks(9);
		System.out.println(ChronoUnit.MINUTES.between(ldt3, ldt4));
		
		
		
		System.out.println();

	}

}
