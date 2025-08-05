class Q217_Leetcode {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        int n = baskets.length;

        for (int fruit : fruits) {
            boolean unset = true;
            for (int i = 0; i < n; i++) {
                if (fruit <= baskets[i]) {
                    baskets[i] = 0;
                    unset = false;
                    break;
                }
            }
            if (unset) count++;
        }

        return count;
    }
}
