class Solution:
    def __init__(self):
        self.cnt = 0

    def merge(self, low, mid, high, a):
        temp = []
        left, right = low, mid + 1

        while left <= mid and right <= high:
            if a[left] <= a[right]:
                temp.append(a[left])
                left += 1
            else:
                temp.append(a[right])
                right += 1
        
        while left <= mid:
            temp.append(a[left])
            left += 1
        while right <= high:
            temp.append(a[right])
            right += 1

        for i in range(low, high + 1):
            a[i] = temp[i - low]

    def count_pairs(self, low, mid, high, a):
        right = mid + 1
        for i in range(low, mid + 1):
            while right <= high and a[i] > 2 * a[right]:
                right += 1
            self.cnt += (right - (mid + 1))

    def merge_sort(self, low, high, a):
        if low >= high:
            return
        mid = (low + high) // 2
        self.merge_sort(low, mid, a)
        self.merge_sort(mid + 1, high, a)
        self.count_pairs(low, mid, high, a)
        self.merge(low, mid, high, a)

    def countRevPairs(self, arr):
        self.cnt = 0
        self.merge_sort(0, len(arr) - 1, arr)
        return self.cnt
