package entities;

import java.util.ArrayList;

class Student {
    private String studentName;
    private int studentID;
    private ArrayList<Double> studentGrades;

    Student(String studentName, int studentID, ArrayList<Double> studentGrades) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.studentGrades = studentGrades;
    }

    String getStudentName() {
        return studentName;
    }

    void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    int getStudentID() {
        return studentID;
    }

    void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    ArrayList<Double> getStudentGrade() {
        return studentGrades;
    }

    void setStudentGrade(ArrayList<Double> studentGrades) {
        this.studentGrades = studentGrades;
    }
}