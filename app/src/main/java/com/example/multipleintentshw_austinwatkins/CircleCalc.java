package com.example.multipleintentshw_austinwatkins;

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

public class CircleCalc extends AppCompatActivity {
    Button CR_back;
    EditText radius;
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_circle_calc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        CR_back = findViewById(R.id.circle_back_button);
        output = findViewById(R.id.CircleOutput);
        radius = findViewById(R.id.CircleInputRadius);
        setOnClickListenerBack();
        textChangeListener();
    }
    public void setOnClickListenerBack()
    {
        CR_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void textChangeListener()
    {
        radius.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setText(radius.getText().toString());
            }
        });
    }
    public void setText(String x)
    {
        if(x.isEmpty())
        {
            return;
        }
        double radius = Double.parseDouble(x);
        double pi = Math.PI;

        double area = pi * Math.pow(radius, 2);

        double perimeter = 2 * pi * radius;

        output.setText("AREA = " + area + "\nPERIMETER = " + perimeter);
    }
}