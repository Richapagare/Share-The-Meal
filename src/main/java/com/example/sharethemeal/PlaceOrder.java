package com.example.sharethemeal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PlaceOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView=new TextView(this);
        textView.setText("Thankyou for ordering ! Your pickup time slot is :");
        textView.setTextSize(48);
        textView.setTextColor(17170444);
        setContentView(textView);
      /*  setContentView(R.layout.activity_place_order);
        Calendar calendar=Calendar.getInstance();
        String currentDate=DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        textView.setText(currentDate);*/

    }



}