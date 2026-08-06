package entities;

class GradeCalculator {
    private final Student student;

    GradeCalculator(Student student) {
        this.student = student;
    }

    void calculateAverage() {
        double sum = 0;

        for (double grade : student.getStudentGrade()) {
            sum += grade;
        }

        if (student.getStudentGrade().isEmpty()) {
            System.out.println("Average Grade: N/A");
            return;
        }

        double average = sum / student.getStudentGrade().size();
        System.out.println("Average Grade: " + average);
    }
}