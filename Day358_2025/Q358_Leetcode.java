import java.util.*;

class Q358_Leetcode {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int a : apple) {
            sum += a;
        }

        // Sort capacities in descending order
        Arrays.sort(capacity);
        
        int need = 0;
        for (int i = capacity.length - 1; i >= 0 && sum > 0; i--) {
            sum -= capacity[i];
            need++;
        }

        return need;
    }
}
