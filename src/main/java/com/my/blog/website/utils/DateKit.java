package com.my.blog.website.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/3/10 010.
 */
public class DateKit {
    public static final int INTERVAL_DAY = 1;
    public static final int INTERVAL_WEEK = 2;
    public static final int INTERVAL_MONTH = 3;
    public static final int INTERVAL_YEAR = 4;
    public static final int INTERVAL_HOUR = 5;
    public static final int INTERVAL_MINUTE = 6;
    public static final int INTERVAL_SECOND = 7;
    public static final Date tempDate = new Date((new Long("-2177481952000")).longValue());
    private static List<SimpleDateFormat> dateFormats = new ArrayList(12) {
        private static final long serialVersionUID = 2249396579858199535L;

        {
            this.add(new SimpleDateFormat("yyyy-MM-dd"));
            this.add(new SimpleDateFormat("yyyy/MM/dd"));
            this.add(new SimpleDateFormat("yyyy.MM.dd"));
            this.add(new SimpleDateFormat("yyyy-MM-dd HH:24:mm:ss"));
            this.add(new SimpleDateFormat("yyyy/MM/dd HH:24:mm:ss"));
            this.add(new SimpleDateFormat("yyyy.MM.dd HH:24:mm:ss"));
            this.add(new SimpleDateFormat("M/dd/yyyy"));
            this.add(new SimpleDateFormat("dd.M.yyyy"));
            this.add(new SimpleDateFormat("M/dd/yyyy hh:mm:ss a"));
            this.add(new SimpleDateFormat("dd.M.yyyy hh:mm:ss a"));
            this.add(new SimpleDateFormat("dd.MMM.yyyy"));
            this.add(new SimpleDateFormat("dd-MMM-yyyy"));
        }
    };

    public DateKit() {
    }

    public static boolean isToday(Date date) {
        Date now = new Date();
        boolean result = true;
        result &= date.getYear() == now.getYear();
        result &= date.getMonth() == now.getMonth();
        result &= date.getDate() == now.getDate();
        return result;
    }

    public static long DaysBetween(Date date1, Date date2) {
        if(date2 == null) {
            date2 = new Date();
        }

        long day = (date2.getTime() - date1.getTime()) / 86400000L;
        return day;
    }

    public static boolean compareDate(String date1, String date2) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date e = format.parse(date1);
            Date d2 = format.parse(date2);
            return !e.after(d2);
        } catch (ParseException var5) {
            var5.printStackTrace();
            return false;
        }
    }

    public static Date dateFormat(String date, String dateFormat) {
        if(date == null) {
            return null;
        } else {
            SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            try {
                return format.parse(date);
            } catch (Exception ignored) {
            }

            return null;
        }
    }

    public static Date dateFormat(String date) {
        return dateFormat(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String dateFormat(Date date, String dateFormat) {
        if(date != null) {
            SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            if(date != null) {
                return format.format(date);
            }
        }

        return "";
    }

    public static String birthdayFormat(Date date) {
        if(date != null) {
            SimpleDateFormat format = null;
            if(date.before(tempDate)) {
                format = new SimpleDateFormat("MM-dd");
            } else {
                format = new SimpleDateFormat("yyyy-MM-dd");
            }

            if(date != null) {
                return format.format(date);
            }
        }

        return "";
    }

    public static String dateFormat(Date date) {
        return dateFormat(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static boolean isExpiredDay(Date date1) {
        long day = ((new Date()).getTime() - date1.getTime()) / 86400000L;
        return day >= 1L;
    }

    public static Date getYesterday() {
        Date date = new Date();
        long time = date.getTime() / 1000L - 86400L;
        date.setTime(time * 1000L);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            date = format.parse(format.format(date));
        } catch (Exception var5) {
            System.out.println(var5.getMessage());
        }

        return date;
    }

    public static Date getWeekAgo() {
        Date date = new Date();
        long time = date.getTime() / 1000L - 604800L;
        date.setTime(time * 1000L);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            date = format.parse(format.format(date));
        } catch (Exception var5) {
            System.out.println(var5.getMessage());
        }

        return date;
    }

    public static String getDaysAgo(int interval) {
        Date date = new Date();
        long time = date.getTime() / 1000L - (long)(interval * 60 * 60 * 24);
        date.setTime(time * 1000L);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return format.format(date);
        } catch (Exception var6) {
            System.out.println(var6.getMessage());
            return "";
        }
    }

    public static Date getTomorrow() {
        Date date = new Date();
        long time = date.getTime() / 1000L + 86400L;
        date.setTime(time * 1000L);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            date = format.parse(format.format(date));
        } catch (Exception var5) {
            System.out.println(var5.getMessage());
        }

        return date;
    }

    public static Date getBeforeDate(String range) {
        Calendar today = Calendar.getInstance();
        if("week".equalsIgnoreCase(range)) {
            today.add(4, -1);
        } else if("month".equalsIgnoreCase(range)) {
            today.add(2, -1);
        } else {
            today.clear();
        }

        return today.getTime();
    }

    public static Date getThisWeekStartTime() {
        Calendar today = Calendar.getInstance();
        today.set(7, today.getFirstDayOfWeek());
        Calendar weekFirstDay = Calendar.getInstance();
        weekFirstDay.clear();
        weekFirstDay.set(1, today.get(1));
        weekFirstDay.set(2, today.get(2));
        weekFirstDay.set(5, today.get(5));
        return weekFirstDay.getTime();
    }

    public static String getToday(String format) {
        String result = "";

        try {
            Date today = new Date();
            SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
            result = simpleFormat.format(today);
        } catch (Exception var4) {
            ;
        }

        return result;
    }

    public static Date getStartDay(int year, int month) {
        Calendar today = Calendar.getInstance();
        today.clear();
        today.set(1, year);
        today.set(2, month - 1);
        today.set(5, 1);
        return today.getTime();
    }

    public static List<Integer> getBeforeYearList(int before) {
        Calendar today = Calendar.getInstance();
        int theYear = today.get(1);
        ArrayList list = new ArrayList();

        for(int i = before; i >= 0; --i) {
            list.add(Integer.valueOf(theYear - i));
        }

        return list;
    }

    public static Date dateAdd(int interval, Date date, int n) {
        long time = date.getTime() / 1000L;
        switch(interval) {
            case 1:
                time += (long)(n * 86400);
                break;
            case 2:
                time += (long)(n * 604800);
                break;
            case 3:
                time += (long)(n * 2678400);
                break;
            case 4:
                time += (long)(n * 31536000);
                break;
            case 5:
                time += (long)(n * 3600);
                break;
            case 6:
                time += (long)(n * 60);
                break;
            case 7:
                time += (long)n;
        }

        Date result = new Date();
        result.setTime(time * 1000L);
        return result;
    }

    public static int dateDiff(int interval, Date begin, Date end) {
        long beginTime = begin.getTime() / 1000L;
        long endTime = end.getTime() / 1000L;
        long tmp = 0L;
        if(endTime == beginTime) {
            return 0;
        } else {
            if(endTime < beginTime) {
                tmp = beginTime;
                beginTime = endTime;
                endTime = tmp;
            }

            long intervalTime = endTime - beginTime;
            long result = 0L;
            switch(interval) {
                case 1:
                    result = intervalTime / 86400L;
                    break;
                case 2:
                    result = intervalTime / 604800L;
                    break;
                case 3:
                    result = intervalTime / 2678400L;
                    break;
                case 4:
                    result = intervalTime / 31536000L;
                    break;
                case 5:
                    result = intervalTime / 3600L;
                    break;
                case 6:
                    result = intervalTime / 60L;
                    break;
                case 7:
                    result = intervalTime / 1L;
            }

            if(tmp > 0L) {
                result = 0L - result;
            }

            return (int)result;
        }
    }

    public static int getTodayYear() {
        int yyyy = Integer.parseInt(dateFormat(new Date(), "yyyy"));
        return yyyy;
    }

    public static Date getNow() {
        return new Date();
    }

    public static String dateFormatRss(Date date) {
        return date != null?dateFormat(date, "E, d MMM yyyy H:mm:ss") + " GMT":"";
    }

    public static boolean betweenStartDateAndEndDate(Date startDate, Date endDate) {
        boolean bool = false;
        Date curDate = new Date();
        if(curDate.after(startDate) && curDate.before(dateAdd(1, endDate, 1))) {
            bool = true;
        }

        return bool;
    }

    public static boolean nowDateBetweenStartDateAndEndDate(Date startDate, Date endDate) {
        boolean bool = false;
        Date curDate = new Date();
        if(curDate.after(startDate) && curDate.before(endDate)) {
            bool = true;
        }

        return bool;
    }

    public static boolean nowDateAfterDate(Date date) {
        boolean bool = false;
        Date curDate = new Date();
        if(curDate.after(date)) {
            bool = true;
        }

        return bool;
    }

    public static int getBetweenTodaysStartDateAndEndDate(Date startDate, Date endDate) {
        byte betweentoday = 0;
        if(startDate == null) {
            return betweentoday;
        } else {
            if(endDate == null) {
                Calendar calendar = Calendar.getInstance();
                String year = (new Integer(calendar.get(1))).toString();
                String month = (new Integer(calendar.get(2) + 1)).toString();
                String day = (new Integer(calendar.get(5))).toString();
                String strtodaytime = year + "-" + month + "-" + day;
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    endDate = formatter.parse(strtodaytime);
                } catch (ParseException var10) {
                    var10.printStackTrace();
                }
            }

            int betweentoday1;
            if(endDate.after(startDate)) {
                betweentoday1 = (int)((endDate.getTime() - startDate.getTime()) / 86400000L);
            } else {
                betweentoday1 = (int)((startDate.getTime() - endDate.getTime()) / 86400000L);
            }

            return betweentoday1;
        }
    }

    public static String getTime(int format) {
        StringBuffer cTime = new StringBuffer(10);
        Calendar time = Calendar.getInstance();
        int miltime = time.get(14);
        int second = time.get(13);
        int minute = time.get(12);
        int hour = time.get(11);
        int day = time.get(5);
        int month = time.get(2) + 1;
        int year = time.get(1);
        if(format != 14) {
            if(year >= 2000) {
                year -= 2000;
            } else {
                year -= 1900;
            }
        }

        if(format >= 2) {
            if(format == 14) {
                cTime.append(year);
            } else {
                cTime.append(getFormatTime(year, 2));
            }
        }

        if(format >= 4) {
            cTime.append(getFormatTime(month, 2));
        }

        if(format >= 6) {
            cTime.append(getFormatTime(day, 2));
        }

        if(format >= 8) {
            cTime.append(getFormatTime(hour, 2));
        }

        if(format >= 10) {
            cTime.append(getFormatTime(minute, 2));
        }

        if(format >= 12) {
            cTime.append(getFormatTime(second, 2));
        }

        if(format >= 15) {
            cTime.append(getFormatTime(miltime, 3));
        }

        return cTime.toString();
    }

    private static String getFormatTime(int time, int format) {
        StringBuffer numm = new StringBuffer();
        int length = String.valueOf(time).length();
        if(format < length) {
            return null;
        } else {
            for(int i = 0; i < format - length; ++i) {
                numm.append("0");
            }

            numm.append(time);
            return numm.toString().trim();
        }
    }

    public static int getUserAge(Date birthday) {
        if(birthday == null) {
            return 0;
        } else {
            Calendar cal = Calendar.getInstance();
            if(cal.before(birthday)) {
                return 0;
            } else {
                int yearNow = cal.get(1);
                cal.setTime(birthday);
                int yearBirth = cal.get(1);
                return yearNow - yearBirth;
            }
        }
    }

    public static Date getDateByUnixTime(int unixTime) {
        return new Date((long)unixTime * 1000L);
    }

    public static long getUnixTimeLong() {
        return (long)getUnixTimeByDate(new Date());
    }

    public static int getCurrentUnixTime() {
        return getUnixTimeByDate(new Date());
    }

    public static int getUnixTimeByDate(Date date) {
        return (int)(date.getTime() / 1000L);
    }

    public static long getUnixTimeLong(Date date) {
        return date.getTime() / 1000L;
    }

    public static Date getNextDay(Date date) {
        long time = date.getTime() / 1000L + 86400L;
        date.setTime(time * 1000L);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            date = format.parse(format.format(date));
        } catch (Exception var5) {
            System.out.println(var5.getMessage());
        }

        return date;
    }

    public static Date nextDay(Date date) {
        Date newDate = (Date)date.clone();
        long time = newDate.getTime() / 1000L + 86400L;
        newDate.setTime(time * 1000L);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            newDate = format.parse(format.format(newDate));
        } catch (Exception var6) {
            System.out.println(var6.getMessage());
        }

        return newDate;
    }

    public static Date getNowTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String dateStr = dateFormat(date);

        try {
            date = format.parse(dateStr);
        } catch (ParseException var4) {
            var4.printStackTrace();
        }

        return date;
    }

    public static Date getTomorrow(Date date1) {
        Calendar now = Calendar.getInstance();
        now.setTime(date1);
        now.add(5, 1);
        return now.getTime();
    }

    public static Date getWeekAgo(Date date) {
        Date newDate = (Date)date.clone();
        long time = newDate.getTime() / 1000L - 604800L;
        newDate.setTime(time * 1000L);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            newDate = format.parse(format.format(newDate));
        } catch (Exception var6) {
            System.out.println(var6.getMessage());
        }

        return newDate;
    }

    public static Date getDatebyTime(Date date, int n) {
        String str = dateFormat(date, "yyyy-MM-dd");
        String[] strs = StringUtils.split(str, "-");
        int month = Integer.parseInt(strs[1]);
        int monthnow = (month + n) % 12;
        int year = Integer.parseInt(strs[0]) + (month + n) / 12;
        str = year + "-" + monthnow + "-" + strs[2];
        return dateFormat(str, "yyyy-MM-dd");
    }

    public static Date yesterday(Date date) {
        Date newDate = (Date)date.clone();
        long time = newDate.getTime() / 1000L - 86400L;
        newDate.setTime(time * 1000L);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            newDate = format.parse(format.format(newDate));
        } catch (Exception var6) {
            System.out.println(var6.getMessage());
        }

        return newDate;
    }

    public static Date getYesterday(Date date) {
        long time = date.getTime() / 1000L - 86400L;
        date.setTime(time * 1000L);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            date = format.parse(format.format(date));
        } catch (Exception var5) {
            System.out.println(var5.getMessage());
        }

        return date;
    }

    public static String getStringNowTime() {
        Date date = new Date();
        String dateStr = dateFormat(date);
        return dateStr;
    }

    public static long getSpecifyTimeSec(long time, int range) {
        Date date = new Date((time * 1000L + 28800000L) / 86400000L * 86400000L - 28800000L);
        long zeroTime = date.getTime() / 1000L;
        long specifyTime = (long)(range * 24 * 3600);
        return zeroTime + specifyTime;
    }

    public static String formatDateByUnixTime(long unixTime, String dateFormat) {
        return dateFormat(new Date(unixTime * 1000L), dateFormat);
    }

    public static Date convertToDate(String input) {
        Date date = null;
        if(null == input) {
            return null;
        } else {
            Iterator var2 = dateFormats.iterator();

            while(var2.hasNext()) {
                SimpleDateFormat format = (SimpleDateFormat)var2.next();

                try {
                    format.setLenient(false);
                    date = format.parse(input);
                } catch (ParseException var5) {
                    ;
                }

                if(date != null) {
                    break;
                }
            }

            return date;
        }
    }

    public static Long getTodayTime() {
        Calendar today = Calendar.getInstance();
        today.set(11, 0);
        today.set(12, 0);
        today.set(13, 0);
        return Long.valueOf(String.valueOf(today.getTimeInMillis()).substring(0, 10));
    }

    public static Long getYesterdayTime() {
        Calendar today = Calendar.getInstance();
        today.set(11, -24);
        today.set(12, 0);
        today.set(13, 0);
        return Long.valueOf(String.valueOf(today.getTimeInMillis()).substring(0, 10));
    }

    public static Long getTomorrowTime() {
        Calendar tomorrow = Calendar.getInstance();
        tomorrow.set(11, 24);
        tomorrow.set(12, 0);
        tomorrow.set(13, 0);
        return Long.valueOf(String.valueOf(tomorrow.getTimeInMillis()).substring(0, 10));
    }

}
