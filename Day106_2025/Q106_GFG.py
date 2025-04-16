class Solution:
    def floydWarshall(self, dist):
        n = len(dist)
        for k in range(n):
            for i in range(n):
                for j in range(n):
                    if dist[i][k] != -1 and dist[k][j] != -1:
                        new_dist = dist[i][k] + dist[k][j]
                        if dist[i][j] == -1 or new_dist < dist[i][j]:
                            dist[i][j] = new_dist
