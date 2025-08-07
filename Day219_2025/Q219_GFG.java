import java.util.*;

class Q219_GFG {
    public int minDifference(String[] arr) {
        List<Integer> op = new ArrayList<>();
        
        for (String time : arr) {
            int hr = 3600 * Integer.parseInt(time.substring(0, 2));
            int mint = 60 * Integer.parseInt(time.substring(3, 5));
            int sec = Integer.parseInt(time.substring(6, 8));
            
            int total = hr + mint + sec;
            total = total % 86400;  // seconds in a day
            op.add(total);
        }

        Collections.sort(op);
        int n = op.size();
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, op.get(i) - op.get(i - 1));
        }

        ans = Math.min(ans, (86400 + op.get(0) - op.get(n - 1)) % 86400);
        return ans;
    }
}
