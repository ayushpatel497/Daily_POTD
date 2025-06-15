class Solution:
    def maxDiff(self, num: int) -> int:
        s = str(num)

        def replace(s, x, y):
            return ''.join([y if c == x else c for c in s])

        # max_num: replace first non-'9' with '9'
        max_num = s
        for c in s:
            if c != '9':
                max_num = replace(s, c, '9')
                break

        # min_num: replace first digit with '1' or later digit with '0'
        min_num = s
        for i in range(len(s)):
            c = s[i]
            if i == 0:
                if c != '1':
                    min_num = replace(s, c, '1')
                    break
            else:
                if c != '0' and c != s[0]:
                    min_num = replace(s, c, '0')
                    break

        return int(max_num) - int(min_num)
