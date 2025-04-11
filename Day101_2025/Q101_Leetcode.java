class Q101_Leetcode {
    public int countSymmetricIntegers(int low, int high) {
        int res = 0;

        for (int num = low; num <= high; num++) {
            String s = Integer.toString(num);
            int len = s.length();
            if (len % 2 != 0) continue; // skip odd-digit numbers

            int half = len / 2;
            int leftSum = 0, rightSum = 0;

            for (int i = 0; i < half; i++) {
                leftSum += s.charAt(i) - '0';
                rightSum += s.charAt(i + half) - '0';
            }

            if (leftSum == rightSum) {
                res++;
            }
        }

        return res;
    }
}
