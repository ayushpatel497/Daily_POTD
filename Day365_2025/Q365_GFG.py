class Solution:
    def reverse(self, head):
        prev = None

        while head:
            nxt = head.next
            head.next = prev
            prev = head
            head = nxt

        return prev

    def isPalindrome(self, head):
        if not head or not head.next:
            return True

        slow = head
        fast = head

        # find middle
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        first = head
        second = self.reverse(slow)

        # compare halves
        while second:
            if first.data != second.data:
                return False
            first = first.next
            second = second.next

        return True
