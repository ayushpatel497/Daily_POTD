class Solution:
    def get_permutation(self, s, current, used, permut_set):
        if len(current) == len(s):
            permut_set.add("".join(current))
            return
        
        for i in range(len(s)):
            if not used[i]:
                used[i] = True
                current.append(s[i])
                self.get_permutation(s, current, used, permut_set)
                current.pop()
                used[i] = False

    def findPermutation(self, s):
        permut_set = set()
        self.get_permutation(s, [], [False] * len(s), permut_set)
        
        answer = sorted(permut_set)  # Sorting the result
        return answer
