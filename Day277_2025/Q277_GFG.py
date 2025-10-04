class Solution:
    def help(self, s, target, index, expr, value, prev, ans):
        if index == len(s):
            if value == target:
                ans.append(expr)
            return

        num = 0
        for i in range(index, len(s)):
            num = num * 10 + int(s[i])
            temp = s[index:i+1]

            if index == 0:
                self.help(s, target, i + 1, temp, num, num, ans)
            else:
                self.help(s, target, i + 1, expr + "+" + temp, value + num, num, ans)
                self.help(s, target, i + 1, expr + "-" + temp, value - num, -num, ans)
                self.help(s, target, i + 1, expr + "*" + temp, value - prev + prev * num, prev * num, ans)

            # stop if number starts with 0
            if s[index] == "0":
                break

    def findExpr(self, s, target):
        ans = []
        self.help(s, target, 0, "", 0, 0, ans)
        return ans
