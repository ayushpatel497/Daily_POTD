class Solution:
    def majorityElement(self, arr):
        count = 0
        candidate = -1
        n = len(arr)

        # Phase 1: Find candidate
        for num in arr:
            if count == 0:
                candidate = num
                count = 1
            elif num == candidate:
                count += 1
            else:
                count -= 1

        # Phase 2: Verify candidate
        count = sum(1 for num in arr if num == candidate)

        return candidate if count > n // 2 else -1
