/*
Solutions → 
Traverse whole 2d array 
Time complexity  O(n*m) space complexity =  O(1) */

/* My solution -
Time complexity  O(n + m logm ) space complexity =  O(1)
First check all last column values of each row if it exceeds target break loop and store that row number
Now it is sure that number lies in that row ; now perform binary search 
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=0;
        int col=matrix[0].length-1;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][col]==target){
                return true;
            }
            else if(matrix[i][col]>target){
                row=i;
                break;
            }
        }
        
        int l=0;
        int r=col;
        
        while(l<=r){
            int mid=(l+r)/2;
            if(mid<0 && mid>col-1) return false;
            if(matrix[row][mid]==target){
                return true;
            }
            else if(matrix[row][mid]<target){
                l=mid+1;
            }
            else if(matrix[row][mid]>target){
                r=mid-1;
            }
        }
        
        return false;
    }
}

/*
Optimal solution - Further optimization log(n*m) using binary search
Time complexity  O(log(n*m) ) space complexity =  O(1)
l=0 r=rows*cols -1 
To get mid index i=mid/cols  and j=mid%cols 


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        
        int l=0;
        int r=m*n -1;
        
        while(l<=r){
            int mid =(l+r)/2;
            
            if(matrix[mid/n][mid%n] == target) return true;
            else 
            if(matrix[mid/n][mid%n] > target) r=mid-1;
            else l=mid+1;
        }
        return false ;
        
    }
}

*/





/*
Optimal solution
Time complexity  O(n+m)
i=0 ; j=n-1 while(j>=0 && i <m)
If found, return true also can return the indices.
Else if greater that of target reduce j → column check lower columns (j--)
Else if current element smaller then check next row where we can get larger element   (i++)
Same approach is used for the gfg problem.
/*
