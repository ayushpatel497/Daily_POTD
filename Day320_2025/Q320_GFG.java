class Q320_GFG {
    public int LCIS(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        int[] lcis = new int[m];

        for (int i = 0; i < n; i++) {
            int current = 0;

            for (int j = 0; j < m; j++) {

                if (a[i] == b[j]) {
                    if (lcis[j] < current + 1) {
                        lcis[j] = current + 1;
                    }
                } else if (a[i] > b[j]) {
                    if (lcis[j] > current) {
                        current = lcis[j];
                    }
                }
            }
        }

        int ans = 0;
        for (int x : lcis) ans = Math.max(ans, x);
        return ans;
    }
}
