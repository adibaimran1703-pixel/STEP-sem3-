import java.util.*;

abstract class Parcel {

    double weight;
    double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();
}

interface Insurable {

    double calculateInsurance();
}

class StandardParcel extends Parcel {

    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40 + (10 * weight);
    }
}

class ExpressParcel extends Parcel implements Insurable {

    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 80 + (15 * weight);
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {

    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40 + (10 * weight) + 50;
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

public class Question2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Parcel[] parcels = new Parcel[n];
        String[] types = new String[n];

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            types[i] = type;

            if (type.equals("STANDARD")) {
                parcels[i] = new StandardParcel(weight, value);
            }
            else if (type.equals("EXPRESS")) {
                parcels[i] = new ExpressParcel(weight, value);
            }
            else if (type.equals("FRAGILE")) {
                parcels[i] = new FragileParcel(weight, value);
            }
        }

        for (int i = 0; i < n; i++) {

            double charge = parcels[i].calculateCharge();

            double insurance = 0;

            if (parcels[i] instanceof Insurable) {
                insurance = ((Insurable) parcels[i]).calculateInsurance();
            }

            double total = charge + insurance;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                types[i],
                charge,
                insurance,
                total
            );

            grandTotal += total;
        }

        System.out.printf(
            "Grand Total: %.2f%n",
            grandTotal
        );

        sc.close();
    }
}