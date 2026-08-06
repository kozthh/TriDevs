package entities;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student ID: ");
        int id = sc.nextInt();

        System.out.print("Enter number of grades: ");
        int numGrades = sc.nextInt();

        ArrayList<Double> grades = new ArrayList<>();
        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades.add(sc.nextDouble());
        }

        Student student = new Student(name, id, grades);
        GradeCalculator calculator = new GradeCalculator(student);
        calculator.calculateAverage();
        sc.close();
    }
}