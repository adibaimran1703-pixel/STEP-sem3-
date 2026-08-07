public class ExamHallSeatChecker {

    // Method to check duplicate seat numbers
    static void checkDuplicateSeats(int[] seatNumbers) {

        boolean found = false;

        for (int i = 0; i < seatNumbers.length; i++) {

            boolean alreadyPrinted = false;

            // Check if this duplicate was already printed
            for (int k = 0; k < i; k++) {
                if (seatNumbers[i] == seatNumbers[k]) {
                    alreadyPrinted = true;
                    break;
                }
            }

            if (alreadyPrinted)
                continue;

            // Compare with remaining elements
            for (int j = i + 1; j < seatNumbers.length; j++) {

                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {

        int[] seats1 = {101, 102, 103, 102, 105};
        checkDuplicateSeats(seats1);

        System.out.println();

        int[] seats2 = {101, 102, 103, 104, 105};
        checkDuplicateSeats(seats2);
    }
}
