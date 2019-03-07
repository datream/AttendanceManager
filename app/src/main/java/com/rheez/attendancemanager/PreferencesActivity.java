package com.rheez.attendancemanager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        setTitle(R.string.action_settings);

        NavigationView settingsView = findViewById(R.id.settings_view);
        settingsView.setNavigationItemSelectedListener(this::onNavigationItemSelected);
    }

    private boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.dialog_attendance_criteria:
                openDialog(id);
                break;

            case R.id.fragment_add_timetable:
                //TODO
                Toast.makeText(getApplication().getBaseContext(), "Feature not implemented yet", Toast.LENGTH_LONG).show();
                break;

            case R.id.fragment_add_attendance:
                //TODO
                Toast.makeText(getApplication().getBaseContext(), "Feature not implemented yet", Toast.LENGTH_LONG).show();
                break;

            case R.id.dialog_backup:
                openDialog(id);
                break;
        }

        return true;
    }

    private void openDialog(int id) {

        AlertDialog popDialog = new AlertDialog.Builder(this).create();

        if (id == R.id.dialog_attendance_criteria)
            popDialog.setTitle("Set Attendance Criteria");
        else if (id == R.id.dialog_backup)
            popDialog.setTitle("Backup and Restore");

        if (id == R.id.dialog_attendance_criteria) {
            //TODO
        }
        else if (id == R.id.dialog_backup) {
            //TODO
        }

        // Set Button
        // you can more buttons
        popDialog.setButton(AlertDialog.BUTTON_POSITIVE,"OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Perform Action on Button
            }
        });

        popDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"CANCEL", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Perform Action on Button
            }
        });

        new Dialog(getApplicationContext());
        popDialog.show();
    }
}
