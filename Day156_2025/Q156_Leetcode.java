class Q156_Leetcode {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        char[] ch = new char[26];
        for (int i = 0; i < 26; i++) {
            ch[i] = (char) ('a' + i);
        }

        for (int i = 0; i < s1.length(); i++) {
            char a = ch[s1.charAt(i) - 'a'];
            char b = ch[s2.charAt(i) - 'a'];
            char toReplace = (char) Math.max(a, b);
            char replaceWith = (char) Math.min(a, b);
            for (int j = 0; j < 26; j++) {
                if (ch[j] == toReplace) {
                    ch[j] = replaceWith;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            result.append(ch[c - 'a']);
        }

        return result.toString();
    }
}
