class Solution:
    def sumK(self, root, k):
        def recursion(node, k, curr_sum, prefix_sum, answer):
            if not node:
                return

            curr_sum += node.data
            answer[0] += prefix_sum.get(curr_sum - k, 0)
            prefix_sum[curr_sum] = prefix_sum.get(curr_sum, 0) + 1

            recursion(node.left, k, curr_sum, prefix_sum, answer)
            recursion(node.right, k, curr_sum, prefix_sum, answer)

            prefix_sum[curr_sum] -= 1
            if prefix_sum[curr_sum] == 0:
                del prefix_sum[curr_sum]

        answer = [0]
        prefix_sum = {0: 1}
        recursion(root, k, 0, prefix_sum, answer)
        return answer[0]
