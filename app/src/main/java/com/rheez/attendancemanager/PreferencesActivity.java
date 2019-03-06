package com.rheez.attendancemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        setTitle(R.string.action_settings);

    }
}
