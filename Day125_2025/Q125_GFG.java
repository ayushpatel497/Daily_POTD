class Q125_GFG {
    public int findTarget(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) return mid;
            if (mid - 1 >= low && arr[mid - 1] == target) return mid - 1;
            if (mid + 1 <= high && arr[mid + 1] == target) return mid + 1;

            if (arr[mid] < target) {
                low = mid + 2;  // skip mid and mid+1
            } else {
                high = mid - 2; // skip mid and mid-1
            }
        }

        return -1;
    }
}
