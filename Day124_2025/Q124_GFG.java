class Q124_GFG {
    public int findSubString(String str) {
        int n = str.length();
        int uniqueCount = (int) str.chars().distinct().count();

        int[] freq = new int[256];
        int left = 0, right = 0, ans = n;
        int count = 0;

        while (right < n) {
            if (freq[str.charAt(right)] == 0) count++;
            freq[str.charAt(right)]++;
            right++;

            while (count == uniqueCount) {
                ans = Math.min(ans, right - left);
                freq[str.charAt(left)]--;
                if (freq[str.charAt(left)] == 0) count--;
                left++;
            }
        }

        return ans;
    }
}
