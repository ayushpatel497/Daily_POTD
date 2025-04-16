class Q106_GFG {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (dist[i][k] != -1 && dist[k][j] != -1) {
                        int newDist = dist[i][k] + dist[k][j];
                        if (dist[i][j] == -1 || newDist < dist[i][j]) {
                            dist[i][j] = newDist;
                        }
                    }
                }
            }
        }
    }
}
