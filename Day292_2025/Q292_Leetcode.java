class Q292_Leetcode {
    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        String res = s;
        s = s + s;
        int g = gcd(b, n);

        for (int i = 0; i < n; i += g) {
            StringBuilder t = new StringBuilder(s.substring(i, i + n));

            // helper function to apply addition
            add(t, a, 1, n);
            if (b % 2 == 1) add(t, a, 0, n);

            String candidate = t.toString();
            if (candidate.compareTo(res) < 0) res = candidate;
        }
        return res;
    }

    private void add(StringBuilder t, int a, int start, int n) {
        int minVal = 10, times = 0;
        for (int i = 0; i < 10; i++) {
            int added = ((t.charAt(start) - '0') + i * a) % 10;
            if (added < minVal) {
                minVal = added;
                times = i;
            }
        }
        for (int i = start; i < n; i += 2) {
            int newVal = ((t.charAt(i) - '0') + times * a) % 10;
            t.setCharAt(i, (char) (newVal + '0'));
        }
    }
}
