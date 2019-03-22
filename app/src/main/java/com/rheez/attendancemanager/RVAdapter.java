package com.rheez.attendancemanager;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.AttendanceViewHolder> {

    static class AttendanceViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView subjectName;
        TextView notice;
        TextView percentage;

        AttendanceViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            subjectName = itemView.findViewById(R.id.subject_name);
            notice = itemView.findViewById(R.id.notice);
            percentage = itemView.findViewById(R.id.percentage);
        }
    }

    private List<Subject> subjects;

    RVAdapter(List<Subject> subjects){
        this.subjects = subjects;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override @NonNull
    public AttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new AttendanceViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AttendanceViewHolder attendanceViewHolder, int i) {
        float attendanceCriteria = 80;
        attendanceViewHolder.subjectName.setText(subjects.get(i).subjectName);

        String noticePlaceHolder = "";
        if (subjects.get(i).percentage < attendanceCriteria) {
            noticePlaceHolder += "Attend next " + subjects.get(i).getLectureNeeded(attendanceCriteria) + " lectures";
            attendanceViewHolder.notice.setTextColor(Color.RED);
            attendanceViewHolder.percentage.setTextColor(Color.RED);
        }
        else if (subjects.get(i).percentage >= attendanceCriteria) {
            noticePlaceHolder += "You can bunk next " + subjects.get(i).getBunksPossible(attendanceCriteria) + " lectures";
            attendanceViewHolder.notice.setTextColor(Color.GREEN);
            attendanceViewHolder.percentage.setTextColor(Color.GREEN);
        }
        attendanceViewHolder.notice.setText(noticePlaceHolder);
        attendanceViewHolder.percentage.setText(String.format(Locale.US,"%.2f", subjects.get(i).percentage));
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }
}