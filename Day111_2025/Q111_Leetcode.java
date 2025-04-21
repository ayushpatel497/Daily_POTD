class Q111_Leetcode {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int minVal = 0, maxVal = 0, current = 0;
        
        for (int diff : differences) {
            current += diff;
            minVal = Math.min(minVal, current);
            maxVal = Math.max(maxVal, current);
            
            if (maxVal - minVal > upper - lower) {
                return 0;
            }
        }
        
        return (upper - lower) - (maxVal - minVal) + 1;
    }
}
