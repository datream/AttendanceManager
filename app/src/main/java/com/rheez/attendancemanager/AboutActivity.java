package com.rheez.attendancemanager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;


public class AboutActivity extends AppCompatActivity {

    private static final String GITHUB_URI = "https://github.com/datream/AttendanceManager";
    private static final String CHANGELOG_URI = GITHUB_URI + "/blob/master/CHANGELOG.md";
    private static final String GNU_URI = GITHUB_URI + "/blob/master/LICENSE.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        setTitle(R.string.about_activity_title);


        LinearLayout license = findViewById(R.id.about_layout_license);
        license.setOnClickListener((View v) -> openURI(GNU_URI));

        LinearLayout source = findViewById(R.id.about_layout_source);
        source.setOnClickListener((View v) -> openURI(GITHUB_URI));

        LinearLayout changelog = findViewById(R.id.about_layout_changelog);
        changelog.setOnClickListener((View v) -> openURI(CHANGELOG_URI));

    }

    private void openURI(String uri) {
        Intent openURI = new Intent(Intent.ACTION_VIEW);
        openURI.setData(Uri.parse(uri));
        startActivity(openURI);
    }
}
