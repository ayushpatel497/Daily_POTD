import java.util.*;

class Q273_GFG {
    private void solve(int n, String curr, ArrayList<String> res) {
        if (n == 0) {
            res.add(curr);
            return;
        }
        solve(n - 1, curr + "0", res);
        solve(n - 1, curr + "1", res);
    }

    public ArrayList<String> binstr(int n) {
        ArrayList<String> res = new ArrayList<>();
        solve(n, "", res);
        return res;
    }
}
