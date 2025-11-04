from collections import Counter
import heapq

class Solution:
    def getXSum(self, frequency, x):
        max_heap = [(-freq, num) for num, freq in frequency.items()]
        heapq.heapify(max_heap)

        total = 0
        while x > 0 and max_heap:
            freq, num = heapq.heappop(max_heap)
            total += (-freq) * num
            x -= 1
        return total

    def findXSum(self, nums, k, x):
        frequency = Counter(nums[:k])
        res = [self.getXSum(frequency, x)]

        for i in range(1, len(nums) - k + 1):
            frequency[nums[i - 1]] -= 1
            if frequency[nums[i - 1]] == 0:
                del frequency[nums[i - 1]]
            frequency[nums[i + k - 1]] += 1
            res.append(self.getXSum(frequency, x))

        return res
