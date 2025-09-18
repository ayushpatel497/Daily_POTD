import java.util.*;

class Q261_Leetcode {
    private PriorityQueue<int[]> tasks;
    private Map<Integer, Integer> taskPriority;
    private Map<Integer, Integer> taskOwner;

    public Q261_Leetcode(List<List<Integer>> tasksList) {
        tasks = new PriorityQueue<>((a, b) -> b[0] - a[0]); // max-heap by priority
        taskPriority = new HashMap<>();
        taskOwner = new HashMap<>();
        for (List<Integer> task : tasksList) {
            add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        tasks.offer(new int[]{priority, taskId});
        taskPriority.put(taskId, priority);
        taskOwner.put(taskId, userId);
    }

    public void edit(int taskId, int newPriority) {
        tasks.offer(new int[]{newPriority, taskId});
        taskPriority.put(taskId, newPriority);
    }

    public void rmv(int taskId) {
        taskPriority.put(taskId, -1);
    }

    public int execTop() {
        while (!tasks.isEmpty()) {
            int[] task = tasks.poll();
            int priority = task[0], taskId = task[1];
            if (taskPriority.getOrDefault(taskId, -1) == priority) {
                taskPriority.put(taskId, -1);
                return taskOwner.get(taskId);
            }
        }
        return -1;
    }
}
