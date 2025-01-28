import java.util.*;

class Q028_GFG {
    private void getPermutation(String s, StringBuilder current, boolean[] used, Set<String> permutSet) {
        if (current.length() == s.length()) {
            permutSet.add(current.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                current.append(s.charAt(i));
                getPermutation(s, current, used, permutSet);
                current.deleteCharAt(current.length() - 1);
                used[i] = false;
            }
        }
    }

    public ArrayList<String> findPermutation(String s) {
        Set<String> permutSet = new HashSet<>();
        getPermutation(s, new StringBuilder(), new boolean[s.length()], permutSet);

        ArrayList<String> answer = new ArrayList<>(permutSet);
        Collections.sort(answer); // Sorting the result
        return answer;
    }
}
