class Solution:
    def uniquePerms(self, arr):
        res = []
        arr.sort()  # sorting helps handle duplicates
        used = [False] * len(arr)

        def backtrack(temp):
            if len(temp) == len(arr):
                res.append(temp[:])
                return
            for i in range(len(arr)):
                if used[i]:
                    continue
                if i > 0 and arr[i] == arr[i - 1] and not used[i - 1]:
                    continue
                used[i] = True
                temp.append(arr[i])
                backtrack(temp)
                temp.pop()
                used[i] = False

        backtrack([])
        return res
