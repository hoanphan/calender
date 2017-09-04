package com.example.mypc.myapplication.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by MyPC on 04/09/2017.
 */

public class getDayInMonth {
    public static List<Date> startDate=new ArrayList<>();
    public static List<Date> endDay=new ArrayList<>();
    static List<Month> months=new ArrayList<>();
    public static List<Month>  getStart()
    {
        Calendar cal =Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);;
        cal.set(Calendar.DAY_OF_MONTH, 1);
        startDate.add(cal.getTime());
        endDay.add(EndDay(cal.getTime()));
        for(int i=1;i<=11;i++)
        {
            cal.add(Calendar.MONTH,1);
            startDate.add(cal.getTime());
            endDay.add(EndDay(cal.getTime()));
        }
        for (int i=0;i<startDate.size();i++)
        {
            Month month=new Month();
            month.startDay=startDate.get(i);
            month.endDay = endDay.get(i);
            months.add(month);
        }
        return  months;
    }

    public  static Date EndDay(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);

        return calendar.getTime();
    }
}
