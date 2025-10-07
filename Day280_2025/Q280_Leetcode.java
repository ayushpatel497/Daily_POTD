import java.util.*;

class Q280_Leetcode {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        TreeSet<Integer> dryDays = new TreeSet<>();
        HashMap<Integer, Integer> fullLakes = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1;  // default value for dry days
            } else {
                ans[i] = -1;  // raining day
                
                if (fullLakes.containsKey(rains[i])) {
                    Integer dryDay = dryDays.higher(fullLakes.get(rains[i]));
                    if (dryDay == null) {
                        return new int[0]; // no dry day available, flood occurs
                    }
                    ans[dryDay] = rains[i]; // dry this lake
                    dryDays.remove(dryDay);
                }
                
                fullLakes.put(rains[i], i);
            }
        }
        return ans;
    }
}
