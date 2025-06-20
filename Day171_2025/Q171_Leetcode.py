class Solution:
    def maxDistance(self, s: str, k: int) -> int:
        latitude = 0
        longitude = 0
        ans = 0
        n = len(s)

        for i in range(n):
            if s[i] == 'N':
                latitude += 1
            elif s[i] == 'S':
                latitude -= 1
            elif s[i] == 'E':
                longitude += 1
            elif s[i] == 'W':
                longitude -= 1

            manhattan = abs(latitude) + abs(longitude)
            ans = max(ans, min(manhattan + 2 * k, i + 1))

        return ans
