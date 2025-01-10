from typing import List

class Solution:
    def count(self, s: str) -> List[int]:
        ans = [0] * 26
        for c in s:
            ans[ord(c) - ord('a')] += 1
        return ans

    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        # Q. Word Subsets
        bmax = [0] * 26
        for b in words2:
            bCount = self.count(b)
            for i in range(26):
                bmax[i] = max(bmax[i], bCount[i])

        result = []
        for a in words1:
            aCount = self.count(a)
            if all(aCount[i] >= bmax[i] for i in range(26)):
                result.append(a)

        return result


# Example usage
if __name__ == "__main__":
    words1 = ["amazon", "apple", "facebook", "google", "leetcode"]
    words2 = ["e", "o"]
    sol = Solution()
    print(sol.wordSubsets(words1, words2))