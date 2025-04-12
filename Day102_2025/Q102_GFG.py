from collections import deque

class Solution:
    def floodFill(self, image, sr, sc, newColor):
        n, m = len(image), len(image[0])
        original = image[sr][sc]
        if original == newColor:
            return image
        
        q = deque()
        q.append((sr, sc))
        
        dx = [1, -1, 0, 0]
        dy = [0, 0, 1, -1]
        
        while q:
            x, y = q.popleft()
            image[x][y] = newColor
            
            for i in range(4):
                r = x + dx[i]
                c = y + dy[i]
                if 0 <= r < n and 0 <= c < m and image[r][c] == original:
                    q.append((r, c))
        
        return image
