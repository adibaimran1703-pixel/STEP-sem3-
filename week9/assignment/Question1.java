import java.util.*;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double calculateArea();

    abstract String getShape();
}

class Circle extends Plot {
    double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    String getShape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    double length, width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }

    String getShape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    double base, height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }

    String getShape() {
        return "TRIANGLE";
    }
}

public class Question1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Plot[] plots = new Plot[n];

        for (int i = 0; i < n; i++) {

            String shape = sc.next();

            String owner = sc.next();

            if (shape.equals("CIRCLE")) {
                double radius = sc.nextDouble();
                plots[i] = new Circle(owner, radius);
            }

            else if (shape.equals("RECTANGLE")) {
                double length = sc.nextDouble();
                double width = sc.nextDouble();
                plots[i] = new Rectangle(owner, length, width);
            }

            else if (shape.equals("TRIANGLE")) {
                double base = sc.nextDouble();
                double height = sc.nextDouble();
                plots[i] = new Triangle(owner, base, height);
            }
        }

        double total = 0;

        for (Plot plot : plots) {

            double area = plot.calculateArea();

            System.out.printf(
                "%s (%s): %.2f%n",
                plot.owner,
                plot.getShape(),
                area
            );

            total += area;
        }

        System.out.printf("Total Area: %.2f%n", total);

        sc.close();
    }
}