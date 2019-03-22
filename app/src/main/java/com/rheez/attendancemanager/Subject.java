package com.rheez.attendancemanager;

class Subject {
    String subjectName;
    private int totalAttended;
    private int totalConducted;
    private int todayAttended;
    private int todayConducted;
    float percentage;

    Subject(String subjectName, int totalAttended, int totalConducted, int todayAttended, int todayConducted) {
        this.subjectName = subjectName;
        this.totalAttended = totalAttended;
        this.totalConducted = totalConducted;
        this.todayAttended = todayAttended;
        this.todayConducted = todayConducted;
        this.percentage = (float) totalAttended / todayConducted * 100;
    }

    int getBunksPossible(float attendanceCriteria) {
        int bunkCount = 0;
        while ((float) totalAttended / (todayConducted + bunkCount) * 100 >= attendanceCriteria) bunkCount++;
        return bunkCount;
    }

    int getLectureNeeded(float attendanceCriteria) {
        int lectureCount = 0;
        while ((float) (totalAttended + lectureCount) / (todayConducted + lectureCount) * 100 < attendanceCriteria) lectureCount++;
        return lectureCount;
    }
}