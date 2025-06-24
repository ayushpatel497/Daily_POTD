class Solution:
    def maxSubseq(self, s, k):
        n = len(s)
        keep = n - k
        ans = []

        for ch in s:
            while ans and k > 0 and ans[-1] < ch:
                ans.pop()
                k -= 1
            ans.append(ch)

        return ''.join(ans[:keep])
