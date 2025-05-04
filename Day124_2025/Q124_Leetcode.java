class Q124_Leetcode {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int result = 0;

        for (int[] domino : dominoes) {
            int a = domino[0], b = domino[1];
            int val = a < b ? a * 10 + b : b * 10 + a;
            result += count[val];
            count[val]++;
        }

        return result;
    }
}
