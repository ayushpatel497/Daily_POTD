class Solution:
    def isVowel(self, c: str) -> bool:
        return c in 'aeiouAEIOU'

    def sortVowels(self, s: str) -> str:
        from collections import Counter
        
        count = Counter(c for c in s if self.isVowel(c))
        sortedVowel = "AEIOUaeiou"
        ans = []

        j = 0
        for c in s:
            if not self.isVowel(c):
                ans.append(c)
            else:
                while count[sortedVowel[j]] == 0:
                    j += 1
                ans.append(sortedVowel[j])
                count[sortedVowel[j]] -= 1

        return ''.join(ans)
