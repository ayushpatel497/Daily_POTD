class Solution:
    def colorTheGrid(self, m: int, n: int) -> int:
        from collections import defaultdict

        mod = 10**9 + 7
        valid = {}
        mask_end = 3 ** m

        # Generate valid column patterns
        for mask in range(mask_end):
            color = []
            mm = mask
            for _ in range(m):
                color.append(mm % 3)
                mm //= 3
            if all(color[i] != color[i + 1] for i in range(m - 1)):
                valid[mask] = color

        # Build compatible mask map
        adjacent = defaultdict(list)
        for mask1, color1 in valid.items():
            for mask2, color2 in valid.items():
                if all(color1[i] != color2[i] for i in range(m)):
                    adjacent[mask1].append(mask2)

        f = [0] * mask_end
        for mask in valid:
            f[mask] = 1

        for _ in range(1, n):
            g = [0] * mask_end
            for mask2 in valid:
                for mask1 in adjacent[mask2]:
                    g[mask2] = (g[mask2] + f[mask1]) % mod
            f = g

        return sum(f) % mod
