class Solution {
    int getGCD(int a , int b){
        if(a == 0) return b;
        return getGCD(b % a, a);
    }
  public:
    int pairCount(int x, int y) {
        // Q. Pairs with Given GCD and LCM
        // code here
        int left = 1;
        int right = y;
        int ans = 0;
        while(left <= right){
            if((left * right) < (x * y)){
                left++;
            }else if((left * right) > (x * y)){
                right--;
            }else{
                int GCD = getGCD(left , right);
                int LCM = (left * right) / GCD;
                if(GCD == x && LCM == y){
                    ans = ans + (left == right ? 1 : 2);
                }
                left++;
                right--;
            }
        }
        return ans;
    }
};