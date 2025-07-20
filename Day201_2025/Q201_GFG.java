class Solution {
    public int countValid(int n, int[] arr) {
        boolean hasZero = false;
        for (int digit : arr) {
            if (digit == 0) {
                hasZero = true;
                break;
            }
        }

        int total = 9 * (int)Math.pow(10, n - 1);
        int notValid = (int)Math.pow(10 - arr.length, n);
        
        if (!hasZero) {
            notValid -= (int)Math.pow(10 - arr.length, n - 1);
        }

        return total - notValid;
    }
}
