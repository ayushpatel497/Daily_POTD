import java.util.Arrays;

class Q252_GFG {
    public int assignHole(int[] mices, int[] holes) {
        Arrays.sort(mices);
        Arrays.sort(holes);
        int res = 0;

        for (int i = 0; i < mices.length; i++) {
            res = Math.max(res, Math.abs(holes[i] - mices[i]));
        }

        return res;
    }
}
