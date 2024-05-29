package com.example.scmanagement;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ActivitySeven extends AppCompatActivity {

    private TextView timeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven);

        timeTextView = findViewById(R.id.timeTextView);

        // Create a handler to update the time every second
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                updateTime();
                handler.postDelayed(this, 1000); // Update every 1 second
            }
        });
    }

    private void updateTime() {
        // Get the current time
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a", Locale.getDefault());
        String currentTime = dateFormat.format(new Date());

        // Update the TextView with the current time
        timeTextView.setText(currentTime);
    }
}
