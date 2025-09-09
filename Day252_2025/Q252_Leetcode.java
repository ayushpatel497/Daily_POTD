class Q252_Leetcode {
    int mod = 1_000_000_007;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        Deque<int[]> know = new ArrayDeque<>();
        Deque<int[]> share = new ArrayDeque<>();
        know.addLast(new int[]{1, 1});
        int knowCount = 1, shareCount = 0;

        for (int day = 2; day <= n; day++) {
            if (!know.isEmpty() && know.peekFirst()[0] == day - delay) {
                knowCount = (knowCount - know.peekFirst()[1] + mod) % mod;
                shareCount = (shareCount + know.peekFirst()[1]) % mod;
                share.addLast(know.pollFirst());
            }

            if (!share.isEmpty() && share.peekFirst()[0] == day - forget) {
                shareCount = (shareCount - share.peekFirst()[1] + mod) % mod;
                share.pollFirst();
            }

            if (!share.isEmpty()) {
                knowCount = (knowCount + shareCount) % mod;
                know.addLast(new int[]{day, shareCount});
            }
        }

        return (knowCount + shareCount) % mod;
    }
}
