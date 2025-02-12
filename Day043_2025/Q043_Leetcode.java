import java.util.*;

class Q043_Leetcode {
    public int maximumSum(int[] nums) {
        int answer = -1;
        Map<Integer, Integer> digitMapping = new HashMap<>();

        for (int element : nums) {
            int digitSum = 0;
            int currValue = element;
            
            while (currValue > 0) {
                digitSum += currValue % 10;
                currValue /= 10;
            }

            if (digitMapping.containsKey(digitSum)) {
                answer = Math.max(answer, digitMapping.get(digitSum) + element);
            }
            digitMapping.put(digitSum, Math.max(digitMapping.getOrDefault(digitSum, 0), element));
        }

        return answer;
    }
}
