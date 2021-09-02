class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int jumps=1; // at 0th position at least takes one step to get out of 0th index
        if(n<=1 ) return 0;
        int maxreach=nums[0];
        int steps=nums[0];
        for(int i=1;i<n;i++){
            if(i==n-1) return jumps;
            // if(nums[i]==0) {}
            maxreach=Math.max(maxreach, i+ nums[i]);
            steps--;
            if(steps==0){
                jumps++;
                
                // if(i>=maxreach)
                //  return -1;
                steps= maxreach-i;
            }
            
        }
        return -1; // not possible to reachat end
    }
}
