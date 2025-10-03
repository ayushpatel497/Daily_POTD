class Solution:
    def solve(self, i, n, arr, mapping, tmp, ans):
        if i >= n:
            ans.append("".join(tmp))
            return
        if arr[i] == 0 or arr[i] == 1:
            self.solve(i + 1, n, arr, mapping, tmp, ans)
        else:
            for ch in mapping[arr[i]]:
                tmp.append(ch)
                self.solve(i + 1, n, arr, mapping, tmp, ans)
                tmp.pop()

    def possibleWords(self, arr):
        mapping = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
        ans = []
        self.solve(0, len(arr), arr, mapping, [], ans)
        return ans
