package com.example.scmanagement; // Ensure this matches your build.gradle namespace

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityOne extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName, editWorkTime, editDate, editPayment, editId;
    Button btnAddData, btnViewAll, btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        myDb = new DatabaseHelper(this);

        editName = findViewById(R.id.editTextName);
        editWorkTime = findViewById(R.id.editTextWorkTime);
        editDate = findViewById(R.id.editTextDate);
        editPayment = findViewById(R.id.editTextPayment);
        editId = findViewById(R.id.editTextId);


        btnAddData = findViewById(R.id.buttonAdd);
        btnViewAll = findViewById(R.id.buttonViewAll);
        btnUpdate = findViewById(R.id.buttonUpdate);
        btnDelete = findViewById(R.id.buttonDelete);

        addData();
        viewAll();
        updateData();
        deleteData();
    }

    public void addData() {
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String name = editName.getText().toString();
                    String workTime = editWorkTime.getText().toString();
                    String date = editDate.getText().toString();
                    double payment = Double.parseDouble(editPayment.getText().toString());

                    boolean isInserted = myDb.insertData(name, workTime, date, payment);
                    if (isInserted) {
                        Toast.makeText(ActivityOne.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ActivityOne.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(ActivityOne.this, "Invalid payment amount", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void viewAll() {
        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount() == 0) {
                    showMessage("Error", "No data found");
                    return;
                }

                StringBuilder buffer = new StringBuilder();
                while (res.moveToNext()) {
                    buffer.append("Id :").append(res.getString(0)).append("\n");
                    buffer.append("Name :").append(res.getString(1)).append("\n");
                    buffer.append("Work Time :").append(res.getString(2)).append("\n");
                    buffer.append("Date :").append(res.getString(3)).append("\n");
                    buffer.append("Payment :").append(res.getString(4)).append("\n\n");
                }
                showMessage("Data", buffer.toString());
                res.close(); // Close the cursor
            }
        });
    }

    public void updateData() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String id = editId.getText().toString();
                    String name = editName.getText().toString();
                    String workTime = editWorkTime.getText().toString();
                    String date = editDate.getText().toString();
                    double payment = Double.parseDouble(editPayment.getText().toString());

                    boolean isUpdate = myDb.updateData(id, name, workTime, date, payment);
                    if (isUpdate) {
                        Toast.makeText(ActivityOne.this, "Data Updated", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ActivityOne.this, "Data not Updated", Toast.LENGTH_LONG).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(ActivityOne.this, "Invalid payment amount", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void deleteData() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editId.getText().toString();
                Integer deletedRows = myDb.deleteData(id);
                if (deletedRows > 0) {
                    Toast.makeText(ActivityOne.this, "Data Deleted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ActivityOne.this, "Data not Deleted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
