class Q008_Leetcode {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        for (int i = 0; i < words.length; ++i) {
            for (int j = i + 1; j < words.length; ++j) {
                String str1 = words[i];
                String str2 = words[j];

                // Check if str1 is prefix and suffix of str2
                if (str1.length() > str2.length()) 
                    continue;

                if (str2.startsWith(str1) && str2.endsWith(str1)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String[] words = {"abc", "abcabc", "bc", "abcabcabc"};
        Q008_Leetcode obj = new Q008_Leetcode();
        System.out.println(obj.countPrefixSuffixPairs(words)); // Example usage
    }
}
