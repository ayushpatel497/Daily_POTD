class Q294_GFG {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        // Q. Top K Frequent in Array
        // Code here
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Max heap based on frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            ans.add(pq.poll()[1]);
        }

        return ans;
    }
}
