/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.

You must do it in place.
*/

class Solution {
    // constant space O(1)
    public void setZeroes(int[][] matrix) {
        boolean firstrow=false;
        boolean firstcol=false;
        
        int m=matrix.length;
        int n=matrix[0].length;
        
        for(int i=0;i<n;i++){
            if(matrix[0][i]==0) {
                firstrow=true; break;
            }
        }
        
        
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0) {
                firstcol=true; break;
            }
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    
                        matrix[i][0]=0;
                        matrix[0][j]=0;
                    
                }
            }
        }
        
        for(int i=1;i<m;i++){
            if(matrix[i][0]==0)
                rowtozero(matrix,i,m,n);
        }
        
        
        for(int j=1;j<n;j++){
            if(matrix[0][j]==0)
                coltozero(matrix,j,m,n);
        }
        
        if(firstrow)                 rowtozero(matrix,0,m,n);
        if(firstcol)                 coltozero(matrix,0,m,n);
        
    }
    
    
    private void rowtozero(int[][] mat,int row,int m,int n){
        for(int i=0;i<n;i++) mat[row][i]=0;
    }
    
    private void coltozero(int[][] mat,int col,int m,int n){
        for(int i=0;i<m;i++) mat[i][col]=0;
    }
}
