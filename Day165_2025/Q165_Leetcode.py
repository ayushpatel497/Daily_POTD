class Solution:
    def minMaxDifference(self, num: int) -> int:
        s = str(num)
        
        # Create max number by replacing first non-'9' digit with '9'
        max_s = s
        for c in s:
            if c != '9':
                max_s = max_s.replace(c, '9')
                break
        
        # Create min number by replacing first digit with '0'
        first = s[0]
        min_s = s.replace(first, '0')

        return int(max_s) - int(min_s)
