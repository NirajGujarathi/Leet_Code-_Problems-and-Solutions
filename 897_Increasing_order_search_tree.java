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
// Approach 1
class Solution {
    TreeNode prev=null;
    TreeNode head=null;
    public TreeNode increasingBST(TreeNode root) {
         return inorder(root);    
    }
    private TreeNode inorder(TreeNode root){
        
        
        if(root==null){
            return null;  
        }
        
        inorder(root.left);
        
        if(prev!=null){
            root.left=null;
            prev.right=root;
        }
        if(head==null) head=root;
        
        prev=root;
        inorder(root.right);
        
        return head;
        
    }
}


// Approach 2
// class Solution {
//     TreeNode ans;
//     public TreeNode increasingBST(TreeNode root) {
//         TreeNode dummy=new TreeNode();
//         ans =dummy;       
//         helper(root);

//         return dummy.right;
        
//     }
//     public void helper(TreeNode root)
//     {
       
//         if(root==null){
//             return ;
//         }
//         helper(root.left);
//         root.left = null;
//         ans.right = root;
//         ans = root;
//         helper(root.right);
//     }
// }
