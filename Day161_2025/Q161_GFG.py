class Solution:
    def countStrings(self, s): 
        arr = [0] * 256
        count = 0
        flag = False

        for i in range(len(s)):
            count += len(s) - i - 1
            count -= arr[ord(s[i])]
            if arr[ord(s[i])] != 0:
                flag = True
            arr[ord(s[i])] += 1

        return count + int(flag)
