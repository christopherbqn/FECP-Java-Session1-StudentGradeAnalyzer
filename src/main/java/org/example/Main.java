package org.example;

// Main.java
import java.util.*;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int studentCount = Integer.parseInt(scanner.nextLine());

        // call processGrades method
        processGrades(studentCount, scanner);
    }

    public static void processGrades(int studentCount, Scanner scanner){

        List<String> topStudents = new ArrayList<>();
        int highestScore = -1;
        int totalScore = 0;

        // A, B, C, D, F
        int[] letterGrades = new int[5];

        // loop for each student
        for (int i = 0; i < studentCount; i++) {
            System.out.print("\nEnter name of student " + (i+1) + ": ");
            String name = scanner.nextLine();

            System.out.print("Enter score for " + name + ": ");
            int score = Integer.parseInt(scanner.nextLine());

            char grade;
            if (score >= 90) {
                grade = 'A';
                letterGrades[0]++;
            } else if (score >= 80) {
                grade = 'B';
                letterGrades[1]++;
            } else if (score >= 70) {
                grade = 'C';
                letterGrades[2]++;
            } else if (score >= 60) {
                grade = 'D';
                letterGrades[3]++;
            } else {
                grade = 'F';
                letterGrades[4]++;
            }

            System.out.println(name + " got grade: " + grade);
            totalScore += score;

            // store highest scoring student
            if (score > highestScore) {
                highestScore = score;
                topStudents.clear();
                topStudents.add(name);
            } else if (score == highestScore) {
                topStudents.add(name);
            }
        }

        // summary of grades
        double average = (double) totalScore / studentCount;
        System.out.println("\n------ Class Summary ------");
        System.out.printf("Average Score: %.2f%n", average);

        System.out.println("Grade Summary:");
        System.out.print("A:" + letterGrades[0]);
        System.out.print(" B:" + letterGrades[1]);
        System.out.print(" C:" + letterGrades[2]);
        System.out.print(" D:" + letterGrades[3]);
        System.out.print(" F:" + letterGrades[4]);

        // prints out topStudents arraylist
        System.out.print("\nTop Student(s): ");
        for (int i = 0; i < topStudents.size(); i++) {
            System.out.print(topStudents.get(i) + " (" + highestScore + ")");
            // if there are more than 1 student with the highest score
            if (i < topStudents.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}




