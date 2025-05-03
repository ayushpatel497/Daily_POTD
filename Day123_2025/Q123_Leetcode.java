class Q123_Leetcode {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] countA = new int[7];      // Count in tops
        int[] countB = new int[7];      // Count in bottoms
        int[] countSame = new int[7];   // Count where top == bottom

        int n = tops.length;
        for (int i = 0; i < n; i++) {
            countA[tops[i]]++;
            countB[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                countSame[tops[i]]++;
            }
        }

        int ans = n;
        for (int i = 1; i <= 6; i++) {
            if (countA[i] + countB[i] - countSame[i] == n) {
                ans = Math.min(ans, n - Math.max(countA[i], countB[i]));
            }
        }

        return ans == n ? -1 : ans;
    }
}
