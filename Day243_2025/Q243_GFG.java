class Q243_GFG {
    public int maxWater(int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        int ans = 0;
        
        while (left < right) {
            int tempwater = Math.min(arr[left], arr[right]) * (right - left);
            ans = Math.max(ans, tempwater);
            
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
