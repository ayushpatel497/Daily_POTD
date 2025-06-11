class Solution:
    def maxDifference(self, s: str, k: int) -> int:
        def get_status(cnt_a, cnt_b):
            return ((cnt_a & 1) << 1) | (cnt_b & 1)

        n = len(s)
        ans = float('-inf')

        for a in '01234':
            for b in '01234':
                if a == b:
                    continue

                best = [float('inf')] * 4
                cnt_a = cnt_b = prev_a = prev_b = 0
                left = -1

                for right in range(n):
                    cnt_a += s[right] == a
                    cnt_b += s[right] == b

                    while right - left >= k and cnt_b - prev_b >= 2:
                        left_status = get_status(prev_a, prev_b)
                        best[left_status] = min(best[left_status], prev_a - prev_b)
                        left += 1
                        prev_a += s[left] == a
                        prev_b += s[left] == b

                    right_status = get_status(cnt_a, cnt_b)
                    opposite = right_status ^ 0b10

                    if best[opposite] != float('inf'):
                        ans = max(ans, cnt_a - cnt_b - best[opposite])

        return ans
