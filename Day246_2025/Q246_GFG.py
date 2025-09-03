class Solution:
    def reverse(self, head):
        if not head:
            return None
        if not head.next:
            return head

        fast = head
        while fast.next:
            fast = fast.next

        slow = head
        while slow != fast and slow.prev != fast:
            slow.data, fast.data = fast.data, slow.data
            slow = slow.next
            fast = fast.prev

        return head
