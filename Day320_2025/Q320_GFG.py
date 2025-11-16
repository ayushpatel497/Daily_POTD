class Solution:
    def LCIS(self, a, b):
        n = len(a)
        m = len(b)

        lcis = [0] * m

        for i in range(n):
            current = 0

            for j in range(m):
                if a[i] == b[j]:
                    if lcis[j] < current + 1:
                        lcis[j] = current + 1
                elif a[i] > b[j]:
                    if lcis[j] > current:
                        current = lcis[j]

        return max(lcis) if lcis else 0
