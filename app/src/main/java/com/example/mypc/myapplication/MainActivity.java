package com.example.mypc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.mypc.myapplication.util.CreateListWeekInMonth;
import com.example.mypc.myapplication.util.DividerItemDecoration;
import com.example.mypc.myapplication.util.Month;
import com.example.mypc.myapplication.util.Week;
import com.example.mypc.myapplication.util.getDayInMonth;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Month> dates = getDayInMonth.getStart();
        rvCalendar= (RecyclerView) findViewById(R.id.rc_calendar);
        CreateListWeekInMonth createListWeekInMonth = new CreateListWeekInMonth(dates);
        List<Week> weeks=createListWeekInMonth.create();
        rvCalendar.setHasFixedSize(true);
        rvCalendar.setLayoutManager(new LinearLayoutManager(this));
        //vCalendar.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        AddapterMonth addapterMonth= new AddapterMonth(weeks,this);
        rvCalendar.setAdapter(addapterMonth);
    }
}
