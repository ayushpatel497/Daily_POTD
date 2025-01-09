class Q009_Leetcode {
    public int prefixCount(String[] words, String pref) {
        // Q. Counting Words With a Given Prefix
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) { // Check if the word starts with the given prefix
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Q009_Leetcode sol = new Q009_Leetcode();
        String[] words = {"apple", "app", "apricot", "banana"};
        String pref = "ap";
        System.out.println(sol.prefixCount(words, pref)); // Example Usage
    }
}
