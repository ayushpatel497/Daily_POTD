class Q331_GFG {
    public int subsetXORSum(int[] arr) {
        int n = arr.length;
        int ans = 0;

        for (int bit = 0; bit < 11; bit++) {
            int countSet = 0;
            for (int num : arr) {
                if ((num & (1 << bit)) != 0)
                    countSet++;
            }
            if (countSet > 0) {
                ans += (1 << bit) * (1 << (n - 1));
            }
        }

        return ans;
    }
}
