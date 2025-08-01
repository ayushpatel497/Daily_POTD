import java.util.*;

class Q213_GFG {
    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }

    public int countBalanced(String[] arr) {
        Map<Integer, Integer> balanceFreq = new HashMap<>();
        balanceFreq.put(0, 1);

        int count = 0;
        int prefixBalance = 0;

        for (String s : arr) {
            int bal = 0;
            for (char ch : s.toCharArray()) {
                if (isVowel(ch)) bal++;
                else bal--;
            }

            prefixBalance += bal;
            count += balanceFreq.getOrDefault(prefixBalance, 0);
            balanceFreq.put(prefixBalance, balanceFreq.getOrDefault(prefixBalance, 0) + 1);
        }

        return count;
    }
}
