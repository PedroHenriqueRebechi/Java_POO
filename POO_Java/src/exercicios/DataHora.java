package exercicios;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DataHora {

	public static void main(String[] args) {

		LocalDate d04 = LocalDate.parse("2022-07-20");
		LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
		Instant d06 = Instant.parse("2022-07-20T01:30:26Z");
	
		LocalDate pastWeekLocalDate = d04.minusWeeks(1);
		LocalDate nextWeekLocalDate = d04.plusDays(7);
		LocalDateTime pastWeekLocalDateTime = d05.minusWeeks(1);
		
		System.out.println(pastWeekLocalDate);
		System.out.println(nextWeekLocalDate);
		
		Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
		
		System.out.println(pastWeekInstant);
		
		// Duração em dias
		Duration t1 = Duration.between(pastWeekLocalDateTime, d05);
		System.out.println(t1.toDays());
		
		Duration t2 = Duration.between(pastWeekLocalDate.atStartOfDay(), d04.atStartOfDay());
		System.out.println(t2.toDays());

		
		Duration t3 = Duration.between(pastWeekLocalDateTime, d06);
		System.out.println(t3.toDays());
	}

}
