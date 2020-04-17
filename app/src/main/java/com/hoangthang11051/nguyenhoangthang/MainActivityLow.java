package com.hoangthang11051.nguyenhoangthang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivityLow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Intent it = getIntent();
        TextView tv = findViewById(R.id.tv_minname);
        tv.setText(it.getStringExtra("min"));
    }
}
