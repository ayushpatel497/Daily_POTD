class Q204_GFG {
    public int subarraySum(int[] arr) {
        int n = arr.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int start = i + 1;
            int end = n - i;
            int contribution = start * end;
            sum += arr[i] * contribution;
        }

        return sum;
    }
}
