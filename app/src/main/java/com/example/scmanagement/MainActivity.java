package com.example.scmanagement;

import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        // Set Event
        setSingleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainGrid) {
        // Loop all child items of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            // You can see, all child items are CardView, so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        // Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(MainActivity.this, "State : True", Toast.LENGTH_SHORT).show();
                    } else {
                        // Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(MainActivity.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvent(GridLayout mainGrid) {
        // Loop all child items of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            // You can see, all child items are CardView, so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent;
                    switch (finalI) {
                        case 0:
                            intent = new Intent(MainActivity.this, ActivityOne.class);
                            break;
                        case 1:
                            intent = new Intent(MainActivity.this, ActivityTwo.class);
                            break;
                        case 2:
                            intent = new Intent(MainActivity.this, ActivityThree.class);
                            break;

                        case 3:
                            intent = new Intent(MainActivity.this, ActivityFour.class);
                            break;

                        case 4:
                            intent = new Intent(MainActivity.this, ActivityFive.class);
                            break;

                        case 5:
                            intent = new Intent(MainActivity.this, ActivitySix.class);
                            break;

                        case 6:
                            intent = new Intent(MainActivity.this, ActivitySeven.class);
                            break;
                        default:
                            intent = new Intent(MainActivity.this, MainActivity.class);
                            break;
                    }
                    intent.putExtra("info", "This is activity from card item index " + finalI);
                    startActivity(intent);
                }
            });
        }
    }
}
