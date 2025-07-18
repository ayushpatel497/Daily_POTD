class Q176_Leetcode {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n1 = nums1.length, n2 = nums2.length;
        int pos1 = 0, pos2 = 0;
        while (pos1 < n1 && nums1[pos1] < 0) pos1++;
        while (pos2 < n2 && nums2[pos2] < 0) pos2++;

        long left = -1_000_000_000_0L, right = 1_000_000_000_0L;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = 0;

            for (int i1 = 0, i2 = pos2 - 1; i1 < pos1 && i2 >= 0; ) {
                if ((long) nums1[i1] * nums2[i2] > mid) {
                    i1++;
                } else {
                    count += pos1 - i1;
                    i2--;
                }
            }

            for (int i1 = pos1, i2 = n2 - 1; i1 < n1 && i2 >= pos2; ) {
                if ((long) nums1[i1] * nums2[i2] > mid) {
                    i2--;
                } else {
                    count += i2 - pos2 + 1;
                    i1++;
                }
            }

            for (int i1 = 0, i2 = pos2; i1 < pos1 && i2 < n2; ) {
                if ((long) nums1[i1] * nums2[i2] > mid) {
                    i2++;
                } else {
                    count += n2 - i2;
                    i1++;
                }
            }

            for (int i1 = pos1, i2 = 0; i1 < n1 && i2 < pos2; ) {
                if ((long) nums1[i1] * nums2[i2] > mid) {
                    i1++;
                } else {
                    count += n1 - i1;
                    i2++;
                }
            }

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
