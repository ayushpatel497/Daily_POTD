import java.util.*;

class Q088_GFG {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        List<int[]> jobs = new ArrayList<>();
        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{profit[i], deadline[i]});
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        jobs.sort((a, b) -> Integer.compare(b[0], a[0])); // Sort by profit in descending order
        TreeSet<Integer> slots = new TreeSet<>();

        for (int i = 1; i <= maxDeadline; i++) {
            slots.add(i);
        }

        int totalProfit = 0, jobCount = 0;

        for (int[] job : jobs) {
            Integer availableSlot = slots.floor(job[1]);
            if (availableSlot != null) {
                totalProfit += job[0];
                jobCount++;
                slots.remove(availableSlot);
            }
        }

        return new ArrayList<>(Arrays.asList(jobCount, totalProfit));
    }

    public static void main(String[] args) {
        Q088_GFG sol = new Q088_GFG();
        int[] deadlines = {2, 1, 2, 1, 3};
        int[] profits = {100, 50, 10, 20, 30};
        System.out.println(sol.jobSequencing(deadlines, profits)); // Example Output
    }
}
