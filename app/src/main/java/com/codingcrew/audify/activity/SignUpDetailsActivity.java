package com.codingcrew.audify.activity;

import android.os.Bundle;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

import com.codingcrew.audify.R;

import java.util.Date;

public class SignUpDetailsActivity extends AppCompatActivity {

    NumberPicker yearPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_details);

        yearPicker = findViewById(R.id.yearPicker);
        Date d = new Date();
        int year = d.getYear();
        yearPicker.setMinValue(year - 100);
        yearPicker.setMaxValue(year - 10);
        yearPicker.setValue(year - 30);

    }
}