/*
Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.

Write an algorithm to minimize the largest sum among these m subarrays.

 

Example 1:

Input: nums = [7,2,5,10,8], m = 2
Output: 18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
*/

// using binary search on searach space of max sum and min sum
// time - O ( n * log(s) )


class Solution {
    public int splitArray(int[] nums, int m) {
        // ( m−1 )
        // ( n−1 )
        // number of subarrays
        int sum_max=0;
        int sum_min=nums[0];
        for(int i=0;i<nums.length;i++){
            sum_max+=nums[i];
            sum_min= Math.max(sum_min,nums[i]);
        }
        
        int low=sum_min;
        int high=sum_max;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(isPossible(nums,mid)<=m){
                high = mid-1;
                ans=mid;
            }
            else {
                low = mid+1;
            }
            
        }
        return ans;
        
    }
    
    private int isPossible(int [] nums, int maxsum){
        int sum=0;
        int m=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>maxsum){
                sum=nums[i];
                m++;
            }
        }
        // HERE M IS JUST partitons count 
        // for total subarray it is m+1
        return m+1;
            
    }
}
