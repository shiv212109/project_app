package com.example.scmanagement;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTwo extends AppCompatActivity {

    private EditText widthInput;
    private EditText heightInput;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        widthInput = findViewById(R.id.widthInput);
        heightInput = findViewById(R.id.heightInput);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateArea();
            }
        });
    }

    private void calculateArea() {
        String widthStr = widthInput.getText().toString();
        String heightStr = heightInput.getText().toString();

        if (widthStr.isEmpty() || heightStr.isEmpty()) {
            Toast.makeText(this, "Please enter both width and height", Toast.LENGTH_SHORT).show();
            return;
        }

        double width = Double.parseDouble(widthStr);
        double height = Double.parseDouble(heightStr);
        double area = width * height;

        resultTextView.setText("Area: " + area);
    }
}
