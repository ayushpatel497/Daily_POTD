import java.util.Arrays;

class Q164_GFG {
    
    private int calcuth(int[] arr, int hour) {
        int total = 0;
        for (int bananas : arr) {
            total += (int) Math.ceil((double) bananas / hour);
        }
        return total;
    }

    public int kokoEat(int[] arr, int k) {
        int low = 1;
        int high = Arrays.stream(arr).max().getAsInt();
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int totalh = calcuth(arr, mid);
            if (totalh <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
