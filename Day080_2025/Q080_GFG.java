class Q080_GFG {
    public int findMaxSum(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];

        int pre1 = 0, pre2 = 0;
        for (int i = 0; i < n; i++) {
            int loot = arr[i] + (i >= 1 ? pre2 : 0);
            int dontLoot = pre1;
            pre2 = pre1;
            pre1 = Math.max(loot, dontLoot);
        }
        return pre1;
    }
}
