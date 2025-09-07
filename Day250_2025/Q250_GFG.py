from typing import List, Optional
import heapq

class Node:
    def __init__(self, x):
        self.data = x
        self.next = None

class Solution:
    def mergeKLists(self, arr: List[Optional[Node]]) -> Optional[Node]:
        heap = []
        for node in arr:
            if node:
                # Push (value, unique id, node) to avoid comparison issues
                heapq.heappush(heap, (node.data, id(node), node))

        dummy = Node(-1)
        tail = dummy

        while heap:
            _, _, top = heapq.heappop(heap)
            tail.next = top
            tail = top
            if top.next:
                heapq.heappush(heap, (top.next.data, id(top.next), top.next))

        return dummy.next
