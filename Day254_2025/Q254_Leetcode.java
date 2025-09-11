class Q254_Leetcode {
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public String sortVowels(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                count[c]++;
            }
        }

        String sortedVowel = "AEIOUaeiou";
        StringBuilder ans = new StringBuilder();
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!isVowel(c)) {
                ans.append(c);
            } else {
                while (count[sortedVowel.charAt(j)] == 0) {
                    j++;
                }
                ans.append(sortedVowel.charAt(j));
                count[sortedVowel.charAt(j)]--;
            }
        }

        return ans.toString();
    }
}
