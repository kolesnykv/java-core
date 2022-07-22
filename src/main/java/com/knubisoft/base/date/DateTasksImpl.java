package com.knubisoft.base.date;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class DateTasksImpl implements DateTasks {

    @Override
    public String add1Day(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date, formatter);
        LocalDate returndate = date1.plusDays(1);
        return returndate.toString();
    }

    @Override
    public int getMonthFromDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy");
        LocalDate date1 = LocalDate.parse(date,formatter);
        return date1.getMonthValue();
    }

    @Override
    public String findBiggestDate(String date1, String date2, String date3) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate dateone = LocalDate.parse(date1,formatter);
        LocalDate datetwo = LocalDate.parse(date2,formatter);
        LocalDate datethree = LocalDate.parse(date3,formatter);
        if (dateone.compareTo(datetwo)>0) {
            if (dateone.compareTo(datethree)>0) return date1;
            else return date3;
        } else {
            if (datetwo.compareTo(datethree)>0) return date2;
            else return date3;
        }
    }

    @Override
    public String getLastDayOfTheMonth(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateone = LocalDate.parse(date,formatter);
        return dateone.plusDays(dateone.lengthOfMonth()-dateone.getDayOfMonth()).toString();

    }

    @Override
    public String sumTimes(String time1, String time2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime timeone = LocalTime.parse(time1,formatter);
        LocalTime timetwo = LocalTime.parse(time2,formatter);
        return timeone.plusHours(timetwo.getHour())
                .plusMinutes(timetwo.getMinute())
                .plusSeconds(timetwo.getSecond())
                .format(formatter)
                .toString();

    }

    @Override
    public String getDateAfter2Weeks(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date,formatter);
        return date1.plusWeeks(2)
                .toString();

    }

    @Override
    public long getNumberOfDaysBetweenTwoDates(String date1, String date2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateone = LocalDate.parse(date1,formatter);
        LocalDate datetwo = LocalDate.parse(date2,formatter);
        Period period = Period.between(dateone, datetwo);
        return ChronoUnit.DAYS.between(dateone, datetwo);
    }

    @Override
    public String[] getTheNextAndPreviousFriday(String date) {
        return null;
    }

    @Override
    public int getNumberOfMonthsRemainingInTheYear(String date) {
        return -1;
    }
}
