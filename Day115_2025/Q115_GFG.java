class Solution {
    static int majorityElement(int arr[]) {
        int count = 0, candidate = -1, n = arr.length;

        // Phase 1: Find candidate
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Phase 2: Verify candidate
        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }

        return count > n / 2 ? candidate : -1;
    }
}
