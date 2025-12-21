class Q355_Leetcode {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        boolean[] resolved = new boolean[n - 1];
        int unresolved = n - 1;
        int deletions = 0;

        for (int col = 0; col < m && unresolved > 0; col++) {
            boolean bad = false;

            // Check if this column breaks ordering
            for (int i = 0; i < n - 1; i++) {
                if (!resolved[i] && strs[i].charAt(col) > strs[i + 1].charAt(col)) {
                    bad = true;
                    break;
                }
            }

            // If bad, delete this column
            if (bad) {
                deletions++;
                continue;
            }

            // Otherwise, resolve pairs that are strictly ordered
            for (int i = 0; i < n - 1; i++) {
                if (!resolved[i] && strs[i].charAt(col) < strs[i + 1].charAt(col)) {
                    resolved[i] = true;
                    unresolved--;
                }
            }
        }

        return deletions;
    }
}
