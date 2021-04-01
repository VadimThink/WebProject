package edu.epam.finalproject.util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The type Date converter.
 */
public class DateConverter {
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * Convert string to sql date.
     *
     * @param date the date
     * @return the date
     */
    public static Date convertStringToSqlDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDate localDate = LocalDate.parse(date, formatter);
        Date sqlDate = Date.valueOf(localDate);
        return sqlDate;
    }

}
