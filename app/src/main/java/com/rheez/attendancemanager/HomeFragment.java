package com.rheez.attendancemanager;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


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

        initializeData();
        initializeAdapter();
        return view;
    }

    private void initializeData(){
        subjects = new ArrayList<>();
        subjects.add(new Subject("ADC", 23, 30, 0, 0));
        subjects.add(new Subject("COA", 20, 30, 0, 0));
        subjects.add(new Subject("PL2", 25, 30, 0, 0));
        subjects.add(new Subject("CN", 23, 30, 0, 0));
        subjects.add(new Subject("PE", 21, 30, 0, 0));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(subjects);
        recyclerView.setAdapter(adapter);
    }
}
