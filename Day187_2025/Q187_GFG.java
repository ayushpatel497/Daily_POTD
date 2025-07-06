import java.util.*;

class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        int n = a.length;
        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(y[0], x[0]));
        Set<String> visited = new HashSet<>();

        int i = n - 1, j = n - 1;
        pq.offer(new int[]{a[i] + b[j], i, j});
        visited.add(i + "," + j);

        ArrayList<Integer> result = new ArrayList<>();

        while (result.size() < k && !pq.isEmpty()) {
            int[] top = pq.poll();
            int sum = top[0], x = top[1], y = top[2];
            result.add(sum);

            if (x - 1 >= 0 && !visited.contains((x - 1) + "," + y)) {
                pq.offer(new int[]{a[x - 1] + b[y], x - 1, y});
                visited.add((x - 1) + "," + y);
            }

            if (y - 1 >= 0 && !visited.contains(x + "," + (y - 1))) {
                pq.offer(new int[]{a[x] + b[y - 1], x, y - 1});
                visited.add(x + "," + (y - 1));
            }
        }

        return result;
    }
}
