import java.util.Scanner;

public class Question1 {

    static abstract class Customer {
        protected double amount;

        Customer(double amount) {
            this.amount = amount;
        }

        abstract double calculateAmount();

        abstract String getType();
    }

    static class Student extends Customer {
        Student(double amount) {
            super(amount);
        }

        double calculateAmount() {
            return amount - (amount * 0.10);
        }

        String getType() {
            return "STUDENT";
        }
    }

    static class Staff extends Customer {
        Staff(double amount) {
            super(amount);
        }

        double calculateAmount() {
            return amount - (amount * 0.05);
        }

        String getType() {
            return "STAFF";
        }
    }

    static class Guest extends Customer {
        Guest(double amount) {
            super(amount);
        }

        double calculateAmount() {
            return amount + 10;
        }

        String getType() {
            return "GUEST";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer;

            if (type.equals("STUDENT")) {
                customer = new Student(amount);
            } else if (type.equals("STAFF")) {
                customer = new Staff(amount);
            } else {
                customer = new Guest(amount);
            }

            double finalAmount = customer.calculateAmount();

            System.out.printf("%s: %.2f%n",
                    customer.getType(), finalAmount);

            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}