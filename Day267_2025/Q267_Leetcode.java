import java.util.*;

class Q267_Leetcode {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder ans = new StringBuilder();

        // sign handling
        if ((numerator > 0) ^ (denominator > 0)) {
            ans.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        long q = num / den;
        long r = num % den;

        ans.append(q);

        if (r == 0) return ans.toString();

        ans.append(".");
        Map<Long, Integer> map = new HashMap<>();

        while (r != 0) {
            if (map.containsKey(r)) {
                int pos = map.get(r);
                ans.insert(pos, "(");
                ans.append(")");
                break;
            }
            map.put(r, ans.length());
            r *= 10;
            q = r / den;
            r %= den;
            ans.append(q);
        }

        return ans.toString();
    }
}
