import java.util.*;

class Q293_GFG {
    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        int[] numWays = new int[7];
        numWays[0] = 1;
        numWays[1] = 1;

        for (int index = 2; index < numWays.length; index++) {
            int left = 0, right = index - 1, sum = 0;
            while (left <= right) {
                int product = numWays[left] * numWays[right];
                sum += product * (1 + (left != right ? 1 : 0));
                left++;
                right--;
            }
            numWays[index] = sum;
        }

        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueToIndex.put(arr[i], i);
        }

        int[] sortedInput = Arrays.copyOf(arr, n);
        Arrays.sort(sortedInput);

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int original = valueToIndex.get(sortedInput[i]);
            result.add(original, numWays[i] * numWays[n - i - 1]);
        }

        return result;
    }
}
