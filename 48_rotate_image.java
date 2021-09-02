//rotate image matrix by 90 degree to the right
class Solution {
    public void rotate(int[][] matrix) {
        // 90 deg rotate is performed in 2 steps 
        //transpose 
        transpose(matrix);
        //then reverse each row of matrix 
        // printarr(matrix);
        reverse_row(matrix);
        
    }
    
    private void transpose(int [][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<i;j++){
                int tmp=a[i][j];
                a[i][j]=a[j][i];
                a[j][i]=tmp;
            }
        }
    }

  
            
    private void reverse_row(int [][] a){
        for(int i=0;i<a.length;i++){
            int l=0;
            int r=a[i].length-1;
            
            while(l<r){
                int tmp=a[i][l];
                a[i][l]=a[i][r];
                a[i][r]=tmp;
                l++;
                r--;
            }
        }
        
    }
}




