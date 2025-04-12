import java.util.*;
class Q102_Leetcode {
    public long countGoodIntegers(int n, int k) {
        Set<String> dict = new HashSet<>();
        int base = (int) Math.pow(10, (n - 1) / 2);
        int skip = n % 2;

        for (int i = base; i < base * 10; i++) {
            String s = Integer.toString(i);
            StringBuilder sb = new StringBuilder(s);
            if (skip == 1) sb.deleteCharAt(sb.length() - 1);
            sb.reverse();
            String pal = s + sb.toString();
            long palNum = Long.parseLong(pal);
            if (palNum % k == 0) {
                char[] chars = pal.toCharArray();
                Arrays.sort(chars);
                dict.add(new String(chars));
            }
        }

        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        long ans = 0;
        for (String s : dict) {
            int[] count = new int[10];
            for (char c : s.toCharArray()) {
                count[c - '0']++;
            }

            long total = (n - count[0]) * factorial[n - 1];
            for (int cnt : count) {
                total /= factorial[cnt];
            }

            ans += total;
        }

        return ans;
    }
}
