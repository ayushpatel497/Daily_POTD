import java.util.*;

class Q363_Leetcode {

    private boolean helper(int index, String nextBottom, String bottom,
                           Map<String, List<Character>> mp,
                           Map<String, Boolean> memo) {

        if (bottom.length() == 1) return true;

        if (index == bottom.length() - 1) {
            if (memo.containsKey(nextBottom)) {
                return memo.get(nextBottom);
            }
            boolean res = helper(0, "", nextBottom, mp, memo);
            memo.put(nextBottom, res);
            return res;
        }

        String key = bottom.substring(index, index + 2);
        if (!mp.containsKey(key)) return false;

        for (char ch : mp.get(key)) {
            if (helper(index + 1, nextBottom + ch, bottom, mp, memo)) {
                return true;
            }
        }
        return false;
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> mp = new HashMap<>();
        Map<String, Boolean> memo = new HashMap<>();

        for (String s : allowed) {
            String key = s.substring(0, 2);
            mp.computeIfAbsent(key, k -> new ArrayList<>()).add(s.charAt(2));
        }

        return helper(0, "", bottom, mp, memo);
    }
}
