import java.util.*;

class Q087_GFG {
    public int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        List<int[]> activities = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            activities.add(new int[]{finish[i], start[i]});
        }

        // Sorting activities based on finish time
        activities.sort(Comparator.comparingInt(a -> a[0]));

        int count = 0, lastFinishTime = -1;

        for (int[] activity : activities) {
            if (activity[1] > lastFinishTime) { // If start time is greater than last finish time
                count++;
                lastFinishTime = activity[0]; // Update last finish time
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Q087_GFG sol = new Q087_GFG();
        int[] start = {1, 3, 2, 5};
        int[] finish = {2, 4, 3, 6};
        System.out.println(sol.activitySelection(start, finish)); // Example Output: 3
    }
}
