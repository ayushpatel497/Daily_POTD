class Solution:
    def evaluatePostfix(self, arr):
        st = []
        
        for token in arr:
            if token in "+-*/^":
                op2 = st.pop()
                op1 = st.pop()
                
                if token == '+':
                    res = op1 + op2
                elif token == '-':
                    res = op1 - op2
                elif token == '*':
                    res = op1 * op2
                elif token == '/':
                    res = op1 // op2  # Integer division
                elif token == '^':
                    res = op1 ** op2
                
                st.append(res)
            else:
                st.append(int(token))
        
        return st[-1]
