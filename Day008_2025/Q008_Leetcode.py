from typing import List

class Solution:
    def countPrefixSuffixPairs(self, words: List[str]) -> int:
        count = 0

        for i in range(len(words)):
            for j in range(i + 1, len(words)):
                str1 = words[i]
                str2 = words[j]

                # Check if str1 is prefix and suffix of str2
                if len(str1) > len(str2):
                    continue

                if str2.startswith(str1) and str2.endswith(str1):
                    count += 1

        return count

# Example usage
if __name__ == "__main__":
    words = ["abc", "abcabc", "bc", "abcabcabc"]
    obj = Solution()
    print(obj.countPrefixSuffixPairs(words))  # Output example
