class Q117_GFG {
    public String multiplyStrings(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 == 0 || n2 == 0)
            return "0";

        int sign1 = 1, sign2 = 1;
        if (s1.charAt(0) == '-')
            sign1 = -1;
        if (s2.charAt(0) == '-')
            sign2 = -1;

        int isNeg = sign1 * sign2;

        int[] result = new int[n1 + n2];

        int i1 = 0, i2 = 0;

        for (int i = n1 - 1; i >= 0; i--) {
            if (s1.charAt(i) == '-')
                continue;
            int num1 = s1.charAt(i) - '0';
            int carry = 0;
            i2 = 0;
            for (int j = n2 - 1; j >= 0; j--) {
                if (s2.charAt(j) == '-')
                    continue;
                int num2 = s2.charAt(j) - '0';
                int sum = num1 * num2 + result[i1 + i2] + carry;
                carry = sum / 10;
                result[i1 + i2] = sum % 10;
                i2++;
            }
            if (carry > 0) {
                result[i1 + i2] += carry;
            }
            i1++;
        }

        int i = result.length - 1;
        while (i >= 0 && result[i] == 0)
            i--;

        if (i == -1)
            return "0";

        StringBuilder sb = new StringBuilder();
        if (isNeg == -1)
            sb.append('-');

        while (i >= 0)
            sb.append(result[i--]);

        return sb.toString();
    }
}
