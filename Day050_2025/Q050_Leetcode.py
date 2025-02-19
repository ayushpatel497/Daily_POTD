class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        total = 3 * (1 << (n - 1))  # Total happy strings
        if k > total:
            return ""

        result = ['a'] * n
        next_smallest = {'a': 'b', 'b': 'a', 'c': 'a'}
        next_greatest = {'a': 'c', 'b': 'c', 'c': 'b'}

        startA, startB, startC = 1, 1 + (1 << (n - 1)), 1 + 2 * (1 << (n - 1))

        if k < startB:
            result[0] = 'a'
            k -= startA
        elif k < startC:
            result[0] = 'b'
            k -= startB
        else:
            result[0] = 'c'
            k -= startC

        for char_index in range(1, n):
            midpoint = (1 << (n - char_index - 1))
            if k < midpoint:
                result[char_index] = next_smallest[result[char_index - 1]]
            else:
                result[char_index] = next_greatest[result[char_index - 1]]
                k -= midpoint

        return "".join(result)
