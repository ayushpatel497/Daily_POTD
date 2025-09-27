import java.util.*;

class Q270_GFG {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        Queue<Integer> flips = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!flips.isEmpty() && flips.peek() + k == i) {
                flips.poll();
            }
            if ((arr[i] + flips.size()) % 2 == 0) { 
                // needs flip
                if (i + k > n) return -1;
                count++;
                flips.offer(i);
            }
        }

        return count;
    }
}
