// can be solved using dp as well by maintaing 2 arrays from left and one from right 
// then taking Math.max( earlier_max , Math.min(left[i],right[i]);

// approach -2 optimal space time--> O(n)
// using two pointers one keeping track of last encountered one l intitalizes to -1
// second checks for next occurences of 1
// try with sample test case of 

// 0 0 1 0 1 0 0 0 --> ans=3


class Solution {
    public int maxDistToClosest(int[] seats) {
        int l=-1;
        int curr=0;
        int maxdist=0;
        for(int i=0;i<seats.length;i++){
            if(i==seats.length-1){
                curr=(i-l);
            }
            if(seats[i]==1){
                if(l==-1) {
                    curr=i;
                    l=i;      
                }   
                else {
                    curr=(i-l)/2;
                    l=i;
                }
            }
            
                
            maxdist=Math.max(curr,maxdist);
            
        }
        return maxdist;
    }
}


/*
Question
You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to the closest person.


*/
