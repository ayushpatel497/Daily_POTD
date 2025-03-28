class Solution:
    def activitySelection(self, start, finish):
        activities = sorted(zip(finish, start))  # Sort based on finish time

        count = 0
        last_finish_time = -1

        for f, s in activities:
            if s > last_finish_time:  # If start time is greater than last finish time
                count += 1
                last_finish_time = f  # Update last finish time
                
        return count

# Example Usage
sol = Solution()
start = [1, 3, 2, 5]
finish = [2, 4, 3, 6]
print(sol.activitySelection(start, finish))  # Example Output: 3
