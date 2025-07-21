class Solution:
    def compute_mobius(self, n, mu):
        is_prime = [True] * (n + 1)
        mu[0] = 0
        mu[1] = 1
        for i in range(2, n + 1):
            if is_prime[i]:
                for j in range(i, n + 1, i):
                    mu[j] *= -1
                    is_prime[j] = False
                for j in range(i * i, n + 1, i * i):
                    mu[j] = 0

    def build_freq(self, arr, freq):
        for x in arr:
            freq[x] += 1

    def compute_div_cnt(self, max_val, freq, d):
        for k in range(1, max_val + 1):
            for j in range(k, max_val + 1, k):
                d[k] += freq[j]

    def cntCoprime(self, arr):
        max_val = max(arr)
        freq = [0] * (max_val + 1)
        d = [0] * (max_val + 1)
        mu = [1] * (max_val + 1)

        self.build_freq(arr, freq)
        self.compute_div_cnt(max_val, freq, d)
        self.compute_mobius(max_val, mu)

        result = 0
        for k in range(1, max_val + 1):
            if mu[k] == 0 or d[k] < 2:
                continue
            pairs = d[k] * (d[k] - 1) // 2
            result += mu[k] * pairs

        return result
