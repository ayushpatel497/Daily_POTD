class Solution:
    def bestClosingTime(self, customers: str) -> int:
        minPenalty = 0
        curPenalty = 0
        earliestHour = 0

        for i, ch in enumerate(customers):
            if ch == 'Y':
                curPenalty -= 1
            else:
                curPenalty += 1

            if curPenalty < minPenalty:
                minPenalty = curPenalty
                earliestHour = i + 1

        return earliestHour
