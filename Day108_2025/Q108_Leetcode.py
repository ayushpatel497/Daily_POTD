class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1:
            return "1"
        
        prev_say = self.countAndSay(n - 1)
        curr_say = ""
        count = 1
        
        for i in range(len(prev_say)):
            if i + 1 < len(prev_say) and prev_say[i] == prev_say[i + 1]:
                count += 1
            else:
                curr_say += str(count) + prev_say[i]
                count = 1
        
        return curr_say
