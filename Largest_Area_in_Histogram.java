class Solution {
    public int largestRectangleArea(int[] arr) {
        int n= arr.length;
        int[] leftsmall =new int[arr.length];
        int [] rightsmall=new int[arr.length];
        leftsmall[0]=0;
        rightsmall[n-1]=n-1;
        Stack<Integer> st=new Stack<>();
        // for greater elements next/ prev we have decreasing stack 
        // largest from sides at bottom of stack
        for(int i=0;i<n;i++){
            // leftsmall  - PSE - prev smaller element index 
            // will have incresing stack - bcz smaller
            // always smallest ever element  from ( left to right -- bcz prev ) will be at bottom of stack 
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            leftsmall[i]= (!st.isEmpty()) ? st.peek()+1 : 0;
            st.add(i);
        }
        
        st.clear();
        for(int i=n-1;i>=0;i--){
            // rightsmall - NSE - next smaller element index 
            // will have increasing stack - bcz smaller 
            // always smaller elemnt from ( right to left  -- bcz next )will be at bottom of stack 
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            rightsmall[i] = (!st.isEmpty())? st.peek()-1: n-1;
            st.add(i);
        }
        
        for(int i=0;i<n;i++){
            System.out.print(" leftS " +leftsmall[i]+" rightS "+rightsmall[i]+"\n");    
        }
        int res=0;
        for(int i=0;i<n;i++){
            res= Math.max(res, (Math.abs(rightsmall[i]-leftsmall[i]+1)* arr[i]) );
        }
        
        return res;
    }
}
