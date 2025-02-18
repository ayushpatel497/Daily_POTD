class Solution:
    def buildSequence(self, currentIndex, currentCount, pattern, answer):
        if currentIndex != len(pattern):
            if pattern[currentIndex] == 'I':
                self.buildSequence(currentIndex + 1, currentIndex + 1, pattern, answer)
            else:
                currentCount = self.buildSequence(currentIndex + 1, currentCount, pattern, answer)
        
        answer.append(str(currentCount + 1))
        return currentCount + 1

    def smallestNumber(self, pattern: str) -> str:
        answer = []
        self.buildSequence(0, 0, pattern, answer)
        return ''.join(answer[::-1])
