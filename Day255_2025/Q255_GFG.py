class Solution:
    def getMinDiff(self, arr, k):
        n = len(arr)
        if n == 1:
            return 0
        
        arr.sort()
        result = arr[-1] - arr[0]
        smallest = arr[0] + k
        largest = arr[-1] - k
        
        for i in range(n - 1):
            minHeight = min(smallest, arr[i + 1] - k)
            maxHeight = max(largest, arr[i] + k)
            
            if minHeight < 0:
                continue
            
            result = min(result, maxHeight - minHeight)
        
        return result
