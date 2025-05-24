class Solution {
    public static int sumSubstrings(String s) {
        long sum = 0;
        long mf = 1;
        int mod = 1000000007; // Use modulus if required by the problem

        for (int i = s.length() - 1; i >= 0; i--) {
            int digit = s.charAt(i) - '0';
            sum = (sum + digit * (i + 1L) * mf) % mod;
            mf = (mf * 10 + 1) % mod;
        }

        return (int) sum;
    }
}
