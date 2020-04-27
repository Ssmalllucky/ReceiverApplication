package com.qwer.receiverapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Settings.System.getInt(getContentResolver(),"",0);

    }
}
