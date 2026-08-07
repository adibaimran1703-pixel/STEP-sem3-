import java.util.Scanner;

public class MovieReviewWordLengthProfiler {

    // Method to classify word lengths
    public static void classifyWordLengths(String review) {

        // Split the review into words
        String[] words = review.split("\\s+");

        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        // Check each word
        for (String word : words) {

            // Remove punctuation marks
            word = word.replaceAll("[^a-zA-Z]", "");

            int length = word.length();

            if (length >= 1 && length <= 4) {
                shortWords++;
            } else if (length >= 5 && length <= 8) {
                mediumWords++;
            } else if (length >= 9) {
                longWords++;
            }
        }

        System.out.println("Short: " + shortWords);
        System.out.println("Medium: " + mediumWords);
        System.out.println("Long: " + longWords);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the movie review: ");
        String review = sc.nextLine();

        classifyWordLengths(review);

        sc.close();
    }
}