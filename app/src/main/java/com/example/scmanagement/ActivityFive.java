package com.example.scmanagement;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityFive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        // List of construction jobs
        String[] jobs = {
                "Bricklayer",
                "Carpenter",
                "Electrician",
                "Plumber",
                "Roofer",
                "Welder",
                "Painter",
                "Concrete Worker",
                "Site Supervisor",
                "Crane Operator"
        };

        // Get the ListView from the layout
        ListView jobListView = findViewById(R.id.jobListView);

        // Create an ArrayAdapter using the job list and a default list item layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, jobs);

        // Set the adapter to the ListView
        jobListView.setAdapter(adapter);
    }
}
