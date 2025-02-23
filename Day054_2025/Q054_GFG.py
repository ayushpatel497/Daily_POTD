from typing import List

class Solution:
    def nextLargerElement(self, arr: List[int]) -> List[int]:
        n = len(arr)
        ans = [-1] * n
        st = [-1]
        
        # Process elements from right to left
        for i in range(n - 1, -1, -1):
            if arr[i] < st[-1]:
                ans[i] = st[-1]
                st.append(arr[i])
            else:
                while st[-1] != -1 and arr[i] >= st[-1]:
                    st.pop()
                ans[i] = st[-1]
                st.append(arr[i])
        return ans
