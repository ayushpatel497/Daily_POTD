import java.util.ArrayList;

class Q332_GFG {
    public static ArrayList<Integer> subsetXOR(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (n % 4 == 0) {
            for (int i = 1; i <= n; i++) ans.add(i);
        } 
        else if (n % 4 == 1) {
            for (int i = 1; i <= n - 2; i++) ans.add(i);
            ans.add(n);
        } 
        else if (n % 4 == 2) {
            for (int i = 2; i <= n; i++) ans.add(i);
        } 
        else { // n % 4 == 3
            for (int i = 1; i <= n - 1; i++) ans.add(i);
        }

        return ans;
    }
}
