/*

Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.

A leaf is a node with no children.  --> also calculates sum of all paths 
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        System.out.println(traverse(root,0,targetSum,ls,ans));  // also calculates sum of all paths 
        return ans;
    }
    
    private int traverse(TreeNode root,int parent,int targetSum,List<Integer> ls, List<List<Integer>> ans){
        if(root==null) return 0;
        
        parent = parent + root.val;
        ls.add(root.val);
        if(root.left==null && root.right==null) 
        {
            if(parent == targetSum){
                ans.add(new ArrayList<>(ls));
                ls.remove(ls.size()-1);
                return parent;
            }
             ls.remove(ls.size()-1);
            return parent;
        }
        
        
        int a=traverse(root.left,parent,targetSum, ls, ans);
         
            
        int b=traverse(root.right,parent,targetSum, ls, ans);
        
        ls.remove(ls.size()-1);
        
        return a+b;
        
    }
}
