package com.tekanthem.util;

import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String DATE_PATTERN_DDMM = "ddMM";
    private static final String DATE_PATTERN_MMDD = "MMdd";
    private static final String DATE_PATTERN_MMYY = "MMyy";

    public static int getCurrentAcctYear() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;

        if (month <= 3) {
            return 10000*(year - 1) + year;
        } else {
            return 10000*(year) + year + 1;
        }
    }

    public static String getSystemDate() {
        SimpleDateFormat formatter= new SimpleDateFormat(DATE_PATTERN);
        Date today = new Date();

        String output = formatter.format(today);

        return output;
    }

    public static String firstDateOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        return sdf.format(cal.getTime());
    }

    public static String lastDateOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        return sdf.format(cal.getTime());
    }

    public static boolean isDateInLimit(String mainDate, String fromDate, String toDate) throws ParseException {
        Date main = convertStringToDate(mainDate);
        Date from = convertStringToDate(fromDate);
        Date to = convertStringToDate(toDate);

        if (main.compareTo(from) < 0) {
            return false;
        }

        return main.compareTo(to) <= 0;
    }

    private static Date convertStringToDate(String date) throws ParseException {
        return new SimpleDateFormat(DATE_PATTERN).parse(date);
    }

    public static String monthFromDate(String date) throws ParseException {
        Date from = convertStringToDate(date);
        Calendar c = Calendar.getInstance();
        c.setTime(from);
        return c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
    }

    public static int getCurrentYear() throws ParseException {
        Date from = convertStringToDate(getSystemDate());
        Calendar c = Calendar.getInstance();
        c.setTime(from);
        return c.get(Calendar.YEAR);
    }

    public static boolean compareDates(String fromDate, String toDate) throws ParseException {
        if (!StringUtils.hasText(fromDate) || !StringUtils.hasText(toDate)) {
            return false;
        }
        Date from = convertStringToDate(fromDate);
        Date to = convertStringToDate(toDate);
        return to.compareTo(from) > 0;
    }

    public static String getDDMM(String jeDate) throws ParseException {
        SimpleDateFormat formatter= new SimpleDateFormat(DATE_PATTERN_DDMM);
        Date jeDateObject = convertStringToDate(jeDate);
        return formatter.format(jeDateObject);
    }

    public static String getMMDD(String jeDate) throws ParseException {
        SimpleDateFormat formatter= new SimpleDateFormat(DATE_PATTERN_MMDD);
        Date jeDateObject = convertStringToDate(jeDate);
        return formatter.format(jeDateObject);
    }

    public static String dateFormatMMYYYY(String dt) {
        if(dt == null)
            return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMyyyy");
        YearMonth ym = YearMonth.parse(dt, formatter);
        return ym.atDay(1).toString();
    }

    public static String getDayBalanceField(String date) {
        String s = "";
        try {
            s = new SimpleDateFormat("_d_M").format(convertStringToDate(date));
        } catch (ParseException pe) {
            pe.printStackTrace();
            return "_31_3";
        }
        return s;
    }

    public static int getCurrentHour() {
        LocalTime now = LocalTime.now();
        return now.getHour();
    }

    public static String previousDateString(String dateString, int i)
            throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date myDate = dateFormat.parse(dateString);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);
        calendar.add(Calendar.DAY_OF_YEAR, i*-1);

        Date previousDate = calendar.getTime();
        String result = dateFormat.format(previousDate);

        return result;
    }

    public static String getSystemDateMMyy() {
        Date today;
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat(DATE_PATTERN_MMYY);
        today = new Date();

        String output = formatter.format(today);

        return output;
    }
}

