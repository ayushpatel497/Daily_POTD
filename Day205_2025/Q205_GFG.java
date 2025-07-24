class Q205_GFG {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxTime = 0;

        for (int ant : left) {
            maxTime = Math.max(maxTime, ant);
        }

        for (int ant : right) {
            maxTime = Math.max(maxTime, n - ant);
        }

        return maxTime;
    }
}
