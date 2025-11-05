# lightweight SortedList replacement using the standard library to avoid external dependency
import bisect

class SortedList:
    def __init__(self, iterable=None):
        self._list = []
        if iterable:
            for item in iterable:
                bisect.insort(self._list, item)

    def add(self, val):
        bisect.insort(self._list, val)

    def pop(self, index=-1):
        return self._list.pop(index)

    def remove(self, val):
        # mimic SortedList.remove (raises ValueError if not present)
        self._list.remove(val)

    def discard(self, val):
        # mimic SortedList.discard (no error if not present)
        try:
            self._list.remove(val)
        except ValueError:
            pass

    def __len__(self):
        return len(self._list)

    def __getitem__(self, idx):
        return self._list[idx]
from collections import defaultdict

class Helper:
    def __init__(self, x):
        self.x = x
        self.result = 0
        self.large = SortedList()
        self.small = SortedList()
        self.occurrences = defaultdict(int)

    def _insert_internal(self, p):
        if len(self.large) < self.x or p > self.large[0]:
            self.result += p[0] * p[1]
            self.large.add(p)
            if len(self.large) > self.x:
                transfer = self.large.pop(0)
                self.result -= transfer[0] * transfer[1]
                self.small.add(transfer)
        else:
            self.small.add(p)

    def _remove_internal(self, p):
        if self.large and p >= self.large[0]:
            self.result -= p[0] * p[1]
            self.large.remove(p)
            if self.small:
                transfer = self.small.pop(-1)
                self.result += transfer[0] * transfer[1]
                self.large.add(transfer)
        else:
            self.small.discard(p)

    def insert(self, num):
        if self.occurrences[num]:
            self._remove_internal((self.occurrences[num], num))
        self.occurrences[num] += 1
        self._insert_internal((self.occurrences[num], num))

    def remove(self, num):
        self._remove_internal((self.occurrences[num], num))
        self.occurrences[num] -= 1
        if self.occurrences[num]:
            self._insert_internal((self.occurrences[num], num))
        else:
            del self.occurrences[num]

    def get(self):
        return self.result


class Solution:
    def findXSum(self, nums, k, x):
        helper = Helper(x)
        res = []
        for i in range(len(nums)):
            helper.insert(nums[i])
            if i >= k:
                helper.remove(nums[i - k])
            if i >= k - 1:
                res.append(helper.get())
        return res
