import java.util.Arrays;

class Q113_GFG {
    public int[] singleNum(int[] arr) {
        int xor_all = 0;
        for (int num : arr) {
            xor_all ^= num;
        }

        // Find rightmost set bit
        int mask = xor_all & -xor_all;
        int a = 0, b = 0;

        for (int num : arr) {
            if ((num & mask) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        int[] result = new int[]{a, b};
        Arrays.sort(result);
        return result;
    }
}
