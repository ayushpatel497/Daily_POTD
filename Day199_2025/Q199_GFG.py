class Solution:
    def gcd(self, a, b):
        if b == 0:
            return a
        return self.gcd(b, a % b)

    def lcm(self, a, b):
        return (a // self.gcd(a, b)) * b

    def lcmTriplets(self, n):
        if n < 3:
            return n

        if n % 2 == 1:
            return self.lcm(n, self.lcm(n - 1, n - 2))
        else:
            return max(
                self.lcm(n, self.lcm(n - 1, n - 3)),
                self.lcm(n - 1, self.lcm(n - 2, n - 3))
            )
