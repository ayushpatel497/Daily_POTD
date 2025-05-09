class Solution:
    def __init__(self):
        self.maxNum = ""

    def findMaximumNum(self, s, k):
        def helper(s_list, k, idx):
            if k == 0:
                return

            max_digit = max(s_list[idx:])

            if max_digit != s_list[idx]:
                k -= 1

            for i in range(len(s_list) - 1, idx - 1, -1):
                if s_list[i] == max_digit:
                    s_list[i], s_list[idx] = s_list[idx], s_list[i]
                    curr = ''.join(s_list)
                    if curr > self.maxNum:
                        self.maxNum = curr
                    helper(s_list, k, idx + 1)
                    s_list[i], s_list[idx] = s_list[idx], s_list[i]  # backtrack

        self.maxNum = s
        helper(list(s), k, 0)
        return self.maxNum
