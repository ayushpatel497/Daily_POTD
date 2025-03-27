import java.util.*;

class Q086_GFG {
    // Function to find the minimum number of platforms required
    static int findPlatform(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int platform = 0, ans = 0;
        int i = 0, j = 0;
        int n = arr.length;
        
        while (i < n && j < n) {  
            if (arr[i] <= dep[j]) {  
                platform++;  
                i++;  
            } else {  
                platform--;  
                j++;  
            }  
            ans = Math.max(ans, platform);  
        }  
        
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr, dep)); // Output: 3
    }
}
