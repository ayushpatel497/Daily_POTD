import java.util.*;

class Q324_Leetcode {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        List<Integer> res = new ArrayList<>();

        // Insert first interval's last 2 values
        res.add(intervals[0][1] - 1);
        res.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            int last = res.get(res.size() - 1);
            int secondLast = res.get(res.size() - 2);

            // Case 1: No intersection → need 2 numbers
            if (start > last) {
                res.add(end - 1);
                res.add(end);
            }
            // Case 2: Only the last one intersects → need 1 number
            else if (start == last) {
                res.add(end);
            }
            // Case 3: Only one of the existing elements intersects → need 1 number
            else if (start > secondLast) {
                res.add(end);
            }
        }

        return res.size();
    }
}
