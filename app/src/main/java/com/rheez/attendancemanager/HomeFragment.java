package com.rheez.attendancemanager;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link HomeFragment} subclass.
 */
public class HomeFragment extends Fragment {

    private List<Subject> subjects;
    private RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView= view.findViewById(R.id.rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
        return view;
    }

    private void initializeData(){
        subjects = new ArrayList<>();
        subjects.add(new Subject("ADC", 23, 30, 0, 0));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(subjects);
        recyclerView.setAdapter(adapter);
    }
}
