import java.util.*;

abstract class Booking {

    double distance;

    // Common booking fee
    static final double BOOKING_FEE = 50;

    Booking(double distance) {
        this.distance = distance;
    }

    // Each mode calculates its own fare
    abstract double calculateFare();

    // Common method for all bookings
    double calculateTotal() {
        return calculateFare() + BOOKING_FEE;
    }
}

class Bus extends Booking {

    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 2;
    }
}

class Train extends Booking {

    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 1.5;
    }
}

class Flight extends Booking {

    Flight(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 2500 + (distance * 4);
    }
}

public class Question5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Booking[] bookings = new Booking[n];

        String[] modes = new String[n];

        for (int i = 0; i < n; i++) {

            String mode = sc.next();
            double distance = sc.nextDouble();

            modes[i] = mode;

            if (mode.equals("BUS")) {
                bookings[i] = new Bus(distance);
            }

            else if (mode.equals("TRAIN")) {
                bookings[i] = new Train(distance);
            }

            else if (mode.equals("FLIGHT")) {
                bookings[i] = new Flight(distance);
            }
        }

        for (int i = 0; i < n; i++) {

            double total = bookings[i].calculateTotal();

            System.out.printf(
                "%s: %.2f%n",
                modes[i],
                total
            );
        }

        sc.close();
    }
}