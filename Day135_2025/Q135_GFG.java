import java.util.HashMap;
import java.util.Map;

class Q135_GFG {
    public int countSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int sum = 0;

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int freq : map.values()) {
            sum += freq * (freq + 1) / 2;
        }

        return sum;
    }
}
