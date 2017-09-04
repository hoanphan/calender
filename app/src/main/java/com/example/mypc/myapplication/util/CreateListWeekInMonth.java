package com.example.mypc.myapplication.util;

import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by MyPC on 04/09/2017.
 */

public class CreateListWeekInMonth {
    private List<Month> months;
    List<Week> weeks = new ArrayList<>();

    public CreateListWeekInMonth(List<Month> months) {
        this.months = months;

    }

    public List<Week> create() {
        List<Week> weeks1=new ArrayList<>();
        int index=0;
        int start=months.get(index).startDay.getDate();
        int end=months.get(index).endDay.getDate();
        Week week=new Week();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(months.get(index).startDay);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if(day!=Calendar.SUNDAY) {
            for (int i = 0; i < 7; i++) {

                if (day == Calendar.SUNDAY) {

                }
                if (day == Calendar.SATURDAY)
                    week.Sat = calendar.getTime().getDate();
                calendar.add(Calendar.DAY_OF_YEAR, 1);
            }
        }
        return weeks1;
    }


}
