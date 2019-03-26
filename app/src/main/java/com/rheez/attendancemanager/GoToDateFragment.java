package com.rheez.attendancemanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;


/**
 * A simple {@link GoToDateFragment} subclass.
 */
public class GoToDateFragment extends Fragment {
    private Button b;
    DatePicker dp;

    public GoToDateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_go_to_date, container, false);
    }

    private void date() {
        b = getActivity().findViewById(R.id.button);
        dp = getActivity().findViewById(R.id.datePicker);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), dp.getDayOfMonth() + "-" + (dp.getMonth() + 1) + "-" + dp.getYear(), Toast.LENGTH_LONG).show();
            }
        });

    }
}