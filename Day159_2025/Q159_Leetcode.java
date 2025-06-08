import java.util.*;
class Q159_Leetcode {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int x = 1;
        for (int i = 0; i < n; i++) {
            ans.add(x);
            if (x * 10 <= n) {
                x *= 10;
            } else {
                if (x >= n) x /= 10;
                x++;
                while (x % 10 == 0) x /= 10;
            }
        }
        return ans;
    }
}
