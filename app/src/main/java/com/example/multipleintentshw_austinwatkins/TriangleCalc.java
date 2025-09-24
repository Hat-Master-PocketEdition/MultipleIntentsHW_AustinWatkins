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

public class TriangleCalc extends AppCompatActivity {

    Button TR_back;
    EditText base;
    EditText side1;
    EditText side2;
    EditText height;
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_triangle_calc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TR_back = findViewById(R.id.triangle_back_button);
        base = findViewById(R.id.TriangleInputBase);
        side1 = findViewById(R.id.TriangleInputSideOne);
        side2 = findViewById(R.id.TriangleInputSideTwo);
        height = findViewById(R.id.TriangleInputHeight);
        output = findViewById(R.id.TriangleOutput);
        setOnClickListenerBack();
        textChangeListener();
    }
    public void setOnClickListenerBack()
    {
        TR_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void textChangeListener()
    {
        base.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setText(base.getText().toString(), side1.getText().toString(), side2.getText().toString(), height.getText().toString());
            }
        });
        side1.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setText(base.getText().toString(), side1.getText().toString(), side2.getText().toString(), height.getText().toString());
            }
        });
        side2.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setText(base.getText().toString(), side1.getText().toString(), side2.getText().toString(), height.getText().toString());
            }
        });
        height.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setText(base.getText().toString(), side1.getText().toString(), side2.getText().toString(), height.getText().toString());
            }
        });
    }
    public void setText(String w, String x, String y, String z)
    {
        if(w.isEmpty() || x.isEmpty() || y.isEmpty() || z.isEmpty())
        {
            return;
        }
        double outBase = Double.parseDouble(x);
        double outSide1 = Double.parseDouble(x);
        double outSide2 = Double.parseDouble(y);
        double outHeight = Double.parseDouble(z);

        double perimeter = outBase + outSide1 + outSide2;
        double area = outBase + outHeight * 0.5;

        output.setText("AREA = " + area + "\nPERIMETER = " + perimeter);
    }
}