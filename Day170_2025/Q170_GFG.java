class Q170_GFG {
    public static String caseSort(String s) {
        int n = s.length();
        int[] lower = new int[26];
        int[] upper = new int[26];

        // Count frequency
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower[ch - 'a']++;
            } else {
                upper[ch - 'A']++;
            }
        }

        StringBuilder result = new StringBuilder();
        int l = 0, u = 0;

        for (int i = 0; i < n; i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                while (lower[l] == 0) l++;
                result.append((char) ('a' + l));
                lower[l]--;
            } else {
                while (upper[u] == 0) u++;
                result.append((char) ('A' + u));
                upper[u]--;
            }
        }

        return result.toString();
    }
}
