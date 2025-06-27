from collections import Counter, deque

class Solution:
    def isKRepeatedSubsequence(self, s: str, t: str, k: int) -> bool:
        pos = 0
        matched = 0
        for ch in s:
            if ch == t[pos]:
                pos += 1
                if pos == len(t):
                    matched += 1
                    if matched == k:
                        return True
                    pos = 0
        return False

    def longestSubsequenceRepeatedK(self, s: str, k: int) -> str:
        freq = Counter(s)
        candidate = [ch for ch in sorted(freq.keys(), reverse=True) if freq[ch] >= k]

        queue = deque([ch for ch in candidate])
        ans = ""

        while queue:
            curr = queue.popleft()
            if len(curr) > len(ans):
                ans = curr
            for ch in candidate:
                nxt = curr + ch
                if self.isKRepeatedSubsequence(s, nxt, k):
                    queue.append(nxt)

        return ans
