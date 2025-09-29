import java.util.*;

class Q272_GFG {
    public int maxSubarrSum(int[] arr, int a, int b) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE;

        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + arr[i - 1];
        }

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = a; i <= n; i++) {
            // remove indices out of valid window
            while (!q.isEmpty() && q.peekFirst() + b < i) {
                q.pollFirst();
            }

            // maintain increasing order of prefix sums
            while (!q.isEmpty() && pre[q.peekLast()] > pre[i - a]) {
                q.pollLast();
            }

            q.addLast(i - a);

            ans = Math.max(ans, pre[i] - pre[q.peekFirst()]);
        }

        return ans;
    }
}
