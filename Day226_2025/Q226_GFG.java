class Q226_GFG {
    private int cnt = 0;

    private void merge(int low, int mid, int high, int[] a) {
        int[] temp = new int[high - low + 1];
        int left = low, right = mid + 1, idx = 0;

        while (left <= mid && right <= high) {
            if (a[left] <= a[right]) {
                temp[idx++] = a[left++];
            } else {
                temp[idx++] = a[right++];
            }
        }
        while (left <= mid) temp[idx++] = a[left++];
        while (right <= high) temp[idx++] = a[right++];

        for (int i = 0; i < temp.length; i++) {
            a[low + i] = temp[i];
        }
    }

    private void countPairs(int low, int mid, int high, int[] a) {
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long)a[i] > 2L * (long)a[right]) {
                right++;
            }
            cnt += (right - (mid + 1));
        }
    }

    private void mergeSort(int low, int high, int[] a) {
        if (low >= high) return;
        int mid = (low + high) >> 1;
        mergeSort(low, mid, a);
        mergeSort(mid + 1, high, a);
        countPairs(low, mid, high, a);
        merge(low, mid, high, a);
    }

    public int countRevPairs(int[] arr) {
        cnt = 0;
        mergeSort(0, arr.length - 1, arr);
        return cnt;
    }
}
