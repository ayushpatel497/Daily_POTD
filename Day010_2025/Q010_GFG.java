import java.util.*;

class Q010_GFG {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // Q. Count distinct elements in every window
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Add the first k elements into the map
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        result.add(map.size());
        
        // Process the remaining windows
        for (int i = k; i < arr.length; i++) {
            // Add the current element
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            // Remove the element that goes out of the window
            map.put(arr[i - k], map.get(arr[i - k]) - 1);
            if (map.get(arr[i - k]) == 0) {
                map.remove(arr[i - k]);
            }
            result.add(map.size());
        }
        
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        Q010_GFG sol = new Q010_GFG();
        System.out.println(sol.countDistinct(arr, k));
    }
}
