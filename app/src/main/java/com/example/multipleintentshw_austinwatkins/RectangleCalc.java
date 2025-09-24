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

public class RectangleCalc extends AppCompatActivity {

    Button RC_back;
    EditText length;
    EditText width;
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rectangle_calc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RC_back = findViewById(R.id.rect_back_button);
        length = findViewById(R.id.RectangleInputLength);
        width = findViewById(R.id.RectangleInputWidth);
        output = findViewById(R.id.RectangleOutput);
        setOnClickListenerBack();
        textChangeListener();
    }
    public void setOnClickListenerBack()
    {
        RC_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void textChangeListener()
    {
        length.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setText(length.getText().toString(), width.getText().toString());
            }
        });
        width.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setText(length.getText().toString(), width.getText().toString());
            }
        });
    }
    public void setText(String LS, String WS)
    {
        if (LS.isEmpty() || WS.isEmpty())
        {
            return;
        }

        double outL = Double.parseDouble(LS);
        double outW = Double.parseDouble(WS);

        double perimeter = (outL * 2) + (outW * 2);
        double area = outL * outW;

        output.setText("AREA = " + area + "\nPERIMETER = " + perimeter);

    }
}