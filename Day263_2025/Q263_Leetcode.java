import java.util.*;

class Q263_Leetcode {
    private Map<List<Integer>, Integer> mpp;
    private Queue<List<Integer>> queue;
    private Map<Integer, List<Integer>> timestamps;
    private Map<Integer, Integer> st;
    private int maxSize;

    public Q263_Leetcode(int memoryLimit) {
        mpp = new HashMap<>();
        queue = new LinkedList<>();
        timestamps = new HashMap<>();
        st = new HashMap<>();
        maxSize = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        List<Integer> packet = Arrays.asList(source, destination, timestamp);
        if (mpp.containsKey(packet)) return false;

        if (queue.size() == maxSize) {
            List<Integer> res = queue.poll();
            mpp.remove(res);
            int temp = res.get(1);
            st.put(temp, st.getOrDefault(temp, 0) + 1);
        }

        queue.offer(packet);
        mpp.put(packet, 1);
        timestamps.putIfAbsent(destination, new ArrayList<>());
        timestamps.get(destination).add(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[0];
        List<Integer> res = queue.poll();
        mpp.remove(res);
        int temp = res.get(1);
        st.put(temp, st.getOrDefault(temp, 0) + 1);
        return new int[]{res.get(0), res.get(1), res.get(2)};
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!timestamps.containsKey(destination)) return 0;
        List<Integer> p = timestamps.get(destination);
        int temp = st.getOrDefault(destination, 0);

        List<Integer> subList = p.subList(temp, p.size());
        int right = Collections.binarySearch(subList, startTime);
        if (right < 0) right = -(right + 1);

        int left = Collections.binarySearch(subList, endTime);
        if (left < 0) left = -(left + 1);
        else left += 1;

        return left - right;
    }
}
