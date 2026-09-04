import java.util.HashMap;

public class Question4 {

    static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            currentSum += nums[i];

            int required = currentSum - k;

            if (map.containsKey(required)) {
                count += map.get(required);
            }

            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};

        int k = 2;

        System.out.println(subarraySum(nums, k));
    }
}