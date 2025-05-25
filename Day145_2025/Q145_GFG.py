import math

class Solution:
    def pythagoreanTriplet(self, arr):
        max_ele = max(arr)
        vis = [False] * (max_ele + 1)

        for ele in arr:
            vis[ele] = True

        for a in range(1, max_ele + 1):
            if not vis[a]:
                continue
            for b in range(1, max_ele + 1):
                if not vis[b]:
                    continue
                c2 = a * a + b * b
                c = int(math.sqrt(c2))
                if c * c == c2 and c <= max_ele and vis[c]:
                    return True
        return False
