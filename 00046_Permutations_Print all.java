// approach 1 using visited array and list add and remove from end 

class Solution {
        List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        
        permutations(nums, new boolean[nums.length],new ArrayList<Integer>(), 0,nums.length, nums.length);
        // for(List<Integer> inter: ans){   
        //     for(Integer num:inter)
        //         System.out.print(num+ " ");   
        //     System.out.println();
        // }
        
        return ans;

    }
    public void permutations(int[] nums, boolean[] visited, List<Integer> temp,int start,int end,int n){
        
        if(temp.size()==n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<end;i++){
           if(!visited[i])
           {
                visited[i]=true;
                temp.add(nums[i]);
                permutations(nums, visited, temp, start+1, end,n);
                temp.remove(temp.size()-1);
                visited[i]=false;
           }
        }
    }
}


// print all sequences 2^n
// permutaions n! 
// print all subsets


//  approrach 2 using swaps in element no need of extra vited array and temp list 
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        perm(result, nums, 0, nums.length - 1);
        return result;
    }

    public void perm(List<List<Integer>> result, int[] nums, int start, int end) {
        if (start >= end) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
        } else {
            for (int i = start; i <= end; i++) {
                swap(nums, start, i);
                perm(result, nums, start + 1, end);
                swap(nums, start, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
