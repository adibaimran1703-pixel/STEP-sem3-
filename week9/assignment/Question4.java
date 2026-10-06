import java.util.*;

abstract class Connection {
    int units;

    Connection(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class Home extends Connection {

    Home(int units) {
        super(units);
    }

    double calculateBill() {

        if (units <= 100) {
            return units * 5;
        }

        return (100 * 5) + ((units - 100) * 7);
    }
}

class Shop extends Connection {

    Shop(int units) {
        super(units);
    }

    double calculateBill() {
        return (units * 8) + 100;
    }
}

class Factory extends Connection {

    Factory(int units) {
        super(units);
    }

    double calculateBill() {

        double bill = units * 6;

        if (bill < 1000) {
            bill = 1000;
        }

        return bill;
    }
}

public class Question4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Connection[] connections = new Connection[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int units = sc.nextInt();

            if (type.equals("HOME")) {
                connections[i] = new Home(units);
            }

            else if (type.equals("SHOP")) {
                connections[i] = new Shop(units);
            }

            else if (type.equals("FACTORY")) {
                connections[i] = new Factory(units);
            }
        }

        double total = 0;

        for (Connection connection : connections) {

            double bill = connection.calculateBill();

            String type;

            if (connection instanceof Home) {
                type = "HOME";
            }
            else if (connection instanceof Shop) {
                type = "SHOP";
            }
            else {
                type = "FACTORY";
            }

            System.out.printf(
                "%s: %.2f%n",
                type,
                bill
            );

            total += bill;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );

        sc.close();
    }
}