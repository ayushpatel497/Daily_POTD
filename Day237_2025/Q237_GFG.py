from typing import List

class Solution:
    def isValid(self, arr: List[int], k: int, median: int) -> bool:
        n = len(arr)
        j = n // 2
        med = -1
        
        for i in range(n - 1, -1, -1):
            diff = max(0, min(median - arr[i], k))
            
            if i == j:
                med = arr[i] + diff
            if i == j - 1 and n % 2 == 0:
                temp = arr[i] + diff
                med = (med + temp) >> 1
                
            k -= diff
        
        return med >= median

    def maximizeMedian(self, arr: List[int], k: int) -> int:
        arr.sort()
        left, right = 0, int(1e9)
        maxMedian = left
        
        while left <= right:
            mid = right - ((right - left) >> 1)
            if self.isValid(arr, k, mid):
                maxMedian = mid
                left = mid + 1
            else:
                right = mid - 1
        
        return maxMedian
