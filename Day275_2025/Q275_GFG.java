import java.util.*;

class Q275_GFG {
    private void backtrack(int start, int k, int target, 
                           List<Integer> current, 
                           List<ArrayList<Integer>> result) {
        if (k == 0 && target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (k == 0 || target <= 0) return;

        for (int i = start; i <= 9; i++) {
            current.add(i);
            backtrack(i + 1, k - 1, target - i, current, result);
            current.remove(current.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }
}
