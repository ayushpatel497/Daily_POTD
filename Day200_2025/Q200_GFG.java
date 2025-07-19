import java.util.*;

class Q200_GFG {
    private int fact(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public int vowelCount(String s) {
        Set<Character> vowelsSet = Set.of('a', 'e', 'i', 'o', 'u');
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (vowelsSet.contains(c)) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }

        if (freq.isEmpty()) return 0;

        int choices = 1;
        for (int count : freq.values()) {
            choices *= count;
        }

        int distinct = freq.size();
        return choices * fact(distinct);
    }
}
