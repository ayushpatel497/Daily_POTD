from typing import List


class Solution:
    def getLongestSubsequence(self, words: List[str], groups: List[int]) -> List[str]:
        ans = []
        for i in range(len(words)):
            if i == 0 or groups[i] != groups[i - 1]:
                ans.append(words[i])
        return ans
