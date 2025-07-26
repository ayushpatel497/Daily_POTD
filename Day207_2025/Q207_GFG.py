class Solution:
    def findMajority(self, arr):
        count1 = count2 = 0
        ele1 = el2 = 0

        for num in arr:
            if count1 == 0 and num != el2:
                ele1 = num
                count1 = 1
            elif count2 == 0 and num != ele1:
                el2 = num
                count2 = 1
            elif num == ele1:
                count1 += 1
            elif num == el2:
                count2 += 1
            else:
                count1 -= 1
                count2 -= 1

        count1 = count2 = 0
        for num in arr:
            if num == ele1:
                count1 += 1
            if num == el2:
                count2 += 1

        res = []
        votes = len(arr)
        if count1 > votes // 3:
            res.append(ele1)
        if count2 > votes // 3 and el2 != ele1:
            res.append(el2)

        if len(res) == 2 and res[0] > res[1]:
            res[0], res[1] = res[1], res[0]

        return res
