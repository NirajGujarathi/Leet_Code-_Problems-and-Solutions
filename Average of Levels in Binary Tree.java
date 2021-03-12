
  // Definition for a binary tree node.
 //  public class TreeNode {
 //      int val;
 //      TreeNode left;
 //      TreeNode right;
 //      TreeNode() {}
 //      TreeNode(int val) { this.val = val; }
 //      TreeNode(int val, TreeNode left, TreeNode right) {
 //          this.val = val;
 //          this.left = left;
 //          this.right = right;
 //      }
 // }

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> pQueue1 = new LinkedList<>();  
        Queue<TreeNode> pQueue2 = new LinkedList<>(); 
        List<Double> ans=new ArrayList<Double>();
        if(root==null) return ans;
        TreeNode x=root;
        pQueue1.add(x);
        int flag=0;
        int c=0;
       
        double sum=0;
        while(pQueue1.size()!=0 || pQueue2.size()!=0){
        if(flag==0){
            while(pQueue1.size()!=0){
                TreeNode t= pQueue1.poll();
                c++;
                sum+=t.val;
                if(t.left!=null) pQueue2.add(t.left); 
                if(t.right!=null) pQueue2.add(t.right);                
            }
            ans.add((double)(sum/c));
            flag=1;
                c=0;
                sum=0;
        }
        else{
            while(pQueue2.size()!=0){
                TreeNode t= pQueue2.poll();
                c++;
                sum+=t.val;
                if(t.left!=null) pQueue1.add(t.left); 
                if(t.right!=null) pQueue1.add(t.right);     
            }
            ans.add((double)(sum/c));
            flag=0;
                c=0;
                sum=0;
        }
        }
        return ans;
    }       
}
