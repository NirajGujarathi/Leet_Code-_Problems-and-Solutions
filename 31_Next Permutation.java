// c++ single line next_permutation(nums.begin(),nums.end());

// java 
class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        if(i>=0){
            int j=nums.length-1;
            while(j>i && nums[j]<=nums[i]) j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1,nums.length-1);
    }
    
    private void swap(int []nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    
    private void reverse(int []nums,int i,int j){
        while(i<j) swap(nums,i++,j--);
    }
}

/*
 Question 
 
 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]

*/

// java
public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j=nums.length-1;
            while(nums[j]<=nums[i]){
                j--; 
                // if element is smaller just decreement 
                // also if we start search from end of array any way we will get just larger tah nums[i] from end quickly         // beCUSE EARLIER WE STARTED SEARCH FOR FIRST DECREASING ELEMENT 
            }
            swap(nums,i,j);
            reversearr(nums,i+1); //leaving that element from rright onward reverse array 
            
        }
        else{
//             only reverse arr
//             if all element are in non increasing fashion then i==-1;
//             and we just want to reverse whole array to get very first combination
            reversearr(nums,i+1);
        }
        
    }
    private void reversearr(int[] arr, int st){
        int i=st;
        int j= arr.length-1;
        while(i<j){
            swap(arr,i++,j--);
        }
    }
    
    private void swap(int []nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
