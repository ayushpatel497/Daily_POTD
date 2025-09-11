class Q254_GFG {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n < 2)
            return 0;
        if (arr[0] == 0)
            return -1;

        int last = 0, count = 0, maxi = 0;

        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, i + arr[i]);
            if (i == last) {
                count++;
                last = maxi;
                if (last >= n - 1)
                    return count;
            }
        }
        return -1;
    }
}
