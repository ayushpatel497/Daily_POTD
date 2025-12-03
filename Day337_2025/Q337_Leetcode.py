class Solution:
    def countTrapezoids(self, points):
        n = len(points)
        INF = 1e9 + 7

        slope_to_intercept = {}
        mid_to_slope = {}
        ans = 0

        for i in range(n):
            x1, y1 = points[i]
            for j in range(i + 1, n):
                x2, y2 = points[j]

                dx = x1 - x2
                dy = y1 - y2

                if x1 == x2:
                    k = INF
                    b = float(x1)
                else:
                    k = (y2 - y1) / (x2 - x1)
                    b = (y1 * dx - x1 * dy) / dx

                mid = (x1 + x2) * 10000 + (y1 + y2)

                slope_to_intercept.setdefault(k, []).append(b)
                mid_to_slope.setdefault(mid, []).append(k)

        # Count valid pairs
        for lst in slope_to_intercept.values():
            if len(lst) == 1:
                continue

            freq = {}
            for b in lst:
                freq[b] = freq.get(b, 0) + 1

            sum_ = 0
            for count in sorted(freq.values()):
                ans += sum_ * count
                sum_ += count

        # subtract invalid pairs
        for lst in mid_to_slope.values():
            if len(lst) == 1:
                continue

            freq = {}
            for k in lst:
                freq[k] = freq.get(k, 0) + 1

            sum_ = 0
            for count in sorted(freq.values()):
                ans -= sum_ * count
                sum_ += count

        return ans
