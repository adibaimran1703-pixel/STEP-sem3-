import java.time.LocalDate;
import java.util.Scanner;

public class Question2 {

    static abstract class LibraryItem {
        protected String title;

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int getBorrowingDays();

        String getDueDate() {
            LocalDate currentDate = LocalDate.of(2023, 10, 26);

            return currentDate
                    .plusDays(getBorrowingDays())
                    .toString();
        }

        String getTitle() {
            return title;
        }
    }

    static class Book extends LibraryItem {

        Book(String title) {
            super(title);
        }

        int getBorrowingDays() {
            return 14;
        }
    }

    static class DVD extends LibraryItem {

        DVD(String title) {
            super(title);
        }

        int getBorrowingDays() {
            return 7;
        }
    }

    static class Magazine extends LibraryItem {

        Magazine(String title) {
            super(title);
        }

        int getBorrowingDays() {
            return 3;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts = line.split(" ", 2);

            String type = parts[0];
            String title = parts[1];

            title = title.replace("\"", "");

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title);
            } else if (type.equals("DVD")) {
                item = new DVD(title);
            } else {
                item = new Magazine(title);
            }

            System.out.println(
                    item.getTitle() + ": " + item.getDueDate()
            );
        }

        sc.close();
    }
}