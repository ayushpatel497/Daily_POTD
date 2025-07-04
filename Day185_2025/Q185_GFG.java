import java.util.HashMap;
import java.util.Map;

class Q185_GFG {
    public int countAtMostK(int[] arr, int k) {
        int n = arr.length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            
            while (map.size() > k) {
                map.put(arr[j], map.get(arr[j]) - 1);
                if (map.get(arr[j]) == 0) {
                    map.remove(arr[j]);
                }
                j++;
            }
            ans += (i - j + 1);
        }
        
        return ans;
    }
}
