package com.rheez.attendancemanager;

import java.util.List;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.AttendanceViewHolder> {

    static class AttendanceViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView subjectName;
        TextView notice;
        TextView percentage;
        Button attended;
        Button bunked;

        AttendanceViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            subjectName = itemView.findViewById(R.id.subject_name);
            notice = itemView.findViewById(R.id.notice);
            percentage = itemView.findViewById(R.id.percentage);

            attended = itemView.findViewById(R.id.attended);
            bunked = itemView.findViewById(R.id.bunked);
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
        attendanceViewHolder.subjectName.setText(subjects.get(i).subjectName);
        updateAttendanceDisplay(attendanceViewHolder, i);
        attendanceViewHolder.attended.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subjects.get(i).attendedToday();
                updateAttendanceDisplay(attendanceViewHolder, i);
                Toast.makeText(view.getContext(), "Hello " +subjects.get(i).percentage, Toast.LENGTH_LONG).show();

            }
        });
        attendanceViewHolder.bunked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subjects.get(i).bunkedToday();;
                updateAttendanceDisplay(attendanceViewHolder, i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    private void updateAttendanceDisplay(@NonNull AttendanceViewHolder attendanceViewHolder, int i) {
        float attendanceCriteria = 80;

        String noticePlaceHolder = null;
        if (subjects.get(i).percentage < attendanceCriteria) {
            noticePlaceHolder = "Attend next " + subjects.get(i).getLectureNeeded(attendanceCriteria) + " lectures";
            attendanceViewHolder.notice.setTextColor(Color.RED);
            attendanceViewHolder.percentage.setTextColor(Color.RED);
        }
        else if (subjects.get(i).percentage >= attendanceCriteria) {
            noticePlaceHolder = "You can bunk next " + subjects.get(i).getBunksPossible(attendanceCriteria) + " lectures";
            attendanceViewHolder.notice.setTextColor(Color.GREEN);
            attendanceViewHolder.percentage.setTextColor(Color.GREEN);
        }
        attendanceViewHolder.notice.setText(noticePlaceHolder);
        attendanceViewHolder.percentage.setText(Float.toString(subjects.get(i).percentage));
    }
}