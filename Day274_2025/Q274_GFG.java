import java.util.*;

class Q274_GFG {
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr); // sorting to help avoid duplicates
        backtrack(arr, new boolean[arr.length], new ArrayList<>(), ans);
        return ans;
    }

    private static void backtrack(int[] arr, boolean[] used, ArrayList<Integer> temp,
                                  ArrayList<ArrayList<Integer>> ans) {
        if (temp.size() == arr.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;
            // skip duplicates
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            temp.add(arr[i]);
            backtrack(arr, used, temp, ans);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}
