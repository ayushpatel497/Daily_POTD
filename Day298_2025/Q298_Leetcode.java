class Q298_Leetcode {
    public int totalMoney(int n) {
        int k = n / 7; // full weeks
        int F = 28; // first week total (1+2+...+7)
        int L = 28 + (k - 1) * 7; // last full week's total
        int arithmeticSum = k * (F + L) / 2; // sum of full weeks

        int monday = 1 + k; // starting deposit for the last partial week
        int finalWeek = 0;
        for (int day = 0; day < n % 7; day++) {
            finalWeek += monday + day;
        }

        return arithmeticSum + finalWeek;
    }
}
