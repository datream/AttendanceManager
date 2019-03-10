package com.rheez.attendancemanager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

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
            DiscreteSeekBar seekBar = new DiscreteSeekBar(this);
            seekBar.setMax(100);
            popDialog.setView(seekBar);



            seekBar.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
                @Override
                public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {}

                @Override
                public void onStartTrackingTouch(DiscreteSeekBar seekBar) {}

                @Override
                public void onStopTrackingTouch(DiscreteSeekBar seekBar) {}
            });
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

    private void displayFragment(@NonNull Fragment navFragment) {
        supportInvalidateOptionsMenu();
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.content_frame, navFragment)
                .commitNow();
    }
}
