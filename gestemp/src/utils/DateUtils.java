package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateUtils {

     private DateUtils() {
    }
    public static String formatDate(LocalDate date,String pattern){
         DateTimeFormatter formatter=DateTimeFormatter.ofPattern(pattern);
         return date.format(formatter);
    }
    public static LocalDate parseDate(String dateString,String pattern){
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern(pattern);
            return LocalDate.parse(dateString, formatter);
    }

    public static boolean isExpired(LocalDate datePremption){
         return datePremption.isBefore(LocalDate.now());
    }
    public static boolean isDateNaiss(LocalDate dateNaissance){
         int age= LocalDate.now().getYear() - dateNaissance.getYear();
          return   age >= 18;
    }

    
}
    