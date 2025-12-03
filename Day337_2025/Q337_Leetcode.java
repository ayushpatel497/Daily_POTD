import java.util.*;

class Q337_Leetcode {
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        float INF = 1e9f + 7;
        HashMap<Float, ArrayList<Float>> slopeToIntercept = new HashMap<>();
        HashMap<Integer, ArrayList<Float>> midToSlope = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dx = x1 - x2;
                int dy = y1 - y2;

                float k, b;

                if (x1 == x2) {
                    k = INF;
                    b = x1;
                } else {
                    k = (float) (y2 - y1) / (float) (x2 - x1);
                    b = (float) (y1 * dx - x1 * dy) / (float) dx;
                }

                int mid = (x1 + x2) * 10000 + (y1 + y2);

                slopeToIntercept
                    .computeIfAbsent(k, t -> new ArrayList<>())
                    .add(b);

                midToSlope
                    .computeIfAbsent(mid, t -> new ArrayList<>())
                    .add(k);
            }
        }

        // Step 2: Count pairs in slope→intercept groups
        for (Map.Entry<Float, ArrayList<Float>> entry : slopeToIntercept.entrySet()) {
            ArrayList<Float> list = entry.getValue();
            if (list.size() == 1) continue;

            TreeMap<Float, Integer> freq = new TreeMap<>();
            for (float b : list)
                freq.put(b, freq.getOrDefault(b, 0) + 1);

            int sum = 0;
            for (int count : freq.values()) {
                ans += sum * count;
                sum += count;
            }
        }

        // Step 3: Subtract invalid pairs from mid→slope groups
        for (Map.Entry<Integer, ArrayList<Float>> entry : midToSlope.entrySet()) {
            ArrayList<Float> list = entry.getValue();
            if (list.size() == 1) continue;

            TreeMap<Float, Integer> freq = new TreeMap<>();
            for (float k : list)
                freq.put(k, freq.getOrDefault(k, 0) + 1);

            int sum = 0;
            for (int count : freq.values()) {
                ans -= sum * count;
                sum += count;
            }
        }

        return ans;
    }
}
