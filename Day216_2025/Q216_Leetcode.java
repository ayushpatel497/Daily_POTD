import java.util.HashMap;
import java.util.Map;

class Q216_Leetcode {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, res = 0;

        while (j < fruits.length) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

            if (map.size() <= 2) {
                res = Math.max(res, j - i + 1);
            } else {
                map.put(fruits[i], map.get(fruits[i]) - 1);
                if (map.get(fruits[i]) == 0) {
                    map.remove(fruits[i]);
                }
                i++;
            }
            j++;
        }

        return res;
    }
}
