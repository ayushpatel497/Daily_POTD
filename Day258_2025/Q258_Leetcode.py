class Solution:
    def canBeTypedWords(self, text: str, brokenLetters: str) -> int:
        broken = set(brokenLetters)
        words = text.split()
        count = 0

        for word in words:
            if not any(c in broken for c in word):
                count += 1

        return count
