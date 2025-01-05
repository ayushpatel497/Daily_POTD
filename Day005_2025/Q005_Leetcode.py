from typing import List

class Solution:
    def shiftingLetters(self, s: str, shifts: List[List[int]]) -> str:
        # Q. Shifting Letters II
        n = len(s)
        shiftCount = [0] * (n + 1)

        for shift in shifts:
            shiftCount[shift[0]] += (2 * shift[2] - 1)
            shiftCount[shift[1] + 1] -= (2 * shift[2] - 1)

        ans = []
        preSum = 0
        for i in range(n):
            preSum = (preSum + shiftCount[i]) % 26
            shifted_char = chr((ord(s[i]) - ord('a') + preSum + 26) % 26 + ord('a'))
            ans.append(shifted_char)

        return ''.join(ans)


if __name__ == "__main__":
    s = input("Enter the string: ")  # Input string
    m = int(input("Enter number of shifts: "))  # Number of shifts
    shifts = []
    for _ in range(m):
        shifts.append(list(map(int, input().split())))

    sol = Solution()
    print(sol.shiftingLetters(s, shifts))
