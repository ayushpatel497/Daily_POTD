import heapq

class Node:
    def __init__(self, x):
        self.data = x
        self.next = None

    # Comparison function for heap
    def __lt__(self, other):
        return self.data < other.data

class Solution:
    def mergeKLists(self, arr):
        min_heap = []
        
        # Push all list heads into the heap
        for head in arr:
            if head:
                heapq.heappush(min_heap, head)

        dummy = Node(-1)
        tail = dummy

        while min_heap:
            top = heapq.heappop(min_heap)
            tail.next = top
            tail = top

            if top.next:
                heapq.heappush(min_heap, top.next)

        return dummy.next
