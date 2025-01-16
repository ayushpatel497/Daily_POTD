import java.util.*;

class Q016_GFG {
    public int maxLen(int[] arr) {
        // Q. Largest subarray of 0's and 1's
        // Your code here
        HashMap<Integer, Integer> preSumIndexMap = new HashMap<>();
        int answerLength = 0;
        int preSum = 0;

        for (int index = 0; index < arr.length; ++index) {
            preSum += arr[index] == 1 ? 1 : -1;

            if (preSum == 0) {
                answerLength = index + 1;
            }

            if (preSumIndexMap.containsKey(preSum)) {
                answerLength = Math.max(answerLength, index - preSumIndexMap.get(preSum));
            } else {
                preSumIndexMap.put(preSum, index);
            }
        }

        return answerLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // Consume newline character

        while (T-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            Q016_GFG solution = new Q016_GFG();
            System.out.println(solution.maxLen(arr));
        }

        sc.close();
    }
}
