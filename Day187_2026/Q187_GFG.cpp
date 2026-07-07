class Solution {
  public:
    int maxPathSum(vector<int> &a, vector<int> &b) {
        // Q. Max Sum Path in Two Arrays
        // Code here
        int pointsA = 0, pointsB = 0, sizeOfA = a.size(), sizeOfB = b.size(), ans = 0, sumA = 0, sumB = 0;
        
        while ((pointsA < sizeOfA) && (pointsB < sizeOfB)) {
            if (a[pointsA] == b[pointsB]) {
                ans += max(sumA, sumB) + a[pointsA];
                pointsA++;
                pointsB++;
                sumA = 0;
                sumB = 0;
            } else if (a[pointsA] < b[pointsB]) {
                sumA += a[pointsA];
                pointsA++;
            } else {
                sumB += b[pointsB];
                pointsB++;
            }
        }
        
        while (pointsA < sizeOfA) {
                sumA += a[pointsA];
                pointsA++;
        }
        
        while (pointsB < sizeOfB) {
                sumB += b[pointsB];
                pointsB++;
        }
        
        ans += max(sumA, sumB);
        
        return ans;
    }
};