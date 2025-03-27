class Solution:
    # Function to find the minimum number of platforms required
    def minimumPlatform(self, arr, dep):
        arr.sort()
        dep.sort()
        
        platform = 0
        ans = 0
        i, j = 0, 0
        n = len(arr)
        
        while i < n and j < n:
            if arr[i] <= dep[j]:
                platform += 1
                i += 1
            else:
                platform -= 1
                j += 1
            ans = max(ans, platform)
        
        return ans

# Example Usage
arr = [900, 940, 950, 1100, 1500, 1800]
dep = [910, 1200, 1120, 1130, 1900, 2000]
sol = Solution()
print(sol.minimumPlatform(arr, dep))  # Output: 3
