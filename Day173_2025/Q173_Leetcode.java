class Q173_Leetcode {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int groups = (n + k - 1) / k;
        String[] result = new String[groups];
        int idx = 0;

        for (int i = 0; i < n; i += k) {
            String part = s.substring(i, Math.min(i + k, n));
            if (part.length() < k) {
                StringBuilder sb = new StringBuilder(part);
                while (sb.length() < k) {
                    sb.append(fill);
                }
                part = sb.toString();
            }
            result[idx++] = part;
        }

        return result;
    }
}
