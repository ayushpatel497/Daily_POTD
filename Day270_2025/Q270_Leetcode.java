class Q270_Leetcode {
    public double largestTriangleArea(int[][] points) {
        double res = 0.0;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    double area = 0.5 * Math.abs(
                        points[i][0] * points[j][1] + points[j][0] * points[k][1] + points[k][0] * points[i][1]
                      - points[j][0] * points[i][1] - points[k][0] * points[j][1] - points[i][0] * points[k][1]
                    );
                    res = Math.max(res, area);
                }
            }
        }

        return res;
    }
}
