from collections import defaultdict

class Solution:
    def countBalanced(self, arr):
        def is_vowel(ch):
            return ch in 'aeiou'
        
        balance_freq = defaultdict(int)
        balance_freq[0] = 1

        count = 0
        prefix_balance = 0

        for s in arr:
            bal = 0
            for ch in s:
                if is_vowel(ch):
                    bal += 1
                else:
                    bal -= 1

            prefix_balance += bal
            count += balance_freq[prefix_balance]
            balance_freq[prefix_balance] += 1

        return count
