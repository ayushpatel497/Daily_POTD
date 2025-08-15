class Solution:
    def insertInterval(self, intervals, newInterval):
        start, end = newInterval
        ans = []
        c = -1
        
        for a, b in intervals:
            if b < start:
                ans.append([a, b])
            elif c == -1 and max(a, start) <= min(b, end):
                start = min(start, a)
                end = max(end, b)
            else:
                if c == -1:
                    c = 0
                    ans.append([start, end])
                ans.append([a, b])
        
        if c == -1:
            ans.append([start, end])
        return ans
