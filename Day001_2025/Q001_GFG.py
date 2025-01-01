from collections import defaultdict

class Solution:
    def anagrams(self, arr):
        '''
        words: list of words
        return: list of groups of anagrams
        '''
        # Code here
        # Q. Print Anagrams Together
        ans = []
        um = defaultdict(list)
        
        for word in arr:
            sorted_word = ''.join(sorted(word))
            um[sorted_word].append(word)
        
        for group in um.values():
            if len(group) > 0:
                ans.append(group)
        
        return ans

# Driver code
if __name__ == "__main__":
    t = int(input())
    while t > 0:
        arr = input().split()
        
        sol = Solution()
        result = sol.anagrams(arr)
        
        # Sorting the groups lexicographically
        result.sort(key=lambda group: group[0])
        
        for group in result:
            print(" ".join(group))
        print("~")
        
        t -= 1
