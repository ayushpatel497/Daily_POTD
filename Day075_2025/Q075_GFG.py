class Solution:
    def minJumps(self, arr):
        n = len(arr)
        if n <= 1:
            return 0  # Already at the last index
        if arr[0] == 0:
            return -1  # Can't move forward
        
        maxReach = arr[0]  # Max index reachable
        step = arr[0]  # Steps remaining in the current jump
        jumps = 1  # Number of jumps taken

        for i in range(1, n):
            if i == n - 1:
                return jumps  # If reached the last index
            
            maxReach = max(maxReach, i + arr[i])
            step -= 1

            if step == 0:
                jumps += 1  # Increase jumps
                if i >= maxReach:
                    return -1  # Can't move further
                step = maxReach - i  # Update steps for the next jump
        
        return -1
