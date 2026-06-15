class Solution:
    def mergeOverlap(self, arr):
        ans = []
        n = len(arr)

        # temp array with sentinel interval
        temp = [[10000002, 10000002] for _ in range(n + 1)]
        for i in range(n):
            temp[i][0] = arr[i][0]
            temp[i][1] = arr[i][1]

        temp.sort()

        s, e = temp[0]
        for i in range(1, n + 1):
            cur_s, cur_e = temp[i]
            if cur_s > e:
                ans.append([s, e])
                s, e = cur_s, cur_e
            else:
                s = min(s, cur_s)
                e = max(e, cur_e)

        return ans
