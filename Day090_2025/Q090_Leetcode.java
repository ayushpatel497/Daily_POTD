import java.util.*;

class Q090_Leetcode {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        List<Integer> pairWeights = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            pairWeights.add(weights[i] + weights[i + 1]);
        }

        Collections.sort(pairWeights);
        long answer = 0;

        for (int i = 0; i < k - 1; i++) {
            answer += pairWeights.get(n - 2 - i) - pairWeights.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Q090_Leetcode sol = new Q090_Leetcode();
        int[] weights = {1, 3, 5, 1};
        int k = 2;
        System.out.println(sol.putMarbles(weights, k)); // Expected Output: 4
    }
}
