import java.util.*;

public class Question5 {

    static int[] rotateArray(int[] nums, int k) {

        int n = nums.length;

        k = k % n;

        int[] newArray = new int[n];

        for (int i = 0; i < n; i++) {

            int newPosition = (i + k) % n;

            newArray[newPosition] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int[] result = rotateArray(nums, k);

        System.out.print("[");

        for (int i = 0; i < result.length; i++) {

            System.out.print(result[i]);

            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");

        sc.close();
    }
}