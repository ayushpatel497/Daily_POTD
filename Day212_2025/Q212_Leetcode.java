import java.util.*;

class Q212_Leetcode {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result_ors = new HashSet<>();
        Set<Integer> current_ors = new HashSet<>();

        for (int x : arr) {
            Set<Integer> next_ors = new HashSet<>();
            next_ors.add(x);
            for (int y : current_ors) {
                next_ors.add(x | y);
            }
            result_ors.addAll(next_ors);
            current_ors = next_ors;
        }

        return result_ors.size();
    }
}
