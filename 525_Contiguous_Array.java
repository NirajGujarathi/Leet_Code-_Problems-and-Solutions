/*
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.


Algorithm

This approach relies on the same premise as the previous approach. 
But, we need not use an array of size \text{2n+1}2n+1, since it isn't necessary that we'll encounter all the countcount values possible. 
Thus, we make use of a HashMap mapmap to store the entries in the form of (index, count)(index,count).
We make an entry for a countcount in the mapmap whenever the countcount is encountered first, 
and later on use the correspoding index to find the length of the largest subarray with equal no. of zeros and ones when the same countcount is encountered again.

*/

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> hm =new HashMap<>();   // key=count , value =index where we got this count 
        int count=0;
        hm.put(0,-1);
        int maxwindow=0;
        for(int i=0;i<nums.length;i++){
            int n=nums[i];
            if(n==0) count--;
            else if(n==1) count++;
            
            if(!hm.containsKey(count)){
                hm.put(count, i);
            }
            else{
                int val=i-hm.get(count);
                maxwindow=Math.max(maxwindow, (val));
            }
        }
        
       return maxwindow;
    }
}
