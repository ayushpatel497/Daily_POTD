import java.util.ArrayList;

class Q009_GFG {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // Q. Indexes of Subarray Sum
        int start = 0, currSum = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int end = 0; end < arr.length; ++end) {
            currSum += arr[end];

            while (currSum > target && start < end) {
                currSum -= arr[start++];
            }

            if (currSum == target) {
                result.add(start + 1); // Convert to 1-based index
                result.add(end + 1);  // Convert to 1-based index
                return result;
            }
        }

        result.add(-1); // If no subarray is found
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5};
        int target = 12;
        ArrayList<Integer> res = subarraySum(arr, target);
        System.out.println(res);
    }
}