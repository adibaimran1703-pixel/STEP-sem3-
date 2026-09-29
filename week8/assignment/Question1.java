import java.util.Scanner;

public class Question1 {

    static abstract class Payment {
        protected double amount;

        Payment(double amount) {
            this.amount = amount;
        }

        abstract double calculateAmount();
        abstract String getType();
    }

    static class CardPayment extends Payment {

        CardPayment(double amount) {
            super(amount);
        }

        double calculateAmount() {
            return amount + (amount * 0.02);
        }

        String getType() {
            return "CARD";
        }
    }

    static class WalletPayment extends Payment {

        WalletPayment(double amount) {
            super(amount);
        }

        double calculateAmount() {
            return amount + (amount * 0.01);
        }

        String getType() {
            return "WALLET";
        }
    }

    static class BankTransfer extends Payment {

        BankTransfer(double amount) {
            super(amount);
        }

        double calculateAmount() {
            return amount;
        }

        String getType() {
            return "BANKTRANSFER";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Payment payment;

            if (type.equals("CARD")) {
                payment = new CardPayment(amount);
            } else if (type.equals("WALLET")) {
                payment = new WalletPayment(amount);
            } else {
                payment = new BankTransfer(amount);
            }

            double adjustedAmount = payment.calculateAmount();

            System.out.printf("%s: %.2f%n",
                    payment.getType(), adjustedAmount);

            total += adjustedAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}