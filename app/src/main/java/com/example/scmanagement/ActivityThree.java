package com.example.scmanagement;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        CalendarView calendarView = findViewById(R.id.calendarView);

        // Set date change listener
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // Display the selected date
                Toast.makeText(getApplicationContext(), "Selected Date: " + (month + 1) + "/" + dayOfMonth + "/" + year, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
