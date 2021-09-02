/*
45. Jump Game II

Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

DP solution takes O(n^2) while below appraoch uses O(n) 
*/



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
