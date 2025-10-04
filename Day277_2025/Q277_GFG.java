import java.util.ArrayList;

class Q277_GFG {
    private void help(String s, int target, int index, ArrayList<String> ans, long value, long prev, String expr) {
        if (index == s.length()) {
            if (value == target) {
                ans.add(expr);
            }
            return;
        }

        String temp = "";
        long num = 0;
        for (int i = index; i < s.length(); i++) {
            temp += s.charAt(i);
            num = num * 10 + (s.charAt(i) - '0');

            if (index == 0) {
                // first number, no operator before it
                help(s, target, i + 1, ans, num, num, temp);
            } else {
                help(s, target, i + 1, ans, value + num, num, expr + "+" + temp);
                help(s, target, i + 1, ans, value - num, -num, expr + "-" + temp);
                help(s, target, i + 1, ans, value - prev + prev * num, prev * num, expr + "*" + temp);
            }

            // avoid numbers with leading zeros
            if (s.charAt(index) == '0') break;
        }
    }

    public ArrayList<String> findExpr(String s, int target) {
        ArrayList<String> ans = new ArrayList<>();
        help(s, target, 0, ans, 0, 0, "");
        return ans;
    }
}
