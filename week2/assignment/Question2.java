import java.util.*;

public class Question2 {

    static void parseStudentRecord(String csvLine) {

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {

            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0];
        String rollNumber = fields[1];
        String department = fields[2];

        System.out.println(
            "Name: " + name +
            " | Roll No: " + rollNumber +
            " | Dept: " + department
        );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String csvLine = sc.nextLine();

        parseStudentRecord(csvLine);

        sc.close();
    }
}