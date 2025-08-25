import java.util.*;

class Q237_GFG {
    private boolean isValid(int[] arr, int k, int median) {
        int n = arr.length;
        int j = n / 2;
        int med = -1;
        
        for (int i = n - 1; i >= 0; --i) {
            int diff = Math.max(0, Math.min(median - arr[i], k));
            
            if (i == j) med = arr[i] + diff;
            if (i == j - 1 && n % 2 == 0) {
                int temp = arr[i] + diff;
                med = (med + temp) >> 1;
            }
            
            k -= diff;
        }
        return med >= median;
    }
    
    public int maximizeMedian(int[] arr, int k) {
        Arrays.sort(arr);
        int left = 0, right = Integer.MAX_VALUE;
        int maxMedian = left;
        
        while (left <= right) {
            int mid = right - ((right - left) >> 1);
            if (isValid(arr, k, mid)) {
                left = mid + 1;
                maxMedian = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return maxMedian;
    }
}
