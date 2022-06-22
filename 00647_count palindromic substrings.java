//  count palindromic substrings 
class Solution {
//     Approach 1 - manacher's algorithm
//     extending palindromes from middle to even and odd lengths
    int ans=0;  //if we are not considering last char in for loop
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++){
            checker(s,i,i); //for even length
            if(i+1<s.length()) checker(s,i,i+1); 
        }
        return ans;
    }
    private void checker (String s,int i,int j){
        // System.out.println("i "+i+"j "+j);
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            ans++;
            i--;
            j++;
        }
    }
    
//  approach 2 - DP 
    public int countSubstrings(String s) {
        boolean dp[][]=new boolean[s.length()][s.length()];
        int ans=0;
        
//         using gap method - traversing diagonal wise 
        for(int g=0;g<s.length();g++){
            for(int i=0,j=g;j<dp.length;j++,i++){
                if(g==0) dp[i][j]=true;
                
                else if(g==1) dp[i][j]= s.charAt(i)==s.charAt(j);
                
                else {
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true) dp[i][j]=true;
                    else dp[i][j]=false;
                }
                
                if(dp[i][j]) ans++;
            }
        }
        return ans;
    }
}
