class Solution:
    def minParentheses(self, s: str) -> int:
        st = []
        ans = 0
        for c in s:
            if c == '(':
                st.append('(')
            else:
                if not st:
                    ans += 1
                else:
                    st.pop()
        ans += len(st)
        return ans
