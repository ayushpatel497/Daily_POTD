from collections import deque

class Solution:
    def maxOfSubarrays(self, arr, k):
        ans = []
        dq = deque()
        n = len(arr)

        for i in range(n):
            # Remove elements from the back if they are smaller than the current element
            while dq and arr[dq[-1]] < arr[i]:
                dq.pop()
            dq.append(i)

            # Remove elements from the front if they are out of the current window
            if dq[0] <= i - k:
                dq.popleft()

            # Add the maximum element of the window to the result
            if i >= k - 1:
                ans.append(arr[dq[0]])

        return ans
