class Solution {
    int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    int lcm(int a, int b){
        return (a/gcd(a, b) * b);
    }
    
public:
    int lcmTriplets(int n) {
        // Q. LCM Triplet
        // code here
        if(n < 3) return n;
        
        if(n & 1) return lcm(n, lcm(n-1, n-2));
        else {
            return max(lcm(n, lcm(n-1, n-3)), lcm(n-1, lcm(n-2, n-3)));
        }
    }
};