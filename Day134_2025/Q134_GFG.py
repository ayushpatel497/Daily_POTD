class Solution:
    def convert(self, num: str) -> str:
        ans = ""
        count = 1
        digit = num[0]

        for i in range(1, len(num)):
            if num[i] == digit:
                count += 1
            else:
                ans += str(count) + digit
                digit = num[i]
                count = 1
        ans += str(count) + digit
        return ans

    def countAndSay(self, n: int) -> str:
        if n == 1:
            return "1"
        previous = self.countAndSay(n - 1)
        return self.convert(previous)
