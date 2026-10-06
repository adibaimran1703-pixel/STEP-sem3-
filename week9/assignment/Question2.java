import java.util.*;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class FullTime extends Staff {
    double weeklySalary;

    FullTime(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    double calculatePay() {
        return weeklySalary;
    }
}

class Hourly extends Staff {
    double hours;
    double rate;

    Hourly(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {

        if (hours <= 40) {
            return hours * rate;
        }

        double normalPay = 40 * rate;
        double overtimeHours = hours - 40;
        double overtimePay = overtimeHours * rate * 1.5;

        return normalPay + overtimePay;
    }
}

class Intern extends Staff {
    double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double calculatePay() {
        return stipend;
    }
}

public class Question2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Staff[] staff = new Staff[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            if (type.equals("FULLTIME")) {

                double salary = sc.nextDouble();
                staff[i] = new FullTime(name, salary);
            }

            else if (type.equals("HOURLY")) {

                double hours = sc.nextDouble();
                double rate = sc.nextDouble();

                staff[i] = new Hourly(name, hours, rate);
            }

            else if (type.equals("INTERN")) {

                double stipend = sc.nextDouble();
                staff[i] = new Intern(name, stipend);
            }
        }

        double total = 0;

        for (Staff person : staff) {

            double pay = person.calculatePay();

            System.out.printf(
                "%s: %.2f%n",
                person.name,
                pay
            );

            total += pay;
        }

        System.out.printf(
            "Total Payroll: %.2f%n",
            total
        );

        sc.close();
    }
}