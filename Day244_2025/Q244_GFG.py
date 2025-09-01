from collections import defaultdict
from sortedcontainers import SortedDict # pyright: ignore[reportMissingImports]

class Solution:
    def sumOfModes(self, arr, k):
        n = len(arr)
        if n < k:
            return 0

        freq = defaultdict(int)
        bucket = SortedDict()
        maxFreq = 0

        def add(x):
            nonlocal maxFreq
            f = freq[x]
            if f > 0:
                bucket[f].remove(x)
                if not bucket[f]:
                    del bucket[f]
            freq[x] += 1
            bucket.setdefault(f + 1, set()).add(x)
            maxFreq = max(maxFreq, f + 1)

        def remove(x):
            nonlocal maxFreq
            f = freq[x]
            bucket[f].remove(x)
            if not bucket[f]:
                del bucket[f]
            freq[x] -= 1
            if freq[x] > 0:
                bucket.setdefault(f - 1, set()).add(x)
            if maxFreq not in bucket:
                maxFreq = max(bucket.keys()) if bucket else 0

        def getMode():
            return next(iter(bucket[maxFreq]))

        for i in range(k):
            add(arr[i])
        ans = getMode()

        for i in range(n - k):
            remove(arr[i])
            add(arr[i + k])
            ans += getMode()

        return ans
