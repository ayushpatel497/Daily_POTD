import java.util.*;

class Q121_Leetcode {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int n = tasks.length, m = workers.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int left = 1, right = Math.min(n, m), ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canAssign(tasks, workers, pills, strength, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int mid) {
        int p = pills;
        Deque<Integer> dq = new ArrayDeque<>();
        int ptr = workers.length - 1;

        for (int i = mid - 1; i >= 0; i--) {
            while (ptr >= workers.length - mid && workers[ptr] + strength >= tasks[i]) {
                dq.addFirst(workers[ptr]);
                ptr--;
            }

            if (dq.isEmpty()) return false;

            if (dq.peekLast() >= tasks[i]) {
                dq.pollLast();
            } else {
                if (p == 0) return false;
                p--;
                dq.pollFirst();
            }
        }
        return true;
    }
}
