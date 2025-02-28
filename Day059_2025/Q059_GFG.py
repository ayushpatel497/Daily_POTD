class Solution:
    def evaluate(self, arr):
        st = []

        for token in arr:
            if token not in {"+", "-", "*", "/"}:
                st.append(int(token))
            else:
                x = st.pop()
                y = st.pop()

                if token == "+":
                    st.append(y + x)
                elif token == "-":
                    st.append(y - x)
                elif token == "*":
                    st.append(y * x)
                else:
                    st.append(int(y / x))  # Ensures integer division as in C++

        return st.pop()
