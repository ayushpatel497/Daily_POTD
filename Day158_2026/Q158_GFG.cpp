class Solution {
  public:
    string profession(int level, int pos) {
        // Q. Finding Profession
        // code here
        bool job = 1;
        level = ceil(log2(pos));
        int var = pow(2, level);
        while(var > 1){
            var /= 2;
            if(pos > var){
                pos -= var;
                job = !job;
            }
        }
        
        if(job) return "Engineer";
        else return "Doctor";
    }
};