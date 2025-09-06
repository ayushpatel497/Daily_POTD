class Q249_Leetcode {
    private long get(int num) {
        int i = 1;
        long base = 1;
        long cnt = 0;
        
        while (base <= num) {
            cnt += (long)(i + 1) / 2 * (Math.min(base * 2 - 1, num) - base + 1);
            i++;
            base *= 2;
        }
        
        return cnt;
    }

    public long minOperations(int[][] queries) {
        long res = 0;
        for (int[] q : queries) {
            res += (get(q[1]) - get(q[0] - 1) + 1) / 2;
        }
        return res;
    }
}
