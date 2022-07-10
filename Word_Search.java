class Solution {
    public boolean exist(char[][] board, String word) {
        boolean visited [][] =new boolean[board.length][board[0].length];
        boolean ans = false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    ans =  dfs(board, visited, word, i, j, 0);
                }
                if(ans ==true) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] b, boolean vist[][], String word, int i,int j, int k){
        if(i<0 || j<0 || i>=b.length || j>=b[0].length || k>=word.length() || vist[i][j] || b[i][j]!=word.charAt(k)){
            return false;
        }
        if(k==word.length()-1 && word.charAt(k)==b[i][j]) return true;
        vist[i][j]=true;
        
        boolean ans = false ;
        if(b[i][j] == word.charAt(k))
        {
          ans = ( dfs(b,vist,word,i+1,j,k+1) || dfs(b,vist,word,i-1,j,k+1) || 
                       dfs(b,vist,word,i,j+1,k+1) || dfs(b,vist,word,i,j-1,k+1) );
            
        }
        vist[i][j]=false;
        
        return ans;

    }
}
