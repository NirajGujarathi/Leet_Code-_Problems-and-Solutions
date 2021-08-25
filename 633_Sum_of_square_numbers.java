class Solution {
    // TC : O(n)  SC : O(n) 
//     public boolean judgeSquareSum(int c) {
//         HashSet<Integer> hs=new HashSet<>();
        
//         for(int i=0;i<= Math.sqrt(c);i++){
//             hs.add(i*i);
//             if(hs.contains(c-i*i)) return true;            
//         }
        
//         return false;
//     }
    
    
    // TC : O(n)  SC : O(1) 
    // using binary search on search space 
    public boolean judgeSquareSum(int c) {
        int left=0;
        int right=(int) Math.sqrt(c);
        
        while(left<= right ){
            int tot=left*left + right*right;
            
            if(tot==c) return true;
            else if(tot>c) right--;
            else left++;
            
        }
        
        return false;
        
    }
}
