// backtracing approach 
// permute all possible options 
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        solver(candidates,ans,temp,0,target);
        
        return ans;
        
    }
    
    private void solver(int[] arr, List<List<Integer>> ans, List<Integer> temp, int index, int target){
        
        if(target==0){
            ans.add(new ArrayList<>(temp));
        }
        
        for(int i=index;i<arr.length && target>=arr[i];i++){
            
            temp.add(arr[i]);
            solver(arr,ans, temp,i, target-arr[i]);            
            temp.remove(temp.size()-1);
        }
    }
}
