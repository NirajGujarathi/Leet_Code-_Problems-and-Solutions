 // approach 1 is similar to stock buy and sell here instead of tracking minsofar we track the max so far so that we can partition the array from the previously maximum point 

/*
Given an array nums, partition it into two (contiguous) subarrays left and right so that:

Every element in left is less than or equal to every element in right.
left and right are non-empty.
left has the smallest possible size.
Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.

 

Example 1:

Input: nums = [5,0,3,8,6]
Output: 3
Explanation: left = [5,0,3], right = [8,6]
Example 2:

Input: nums = [1,1,1,0,6,12]
Output: 4
Explanation: left = [1,1,1,0], right = [6,12]

*/

class Solution {
    public int partitionDisjoint(int[] nums) {
        
        //Approach 1 Time O(n) and space O(1)
        //kadance approach
    
        int maxtilli=nums[0];
        int maxsofar=nums[0];
        int partition=0;
        int c=0;
        for(int i=1;i<nums.length;++i){
            // maxtilli=Math.max(nums[i],maxtilli);
            if(maxtilli<nums[i]) maxtilli=nums[i];
            if(nums[i]< maxsofar){
                c++;
                maxsofar=maxtilli;
                partition=i;
            }
        }
        System.out.println(c);
        return partition+1;
        
        
        //Approach 2  Time O(n) and space O(2n)
//         int [] left=new int[nums.length];
//         int [] right=new int[nums.length];
//         //left max
//         int leftmax=Integer.MIN_VALUE;
//         for(int i=0;i<nums.length;++i){
//             leftmax=Math.max(leftmax,nums[i]);
//             left[i]=leftmax;
//         }
        
//         //right max
//         int rightmin=Integer.MAX_VALUE;
//         for(int i=nums.length-1;i>=0;--i){
//             rightmin=Math.min(rightmin,nums[i]);
//             right[i]=rightmin;
//         }
//         // int ans=-1;
//         for(int i=1;i<nums.length;++i){
//             if(left[i-1] <= right[i]){
//                 return i;
//             }
//         }
//         return 0;
    }
}
