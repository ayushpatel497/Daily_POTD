class Solution:
    def maxKPower(self, n, k):
        from collections import defaultdict
        primeFactor = defaultdict(int)

        # Prime factorization of k
        i = 2
        while i * i <= k:
            while k % i == 0:
                primeFactor[i] += 1
                k //= i
            i += 1
        if k > 1:
            primeFactor[k] += 1

        ans = float('inf')

        for p, lnk in primeFactor.items():
            powerInNFact = 0
            temp = n
            while temp > 0:
                powerInNFact += temp // p
                temp //= p

            ans = min(ans, powerInNFact // lnk)

        return ans
