class Solution {
    public int longestPalindromeSubseq(String s) {
//         approach 1
//         int[][] dp=new int[s.length()][s.length()];
        
//         for(int i=0;i<s.length();i++){
//             dp[i][i]=1;
//         }
//         for(int i=s.length()-1;i>=0;i--){
            
//             for(int j=i+1;j<s.length();j++){
                
//                 if(s.charAt(i)==s.charAt(j)){
//                     dp[i][j]=(dp[i+1][j-1])+2;
//                 }
//                 else{
//                     dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
//                 }
//             }
            
//         }
//         return dp[0][s.length()-1];
        
        
//         approach2
        int[] dp=new int[s.length()];
        for(int i=s.length()-1;i>=0;i--){
                dp[i] = 1;
                int pre = 0;
                for (int j = i + 1; j < s.length(); j++) {
                    int tmp = dp[j];
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[j] = pre + 2;
                    }
                    else {
                        dp[j] = Math.max(dp[j], dp[j - 1]);
                    }
                    pre = tmp;
                }
        }
        return dp[s.length()-1];
    }
}
