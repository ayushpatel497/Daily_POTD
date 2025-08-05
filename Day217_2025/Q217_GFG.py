class Solution:
    def isPalinSent(self, s):
        i, j = 0, len(s) - 1
        while i <= j:
            curr_i = s[i].lower()
            curr_j = s[j].lower()

            if curr_i.isalnum() and curr_j.isalnum():
                if curr_i != curr_j:
                    return False
                i += 1
                j -= 1
            elif curr_i.isalnum():
                j -= 1
            elif curr_j.isalnum():
                i += 1
            else:
                i += 1
                j -= 1
        return True
