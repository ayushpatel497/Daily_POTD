import java.util.HashMap;

class Q256_Leetcode {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int maxFreqSum(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        int vowel = 0, consonant = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int freq = mp.getOrDefault(ch, 0);
            if (isVowel(ch)) {
                vowel = Math.max(vowel, freq);
            } else {
                consonant = Math.max(consonant, freq);
            }
        }

        return vowel + consonant;
    }
}
