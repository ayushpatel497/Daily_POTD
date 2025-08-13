import java.util.Arrays;

class Q225_GFG {
    public int minSoldiers(int[] arr, int k) {
        int n = arr.length;
        int safe_troop = (n + 1) / 2;
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] % k != 0 ? k - arr[i] % k : 0;
        }
        Arrays.sort(arr);
        int i = 0, ans = 0;
        while (safe_troop > 0) {
            ans += arr[i];
            i++;
            safe_troop--;
        }
        return ans;
    }
}
