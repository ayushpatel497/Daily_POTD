class Solution:
    def helper(self, root, current_sum, length, max_len_sum):
        if root is None:
            if length > max_len_sum[0]:
                max_len_sum[0] = length
                max_len_sum[1] = current_sum
            elif length == max_len_sum[0]:
                max_len_sum[1] = max(max_len_sum[1], current_sum)
            return

        self.helper(root.left, current_sum + root.data, length + 1, max_len_sum)
        self.helper(root.right, current_sum + root.data, length + 1, max_len_sum)

    def sumOfLongRootToLeafPath(self, root):
        if not root:
            return 0
        max_len_sum = [0, float('-inf')]  # [maxLen, maxSum]
        self.helper(root, 0, 0, max_len_sum)
        return max_len_sum[1]
