class Solution:
    def minDifference(self, arr):
        op = []

        for time in arr:
            hr = 3600 * int(time[0:2])
            mint = 60 * int(time[3:5])
            sec = int(time[6:8])
            
            total = (hr + mint + sec) % 86400
            op.append(total)

        op.sort()
        n = len(op)
        ans = float('inf')

        for i in range(1, n):
            ans = min(ans, op[i] - op[i - 1])
        
        ans = min(ans, (86400 + op[0] - op[n - 1]) % 86400)
        return ans
