import java.util.*;

class Q210_GFG {
    public ArrayList<Integer> asciirange(String s) {
        int n = s.length();
        int[] prefix = new int[n];
        prefix[0] = (int) s.charAt(0);
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (int) s.charAt(i);
        }

        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, new int[]{i, i});
            } else {
                map.get(ch)[1] = i;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (map.containsKey(ch)) {
                int[] range = map.get(ch);
                int l = range[0], r = range[1];
                if (r - l > 1) {
                    int sum = prefix[r - 1] - prefix[l];
                    result.add(sum);
                }
            }
        }
        return result;
    }
}
