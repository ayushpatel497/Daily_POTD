class Solution:
    def numberOfWays(self, n):
        # Base cases
        if n == 1:
            return 1
        if n == 2:
            return 2

        last_second = 1
        last = 2

        for i in range(3, n + 1):
            current = last + last_second
            last_second = last
            last = current

        return last
