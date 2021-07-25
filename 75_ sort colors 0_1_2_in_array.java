/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
Example 3:

Input: nums = [0]
Output: [0]
Example 4:

Input: nums = [1]
Output: [1]

*/
class Solution {
    private void swap(int []arr,int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
}
    public void sortColors(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int mid=0;
        //main role is of mid pointer
        
        while(mid<=high){
            
            if(nums[mid]==0){
                swap(nums,low,mid);
                mid++;
                low++;
            }
            else if(nums[mid]==1){
                mid++;
            }
           else  if(nums[mid]==2){
                swap(nums,mid,high);
                // mid++; // not needed bcz the same number might be 0 in case high contains 0 number at that index
                high--;
            }
        }
    }
}
