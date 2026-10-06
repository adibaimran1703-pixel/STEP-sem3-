import java.util.*;

abstract class Appliance {

    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double calculateUnits() {
        return (getPower() * hours) / 1000;
    }

    double calculateCost() {
        return calculateUnits() * 8;
    }
}

interface SaverMode {

    double reduceUnits(double units);
}

class Fridge extends Appliance {

    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {

    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    public double reduceUnits(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {

    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {

    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    public double reduceUnits(double units) {
        return units * 0.75;
    }
}

public class Question5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Appliance[] appliances = new Appliance[n];
        String[] names = new String[n];
        boolean[] saverRequested = new boolean[n];

        double totalCost = 0;

        for (int i = 0; i < n; i++) {

            String name = sc.next();
            double hours = sc.nextDouble();

            names[i] = name;

            if (name.equals("FRIDGE")) {
                appliances[i] = new Fridge(hours);
            }
            else if (name.equals("AC")) {
                appliances[i] = new AC(hours);
            }
            else if (name.equals("TV")) {
                appliances[i] = new TV(hours);
            }
            else if (name.equals("WASHER")) {
                appliances[i] = new Washer(hours);
            }

            if (sc.hasNext("SAVER")) {
                sc.next();
                saverRequested[i] = true;
            }
        }

        for (int i = 0; i < n; i++) {

            Appliance appliance = appliances[i];

            if (saverRequested[i] &&
                !(appliance instanceof SaverMode)) {

                System.out.println(
                    names[i] + ": saver mode not supported"
                );

                continue;
            }

            double units = appliance.calculateUnits();

            if (saverRequested[i]) {
                units = ((SaverMode) appliance)
                        .reduceUnits(units);
            }

            double cost = units * 8;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                names[i],
                units,
                cost
            );

            totalCost += cost;
        }

        System.out.printf(
            "Total Cost: %.2f%n",
            totalCost
        );

        sc.close();
    }
}