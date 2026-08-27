package se.systementor.hmsax.lektion3.ovningsuppgifter;

import java.util.Scanner;

public class G5PointsToGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange poäng: ");
        int score = scanner.nextInt();

        char grade;
        if (score >= 90) {
            grade = 'A';
        } else if (score >= 75) {
            grade = 'B';
        } else if (score >= 60) {
            grade = 'C';
        } else if (score >= 50) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("Betyg: " + grade);

        scanner.close();
    }
}
