import java.util.*;

abstract class Cab {

    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    double calculateFare() {

        double fare = km * getRate();

        if (fare < 100) {
            fare = 100;
        }

        return fare;
    }
}

interface NightService {

    double addNightCharge(double fare);
}

class Mini extends Cab {

    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {

    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    public double addNightCharge(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {

    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    public double addNightCharge(double fare) {
        return fare * 1.20;
    }
}

public class Question4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Cab[] cabs = new Cab[n];
        String[] cabTypes = new String[n];
        String[] times = new String[n];

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            cabTypes[i] = type;
            times[i] = time;

            if (type.equals("MINI")) {
                cabs[i] = new Mini(km);
            }
            else if (type.equals("SEDAN")) {
                cabs[i] = new Sedan(km);
            }
            else if (type.equals("SUV")) {
                cabs[i] = new SUV(km);
            }
        }

        for (int i = 0; i < n; i++) {

            // Mini cannot provide night service
            if (times[i].equals("NIGHT") &&
                !(cabs[i] instanceof NightService)) {

                System.out.println(
                    cabTypes[i] + ": night service not available"
                );

                continue;
            }

            double fare = cabs[i].calculateFare();

            if (times[i].equals("NIGHT")) {
                fare = ((NightService) cabs[i])
                        .addNightCharge(fare);
            }

            System.out.printf(
                "%s: %.2f%n",
                cabTypes[i],
                fare
            );

            total += fare;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );

        sc.close();
    }
}