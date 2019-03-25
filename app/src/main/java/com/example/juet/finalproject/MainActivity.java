package com.example.juet.finalproject;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import java.sql.Date;

public class MainActivity extends AppCompatActivity {

    private Button btnSubmit = null;
    private CalendarView calendar = null;
    private String selectedDate = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        calendar = (CalendarView)findViewById(R.id.calendarView);

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/YYYY");
        selectedDate = sdf.format(calendar.getDate());

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("Date", selectedDate);
                startActivity(intent);
            }
        });

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                selectedDate = month + 1 + "/" + dayOfMonth + "/" + year;

            }
        });


    }

}
