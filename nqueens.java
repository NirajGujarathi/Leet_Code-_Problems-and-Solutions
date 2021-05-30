// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
// Given an integer n, return the number of distinct solutions to the n-queens puzzle.

// Example 1:

// Input: n = 4
// Output: 2
// Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
// Example 2:

// Input: n = 1
// Output: 1

class Solution {
    static int c;
    public int totalNQueens(int n) {
        String s="";
        c=0;
        if(n==1 || n==0) return n;
        nqueens(new int[n][n],s,0);       
        return c;
    }
    public static void nqueens(int [][] a, String s, int row){ 
        if(row==a.length)
        {   
            c++;
            System.out.println(s + " ans --> " +c);
        }
            
        for(int col=0;col<a.length;col++){
            if(is_it_safe(a,row,col)==true){
                a[row][col]=1;
                nqueens(a,s+row+"-"+col+",",row+1);
                a[row][col]=0;
            }
        }

    }
    public static boolean is_it_safe(int[][] a, int row, int col){
        // column checking
        for(int i=row-1,j=col;i>=0;i--){
            if(a[i][j]==1) return false;
        }
        // diagonal 1 checking
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(a[i][j]==1) return false;
        }
        // diagonal 2  checking
        for(int i=row-1,j=col+1;i>=0 && j<a.length;i--,j++){
            if(a[i][j]==1) return false;
        }
        return true;
    }
}

