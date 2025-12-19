import java.util.Arrays;

class Q353_GFG {
    public int findMoves(int[] chairs, int[] passengers) {
        Arrays.sort(chairs);
        Arrays.sort(passengers);

        int n = chairs.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += Math.abs(passengers[i] - chairs[i]);
        }

        return sum;
    }
}
