class Solution:
    def countAtMostK(self, arr, k):
        from collections import defaultdict
        
        count = defaultdict(int)
        ans = 0
        j = 0
        
        for i in range(len(arr)):
            count[arr[i]] += 1
            
            while len(count) > k:
                count[arr[j]] -= 1
                if count[arr[j]] == 0:
                    del count[arr[j]]
                j += 1
            
            ans += i - j + 1
            
        return ans
