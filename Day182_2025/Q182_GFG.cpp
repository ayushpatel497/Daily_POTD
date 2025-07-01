class Solution {
    bool isvalid(string temp,int val){
        int cnt=0;
        int arr[26] = {0};
        for(char ch:temp){
            arr[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(arr[i]>0)
            cnt++;
        }
        return cnt==val;
    }
    
  public:
    int substrCount(string &s, int k) {
        // Q. Substrings of length k with k-1 distinct elements
        // code here
        int n = s.size();
        
        if(k>n)
        return 0;
        int ans =0;
        for(int i=0;i<=n-k;i++){
            string temp = s.substr(i,k);
            if(isvalid(temp,k-1))
            ans+=1;
        }
        return ans;
    }
};