class Q100_Leetcode {
    private long calculate(String x, String s, int limit) {
        if (x.length() < s.length()) return 0;
        if (x.length() == s.length()) return x.compareTo(s) >= 0 ? 1 : 0;

        String suffix = x.substring(x.length() - s.length());
        long count = 0;
        int preLen = x.length() - s.length();

        for (int i = 0; i < preLen; i++) {
            int digit = x.charAt(i) - '0';
            if (limit < digit) {
                count += (long)Math.pow(limit + 1, preLen - i);
                return count;
            }
            count += (long)digit * (long)Math.pow(limit + 1, preLen - i - 1);
        }

        if (suffix.compareTo(s) >= 0) count++;
        return count;
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String startStr = String.valueOf(start - 1);
        String finishStr = String.valueOf(finish);
        return calculate(finishStr, s, limit) - calculate(startStr, s, limit);
    }
}
