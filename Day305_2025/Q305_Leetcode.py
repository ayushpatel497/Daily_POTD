# Definition for singly-linked list.
from typing import List, Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def modifiedList(self, nums: List[int], head: Optional[ListNode]) -> Optional[ListNode]:
        num_set = set(nums)  # for O(1) lookup

        dummy = ListNode(0)
        current = dummy

        while head:
            if head.val not in num_set:
                current.next = head
                current = current.next
            head = head.next

        current.next = None
        return dummy.next
