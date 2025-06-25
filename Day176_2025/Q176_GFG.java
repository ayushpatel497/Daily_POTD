import java.util.*;

class Q176_GFG {
    public boolean sameFreq(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        Map<Integer, Integer> freqMap = new HashMap<>();
        int n = arr.length;
        int low = 0, high = 0;

        while (low < n) {
            while (high < n && arr[low] == arr[high]) {
                high++;
            }
            int count = high - low;
            freqMap.put(count, freqMap.getOrDefault(count, 0) + 1);
            low = high;
        }

        if (freqMap.size() > 2) return false;
        if (freqMap.size() == 1) return true;

        Iterator<Map.Entry<Integer, Integer>> it = freqMap.entrySet().iterator();
        Map.Entry<Integer, Integer> first = it.next();
        Map.Entry<Integer, Integer> second = it.next();

        int len1 = first.getKey(), freq1 = first.getValue();
        int len2 = second.getKey(), freq2 = second.getValue();

        if (freq1 != 1 && freq2 != 1) return false;
        if ((len1 == 1 && freq1 == 1) || (len2 == 1 && freq2 == 1)) return true;
        if (Math.abs(len1 - len2) > 1) return false;
        if ((len1 > len2 && freq1 == 1) || (len2 > len1 && freq2 == 1)) return true;

        return false;
    }
}
