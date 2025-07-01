package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.print("Enter number of students: ");
        int noOfStudents = input.nextInt();
        input.nextLine();

        String[] studentNames = new String[noOfStudents];
        int[] studentScores = new int[noOfStudents];

        for (int i = 0; i < noOfStudents; i++) {
            String letterGrade;

            System.out.print("Enter name of student " + (i + 1) + ": ");
            String nameOfStudent = input.nextLine().trim();
            int scoreOfStudent;
            do {
                System.out.print("Enter score for " + nameOfStudent + ": ");
                while (!input.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a whole number.");
                    input.next();
                    System.out.print("Enter score for " + nameOfStudent + ": ");
                }
                scoreOfStudent = input.nextInt();
                if (scoreOfStudent < 0 || scoreOfStudent > 100) {
                    System.out.println("Invalid score. Please enter a value between 0 and 100.");
                }
            } while (scoreOfStudent < 0 || scoreOfStudent > 100);
            input.nextLine();

            studentNames[i] = nameOfStudent;
            studentScores[i] = scoreOfStudent;

            if (scoreOfStudent >= 90) {
                letterGrade = "A";
            } else if (scoreOfStudent >= 80) {
                letterGrade = "B";
            } else if (scoreOfStudent >= 70) {
                letterGrade = "C";
            } else if (scoreOfStudent >= 60) {
                letterGrade = "D";
            } else {
                letterGrade = "F";
            }
            System.out.println(nameOfStudent + " got grade: " + letterGrade);
        }

        double totalScore = 0;
        int highestScore = -1;
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        for (int i = 0; i < noOfStudents; i++) {
            int score = studentScores[i];
            totalScore += score;

            if (score > highestScore) {
                highestScore = score;
            }
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }

        List<String> topStudents = new ArrayList<>();
        for (int i = 0; i < noOfStudents; i++) {
            if (studentScores[i] == highestScore) {
                topStudents.add(studentNames[i]);
            }
        }

        double averageScore = totalScore / noOfStudents;

        System.out.println("\n----- Class Summary -----");
        System.out.printf("Average Score: %.2f\n", averageScore);
        System.out.println("Grade Counts: A:" + countA + " B:" + countB + " C:" + countC + " D:" + countD + " F:" + countF);
        String topStudentStr = String.join(", ", topStudents);
        System.out.println("Top Student(s): " + topStudentStr + " (" + highestScore + ")");
    }
}