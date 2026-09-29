import java.util.Scanner;

public class Question4 {

    static abstract class Question {
        protected String questionText;
        protected String correctAnswer;
        protected String studentAnswer;
        protected double points;

        Question(String questionText, String correctAnswer,
                 String studentAnswer, double points) {
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        abstract double grade();
    }

    static class MCQ extends Question {

        MCQ(String questionText, String correctAnswer,
            String studentAnswer, double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        double grade() {
            if (studentAnswer.equals(correctAnswer)) {
                return points;
            }

            return 0;
        }
    }

    static class TF extends Question {

        TF(String questionText, String correctAnswer,
           String studentAnswer, double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        double grade() {
            if (studentAnswer.equals(correctAnswer)) {
                return points;
            }

            return 0;
        }
    }

    static class Essay extends Question {

        Essay(String questionText, String correctAnswer,
              String studentAnswer, double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        double grade() {

            String[] keywords = correctAnswer.split(",");
            String answer = studentAnswer.toLowerCase();

            int found = 0;

            for (int i = 0; i < keywords.length; i++) {

                String keyword = keywords[i].trim().toLowerCase();

                if (answer.contains(keyword)) {
                    found++;
                }
            }

            if (found >= 2) {
                return points * 0.75;
            } else if (found == 1) {
                return points * 0.50;
            }

            return 0;
        }
    }

    static String[] parseLine(String line) {

        return line.trim().split("\"\\s+\"|\\s+(?=\")|(?<=\")\\s+");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double totalScore = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts = parseLine(line);

            String type = parts[0].trim();
            String questionText = parts[1].replace("\"", "");
            String correctAnswer = parts[2].replace("\"", "");
            String studentAnswer = parts[3].replace("\"", "");
            double points = Double.parseDouble(parts[4].trim());

            Question question;

            if (type.equals("MCQ")) {
                question = new MCQ(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                );
            } else if (type.equals("TF")) {
                question = new TF(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                );
            } else {
                question = new Essay(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                );
            }

            double score = question.grade();

            System.out.printf("%s: %.2f%n", type, score);

            totalScore += score;
        }

        System.out.printf("Total Score: %.2f%n", totalScore);

        sc.close();
    }
}