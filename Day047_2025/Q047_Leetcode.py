from typing import List

class Solution:
    def findLexicographicallyLargestSequence(self, currentIndex: int, resultSequence: List[int], isNumberUsed: List[bool], targetNumber: int) -> bool:
        if currentIndex == len(resultSequence):
            return True

        if resultSequence[currentIndex] != 0:
            return self.findLexicographicallyLargestSequence(currentIndex + 1, resultSequence, isNumberUsed, targetNumber)

        for numberToPlace in range(targetNumber, 0, -1):
            if isNumberUsed[numberToPlace]:
                continue

            isNumberUsed[numberToPlace] = True
            resultSequence[currentIndex] = numberToPlace

            if numberToPlace == 1:
                if self.findLexicographicallyLargestSequence(currentIndex + 1, resultSequence, isNumberUsed, targetNumber):
                    return True
            elif currentIndex + numberToPlace < len(resultSequence) and resultSequence[currentIndex + numberToPlace] == 0:
                resultSequence[currentIndex + numberToPlace] = numberToPlace

                if self.findLexicographicallyLargestSequence(currentIndex + 1, resultSequence, isNumberUsed, targetNumber):
                    return True

                resultSequence[currentIndex + numberToPlace] = 0

            resultSequence[currentIndex] = 0
            isNumberUsed[numberToPlace] = False

        return False

    def constructDistancedSequence(self, n: int) -> List[int]:
        resultSequence = [0] * (n * 2 - 1)
        isNumberUsed = [False] * (n + 1)

        self.findLexicographicallyLargestSequence(0, resultSequence, isNumberUsed, n)

        return resultSequence
