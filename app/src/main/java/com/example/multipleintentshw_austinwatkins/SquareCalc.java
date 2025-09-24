package com.example.multipleintentshw_austinwatkins;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SquareCalc extends AppCompatActivity {

    Button SQ_back;
    EditText side;
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_square_calc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SQ_back = findViewById(R.id.square_back_button);
        output = findViewById(R.id.SquareOutput);
        side = findViewById(R.id.SquareInputOne);
        setOnClickListenerBack();
        textChangeListener();
    }
    public void setOnClickListenerBack()
    {
        SQ_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void textChangeListener()
    {
        side.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setText(side.getText().toString());
            }
        });
    }
    public void setText(String x)
    {
        if(x.isEmpty())
        {
            return;
        }
        double y = Double.parseDouble(x);

        double area = y * y;

        double perimeter = y * 4;

        output.setText("AREA = " + area + "\nPERIMETER = " + perimeter);
    }
}