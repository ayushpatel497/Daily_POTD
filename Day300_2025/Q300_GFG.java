import java.util.*;

class Q300_GFG {
    public ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (arr1.length == 0 || arr2.length == 0 || k == 0) return ans;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < arr1.length && i < k; i++) {
            pq.offer(new int[]{arr1[i] + arr2[0], i, 0});
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            int i = top[1], j = top[2];
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(arr1[i]);
            pair.add(arr2[j]);
            ans.add(pair);

            if (j + 1 < arr2.length) {
                pq.offer(new int[]{arr1[i] + arr2[j + 1], i, j + 1});
            }
        }

        return ans;
    }
}
