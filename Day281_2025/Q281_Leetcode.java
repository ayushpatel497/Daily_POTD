import java.util.*;

class Q281_Leetcode {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];
        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
            int left = 0, right = m - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long product = (long) spells[i] * (long) potions[mid];
                if (product >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            pairs[i] = m - left;
        }

        return pairs;
    }
}
