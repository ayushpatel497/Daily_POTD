import java.util.ArrayList;

class Q276_GFG {
    private void solve(int i, int n, int[] arr, String[] map, StringBuilder tmp, ArrayList<String> ans) {
        if (i >= n) {
            ans.add(tmp.toString());
            return;
        }
        if (arr[i] == 0 || arr[i] == 1) {
            solve(i + 1, n, arr, map, tmp, ans);
        } else {
            for (char ch : map[arr[i]].toCharArray()) {
                tmp.append(ch);
                solve(i + 1, n, arr, map, tmp, ans);
                tmp.deleteCharAt(tmp.length() - 1);
            }
        }
    }
    
    public ArrayList<String> possibleWords(int[] arr) {
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> ans = new ArrayList<>();
        solve(0, arr.length, arr, map, new StringBuilder(), ans);
        return ans;
    }
}
