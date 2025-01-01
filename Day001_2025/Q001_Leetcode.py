class Solution:
    def maxScore(self, s: str) -> int:
        # Q. Maximum Score After Splitting a String
        ans = 0
        zeros = 0
        ones = s.count('1')  # Count the total number of '1's
        
        for i in range(len(s) - 1):
            if s[i] == '0':
                zeros += 1
            elif s[i] == '1':
                ones -= 1
            
            # Calculate the max score
            ans = max(ans, zeros + ones)
        
        return ans

# Driver code
if __name__ == "__main__":
    sol = Solution()
    
    # Example input
    s = "011101"
    print("Max score:", sol.maxScore(s))
    
    # Another example
    s = "00111"
    print("Max score:", sol.maxScore(s))
