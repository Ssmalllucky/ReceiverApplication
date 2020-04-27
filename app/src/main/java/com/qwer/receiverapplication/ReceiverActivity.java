package com.qwer.receiverapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ReceiverActivity extends AppCompatActivity implements Switch.OnCheckedChangeListener {

    public static final String KEY_SWITCH_STATUS = "key_switch_status";
    public static final String PREFERENCE_NAME = "receiver_settings";
    private Switch mSwReceiver;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_receiver);
        mSwReceiver = findViewById(R.id.sw_receiver);
        mSwReceiver.setOnCheckedChangeListener(this);

        mSharedPreferences = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSwReceiver.setChecked(getSettingsValue() == 1 ? true : false);
    }

    private void putSettingsValue(boolean isChecked) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(KEY_SWITCH_STATUS, isChecked ? 1 : 0);
        editor.apply();
    }

    private int getSettingsValue() {
        return mSharedPreferences.getInt(KEY_SWITCH_STATUS, 0);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        putSettingsValue(isChecked);
    }
}
