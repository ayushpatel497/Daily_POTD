from typing import List
class Solution:
    def prefixCount(self, words: List[str], pref: str) -> int:
        # Q. Counting Words With a Given Prefix
        count = 0
        for word in words:
            if word.startswith(pref):  # Check if the word starts with the given prefix
                count += 1
        return count


# Example Usage
if __name__ == "__main__":
    sol = Solution()
    words = ["apple", "app", "apricot", "banana"]
    pref = "ap"
    print(sol.prefixCount(words, pref))
