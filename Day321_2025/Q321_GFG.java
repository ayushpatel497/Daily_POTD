class Q321_GFG {
    public int maxSumIS(int arr[]) {
        int n = arr.length;
        int[] curr = new int[n + 1];
        int[] next = new int[n + 1];

        for (int currIndex = n - 1; currIndex >= 0; currIndex--) {
            for (int lastIndex = currIndex - 1; lastIndex >= -1; lastIndex--) {

                int notTake = next[lastIndex + 1];
                int take = 0;

                if (lastIndex == -1 || arr[currIndex] > arr[lastIndex]) {
                    take = arr[currIndex] + next[currIndex + 1];
                }

                curr[lastIndex + 1] = Math.max(notTake, take);
            }
            next = curr.clone();
        }
        return next[0];
    }
}
