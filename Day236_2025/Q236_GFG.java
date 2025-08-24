import java.util.Arrays;

class Q236_GFG {
    public int minDaysBloom(int[] arr, int k, int m) {
        Arrays.sort(arr);
        if (arr.length < m * k) return -1;
        return arr[m * k - 1];
    }
}
