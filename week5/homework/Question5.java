import java.util.Arrays;

public class Question5 implements Comparable<Question5> {

    private String name;
    private double cgpa;
    private int codingScore;

    // Constructor
    public Question5(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // CGPA-only eligibility rule
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    // Combined CGPA and coding-score rule
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    // Composite score
    private double compositeScore() {
        return (cgpa * 10) + (codingScore * 0.5);
    }

    // Sort by composite score in descending order
    @Override
    public int compareTo(Question5 other) {
        return Double.compare(other.compositeScore(), this.compositeScore());
    }

    static String shortlistAndRank(Question5[] candidates) {

        Question5[] shortlisted = new Question5[candidates.length];
        int count = 0;

        for (int i = 0; i < candidates.length; i++) {

            if (isEligible(candidates[i].cgpa) ||
                isEligible(candidates[i].cgpa, candidates[i].codingScore)) {

                shortlisted[count] = candidates[i];
                count++;
            }
        }

        // Remove unused positions
        shortlisted = Arrays.copyOf(shortlisted, count);

        // Uses compareTo() for ranking
        Arrays.sort(shortlisted);

        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {
            result += (i + 1) + ". "
                    + shortlisted[i].name
                    + " (" + shortlisted[i].compositeScore() + ")";

            if (i < shortlisted.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Question5[] candidates = {
            new Question5("Aisha", 8.2, 40),
            new Question5("Rohit", 6.8, 65),
            new Question5("Meena", 6.0, 90),
            new Question5("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}