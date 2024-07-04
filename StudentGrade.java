import java.util.*;
class StudentGradeCalculator {
    public int[] marks;
    public int totalMarks;
    public double averagePercentage;
    public char grade;
    public StudentGradeCalculator(int numberOfSubjects) {
        this.marks = new int[numberOfSubjects];
        this.totalMarks = 0;
        this.averagePercentage = 0.0;
        this.grade = 'F';
    }
    public void inputMarks() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
    }
    public void calculateTotalMarks() {
        for (int mark : marks) {
            totalMarks += mark;
        }
    }
    public void calculateAveragePercentage() {
        averagePercentage = (double) totalMarks / marks.length;
    }
    public void calculateGrade() {
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }
    }
    public void displayResults() {
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);
    }
}
public class StudentGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();
        StudentGradeCalculator calculator = new StudentGradeCalculator(numberOfSubjects);
        calculator.inputMarks();
        calculator.calculateTotalMarks();
        calculator.calculateAveragePercentage();
        calculator.calculateGrade();
        calculator.displayResults();
    }
}