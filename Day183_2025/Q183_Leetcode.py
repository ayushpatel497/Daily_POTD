class Solution:
    MOD = 10**9 + 7

    def possibleStringCount(self, word: str, k: int) -> int:
        n = len(word)
        freq = []
        cnt = 1

        for i in range(1, n):
            if word[i] == word[i - 1]:
                cnt += 1
            else:
                freq.append(cnt)
                cnt = 1
        freq.append(cnt)

        ans = 1
        for f in freq:
            ans = (ans * f) % self.MOD

        if len(freq) >= k:
            return ans

        f = [0] * k
        g = [1] * k
        f[0] = 1

        for val in freq:
            f_new = [0] * k
            for j in range(1, k):
                f_new[j] = g[j - 1]
                if j - val - 1 >= 0:
                    f_new[j] = (f_new[j] - g[j - val - 1] + self.MOD) % self.MOD
            g_new = [0] * k
            g_new[0] = f_new[0]
            for j in range(1, k):
                g_new[j] = (g_new[j - 1] + f_new[j]) % self.MOD
            f, g = f_new, g_new

        return (ans - g[k - 1] + self.MOD) % self.MOD
