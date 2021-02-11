package edu.epam.finalproject.util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateToSqlConverter {

    public static Date convert(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        return sqlDate;
    }

}
