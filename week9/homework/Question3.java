import java.util.*;

abstract class Student {

    String name;

    // Common transport fee
    static final double TRANSPORT_FEE = 12000;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();

    boolean usesBus() {
        return false;
    }

    double calculateFee() {

        double fee = calculateTuition();

        if (usesBus()) {
            fee = fee + TRANSPORT_FEE;
        }

        return fee;
    }
}

class DayScholar extends Student {

    DayScholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {

    Hosteller(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000 + 60000;
    }

    boolean usesBus() {
        return false;
    }
}

class Scholar extends Student {

    Scholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 20000;
    }

    boolean usesBus() {
        return true;
    }
}

public class Question3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Student[] students = new Student[n];

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            if (type.equals("DAY_SCHOLAR")) {
                students[i] = new DayScholar(name);
            }
            else if (type.equals("HOSTELLER")) {
                students[i] = new Hosteller(name);
            }
            else if (type.equals("SCHOLAR")) {
                students[i] = new Scholar(name);
            }
        }

        for (Student student : students) {

            double fee = student.calculateFee();

            System.out.printf(
                "%s: %.2f%n",
                student.name,
                fee
            );

            total += fee;
        }

        System.out.printf(
            "Total Collected: %.2f%n",
            total
        );

        sc.close();
    }
}