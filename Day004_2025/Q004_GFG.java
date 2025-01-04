import java.util.*;
import java.io.*;

class Solution {
    public int countTriplets(int[] arr, int target) {
        // Q. Count all triplets with given sum in sorted array
        int ans = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == target) {
                    int countJ = 0, countK = 0;
                    int valJ = arr[j], valK = arr[k];
                    while (j <= k && arr[j] == valJ) {
                        countJ++;
                        j++;
                    }
                    while (j <= k && arr[k] == valK) {
                        countK++;
                        k--;
                    }
                    if (valJ == valK) {
                        ans += countJ * (countJ - 1) / 2;
                    } else {
                        ans += countJ * countK;
                    }
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            int[] arr = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(br.readLine());
            Solution sol = new Solution();
            System.out.println(sol.countTriplets(arr, target));
            System.out.println("~");
        }
    }
}
