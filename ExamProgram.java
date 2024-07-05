import java.util.Scanner;

public class ExamProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. View coursework results");
            System.out.println("2. View exam results");
            System.out.println("3. Exit the program");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewCourseworkResults(scanner);
                    break;
                case 2:
                    int count = countCourseworkAssessments(scanner);
                    if (!checkCourseworkCompletion(count)) {
                        System.out.println("You need to repeat the coursework.");
                    } else {
                        double totalScore = calculateTotalScore(scanner);
                        viewExamResults(totalScore);
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static int countCourseworkAssessments(Scanner scanner) {
        int count = 0;
        String[] assessments = {"ass1", "ass2", "ass3", "cat1", "cat2"};
        for (String assessment : assessments) {
            System.out.print("Have you done " + assessment + "? (y/n): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("y")) {
                count++;
            }
        }
        return count;
    }

    private static boolean checkCourseworkCompletion(int count) {
        int requiredCount = (int) Math.ceil(2.0 / 3 * 5);
        return count >= requiredCount;
    }

    private static double calculateTotalScore(Scanner scanner) {
        double courseworkScore = 0;
        String[] assessments = {"ass1", "ass2", "ass3", "cat1", "cat2"};
        for (String assessment : assessments) {
            System.out.print("Enter score for " + assessment + ": ");
            double score = scanner.nextDouble();
            courseworkScore += score;
        }
        courseworkScore /= 2; // 50% of total score
        System.out.print("Enter final exam score: ");
        double finalExamScore = scanner.nextDouble();
        finalExamScore /= 2; // 50% of total score
        return courseworkScore + finalExamScore;
    }

    private static void viewCourseworkResults(Scanner scanner) {
        System.out.println("Coursework Results:");
        String[] assessments = {"ass1", "ass2", "ass3", "cat1", "cat2"};
        for (String assessment : assessments) {
            System.out.print("Enter score for " + assessment + ": ");
            double score = scanner.nextDouble();
            System.out.println(assessment + ": " + score);
        }
    }

    private static void viewExamResults(double totalScore) {
        System.out.printf("Total Score: %.2f%n", totalScore);
    }
}