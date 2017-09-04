package com.example.mypc.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mypc.myapplication.util.Month;
import com.example.mypc.myapplication.util.Week;

import java.util.List;


/**
 * Created by MyPC on 04/09/2017.
 */

public class AddapterMonth extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<Week> weeks;
    public Context context;

    public AddapterMonth(List<Week> weeks, Context context) {
        this.weeks = weeks;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return weeks.get(position).end;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType!=0) {
            View v = LayoutInflater.from(context).inflate(R.layout.item_week, parent, false);
            return new ViewWeek(v);
        }
        else
        {
            View v=LayoutInflater.from(context).inflate(R.layout.item_week_month,parent,false);
            return new ViewMonth(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder.getItemViewType()!=0) {
            ViewWeek viewWeek= (ViewWeek) holder;
            Week week = weeks.get(position);
            viewWeek.tvH.setText(String.valueOf(week.Mon));
            viewWeek.tvB.setText(String.valueOf(week.Tue));
            viewWeek.tvT.setText(String.valueOf(week.Wed));
            viewWeek.tvN.setText(String.valueOf(week.Thur));
            viewWeek.tvS.setText(String.valueOf(week.Frid));
            viewWeek.tvBay.setText(String.valueOf(week.Sat));
            viewWeek.tvCN.setText(String.valueOf(week.Sun));
        }
        else
        {
            ViewMonth viewWeek= (ViewMonth) holder;
            Week week = weeks.get(position);
            viewWeek.tvMonth.setText((week.nameMonth+1)+" - "+week.nameYear);
            viewWeek.tvH.setText(String.valueOf(week.Mon));
            viewWeek.tvB.setText(String.valueOf(week.Tue));
            viewWeek.tvT.setText(String.valueOf(week.Wed));
            viewWeek.tvN.setText(String.valueOf(week.Thur));
            viewWeek.tvS.setText(String.valueOf(week.Frid));
            viewWeek.tvBay.setText(String.valueOf(week.Sat));
            viewWeek.tvCN.setText(String.valueOf(week.Sun));
        }
    }


    @Override
    public int getItemCount() {
        return weeks.size();
    }


    public class ViewWeek extends RecyclerView.ViewHolder {
        public TextView tvH;
        public TextView tvB;
        public TextView tvT;
        public TextView tvN;
        public TextView tvS;
        public TextView tvBay;
        public TextView tvCN;

        public ViewWeek(View itemView) {
            super(itemView);
            tvH = (TextView) itemView.findViewById(R.id.tv_h);
            tvB = (TextView) itemView.findViewById(R.id.tv_b);
            tvT = (TextView) itemView.findViewById(R.id.tv_t);
            tvN = (TextView) itemView.findViewById(R.id.tv_n);
            tvBay = (TextView) itemView.findViewById(R.id.tv_bay);
            tvS = (TextView) itemView.findViewById(R.id.tv_s);
            tvCN = (TextView) itemView.findViewById(R.id.tv_cn);
        }
    }
    public class ViewMonth extends RecyclerView.ViewHolder{
        public TextView tvH;
        public TextView tvB;
        public TextView tvT;
        public TextView tvN;
        public TextView tvS;
        public TextView tvBay;
        public TextView tvCN;
        public TextView tvMonth;
        public ViewMonth(View itemView) {
            super(itemView);
            tvH = (TextView) itemView.findViewById(R.id.tv_h);
            tvB = (TextView) itemView.findViewById(R.id.tv_b);
            tvT = (TextView) itemView.findViewById(R.id.tv_t);
            tvN = (TextView) itemView.findViewById(R.id.tv_n);
            tvBay = (TextView) itemView.findViewById(R.id.tv_bay);
            tvS = (TextView) itemView.findViewById(R.id.tv_s);
            tvCN = (TextView) itemView.findViewById(R.id.tv_cn);
            tvMonth = (TextView) itemView.findViewById(R.id.lbl_month);
        }
    }
}
