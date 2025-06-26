import java.util.*;

class Q177_GFG {
    public int minValue(String s, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int f : freq) {
            if (f > 0) pq.offer(f);
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int top = pq.poll();
            top--;
            if (top > 0) pq.offer(top);
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            int x = pq.poll();
            ans += x * x;
        }

        return ans;
    }
}
