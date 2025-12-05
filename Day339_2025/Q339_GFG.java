class Q339_GFG {
    int minCost(int[][] cost) {
        int n = cost.length;
        int k = cost[0].length;

        if (k == 1) {
            if (n == 1) return cost[0][0];
            return -1;
        }

        // mini = {value, index}, smini = second minimum
        int miniVal = Integer.MAX_VALUE, miniIdx = -1;
        int sminiVal = Integer.MAX_VALUE, sminiIdx = -1;

        // First row
        for (int i = 0; i < k; i++) {
            if (cost[0][i] < miniVal) {
                sminiVal = miniVal;
                sminiIdx = miniIdx;

                miniVal = cost[0][i];
                miniIdx = i;
            } else if (cost[0][i] < sminiVal) {
                sminiVal = cost[0][i];
                sminiIdx = i;
            }
        }

        // DP for remaining rows
        for (int i = 1; i < n; i++) {
            int curMiniVal = Integer.MAX_VALUE, curMiniIdx = -1;
            int curSminiVal = Integer.MAX_VALUE, curSminiIdx = -1;

            for (int j = 0; j < k; j++) {
                int x;

                if (j != miniIdx) x = cost[i][j] + miniVal;
                else x = cost[i][j] + sminiVal;

                if (x < curMiniVal) {
                    curSminiVal = curMiniVal;
                    curSminiIdx = curMiniIdx;

                    curMiniVal = x;
                    curMiniIdx = j;
                } else if (x < curSminiVal) {
                    curSminiVal = x;
                    curSminiIdx = j;
                }
            }

            miniVal = curMiniVal;
            miniIdx = curMiniIdx;
            sminiVal = curSminiVal;
            sminiIdx = curSminiIdx;
        }

        return miniVal;
    }
}
