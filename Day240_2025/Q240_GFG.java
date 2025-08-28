class Q240_GFG {
    public int maxOnes(int arr[], int k) {
        int left = 0, zeroCount = 0, maxLen = 0;

        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0)
                zeroCount++;

            while (zeroCount > k) {
                if (arr[left] == 0)
                    zeroCount--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
