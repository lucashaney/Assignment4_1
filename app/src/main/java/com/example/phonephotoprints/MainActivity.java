package com.example.phonephotoprints;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    int printsEntered;
    double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText prints = (EditText) findViewById(R.id.txtPrints);
        final RadioButton fourXSix = (RadioButton) findViewById(R.id.rad4x6);
        final RadioButton fiveXSeven = (RadioButton) findViewById(R.id.rad5x7);
        final RadioButton eightXTen = (RadioButton) findViewById(R.id.rad8x10);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button convert = (Button) findViewById(R.id.btnOrder);

        convert.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View v) {
                printsEntered = Integer.parseInt(prints.getText().toString());
                if(printsEntered <= 50) {
                    if(fourXSix.isChecked()) {
                        total = printsEntered * 0.19;
                        result.setText("The order cost is $" + String.format("%.2f", total));
                    }
                    if(fiveXSeven.isChecked()) {
                        total = printsEntered * 0.49;
                        result.setText("The order cost is $" + String.format("%.2f", total));
                    }
                    if(eightXTen.isChecked()) {
                        total = printsEntered * 0.79;
                        result.setText("The order cost is $" + String.format("%.2f", total));
                    }
                } else {
                    Toast.makeText(MainActivity.this,"Prints must be less than 50", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
