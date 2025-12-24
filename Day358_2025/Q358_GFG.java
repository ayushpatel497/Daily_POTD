class Q358_GFG {

    private int pivot(int[] arr) {
        int l = 0, h = arr.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (arr[m] > arr[h]) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return l;
    }

    private int upperBound(int[] arr, int l, int r, int x) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] <= x) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    public int countLessEqual(int[] arr, int x) {
        int piv = pivot(arr);

        int c1 = upperBound(arr, 0, piv, x);
        int c2 = upperBound(arr, piv, arr.length, x) - piv;

        return c1 + c2;
    }
}
