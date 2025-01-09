class Solution:
    def subarraySum(self, arr, target):
        # Q. Indexes of Subarray Sum
        start, currSum = 0, 0
        
        for end in range(len(arr)):
            currSum += arr[end]
            
            while currSum > target and start < end:
                currSum -= arr[start]
                start += 1
            
            if currSum == target:
                return [start + 1, end + 1]  # Convert to 1-based index
        
        return [-1]  # If no subarray is found


# Example Usage
if __name__ == "__main__":
    arr = [1, 2, 3, 7, 5]
    target = 12
    sol = Solution()
    print(sol.subarraySum(arr, target))