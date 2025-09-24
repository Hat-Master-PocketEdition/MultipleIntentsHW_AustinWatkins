package com.example.multipleintentshw_austinwatkins;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //for some reason, when i named the "return to main page" button in my square calculation activity
    //it changed "ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)" from "main" to the name of my button
    //when you push any button, it causes the entire app to crash. renaming it to "main" doesn't work
    //i had to start from completely from scratch
    //i know this is true because i have literally copy pasted everything from the last project into this one

    //i have learned not to tempt the machine spirits. they feed on your fear just as much as electricity

    Button squareButton;
    Button triangleButton;
    Button circleButton;
    Button rectangleButton;
    Intent SquareAct;
    Intent RectangleAct;
    Intent CircleAct;
    Intent TriangleAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SquareAct = new Intent(MainActivity.this, SquareCalc.class);
        CircleAct = new Intent(MainActivity.this, CircleCalc.class);
        RectangleAct = new Intent(MainActivity.this, RectangleCalc.class);
        TriangleAct = new Intent(MainActivity.this, TriangleCalc.class);
        squareButton = findViewById(R.id.sq_button);
        triangleButton = findViewById(R.id.tr_button);
        circleButton = findViewById(R.id.cr_button);
        rectangleButton = findViewById(R.id.rc_button);

        setOnClickListenerSquare();
        setOnClickListenerCircle();
        setOnClickListenerRectangle();
        setOnClickListenerTriangle();

    }
    public void setOnClickListenerSquare()
    {
        squareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(SquareAct);
            }
        });
    }
    public void setOnClickListenerCircle()
    {
        circleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(CircleAct);
            }
        });
    }
    public void setOnClickListenerTriangle()
    {
        triangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(TriangleAct);
            }
        });
    }
    //test
    public void setOnClickListenerRectangle()
    {
        rectangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(RectangleAct);
            }
        });
    }
}