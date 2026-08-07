import java.util.Scanner;

public class TypingSpeedTest {

    // Method to check typing accuracy
    public static void checkTypingAccuracy(String original, String typed) {

        int matched = 0;
        int firstMismatch = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = (matched * 100.0) / original.length();

        System.out.println("Matched: " + matched + "/" + original.length());
        System.out.printf("Accuracy: %.2f%%\n", accuracy);

        if (firstMismatch == -1) {
            System.out.println("No Mismatches");
        } else {
            System.out.println("First Mismatch at position "
                    + (firstMismatch + 1)
                    + " ('" + original.charAt(firstMismatch)
                    + "' vs '" + typed.charAt(firstMismatch) + "')");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the original text: ");
        String original = sc.nextLine();

        System.out.print("Enter the typed text: ");
        String typed = sc.nextLine();

        // Check if lengths are equal
        if (original.length() != typed.length()) {
            System.out.println("Error: Both strings must have the same length.");
        } else {
            checkTypingAccuracy(original, typed);
        }

        sc.close();
    }
}
