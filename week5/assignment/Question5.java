import java.util.Arrays;

public class Question5 implements Comparable<Question5> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    // Constructor
    public Question5(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Rule 1: Established players
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Rule 2: Newer players
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    // Sort by fantasy points / batting average in descending order
    @Override
    public int compareTo(Question5 other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    static String draftAndRank(Question5[] players) {

        // Temporary array for draftable players
        Question5[] draftable = new Question5[players.length];
        int count = 0;

        for (int i = 0; i < players.length; i++) {

            if (isDraftable(players[i].matchesPlayed) ||
                isDraftable(players[i].matchesPlayed, players[i].injured)) {

                draftable[count] = players[i];
                count++;
            }
        }

        // Create array with exact size
        Question5[] selected = Arrays.copyOf(draftable, count);

        // Uses compareTo() automatically
        Arrays.sort(selected);

        String result = "";

        for (int i = 0; i < selected.length; i++) {
            result += (i + 1) + ". " + selected[i].name;

            if (i < selected.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Question5[] players = {
            new Question5("Virat", 15, 48.0, false),
            new Question5("Rahul", 7, 55.0, false),
            new Question5("Sameer", 3, 60.0, false),
            new Question5("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}