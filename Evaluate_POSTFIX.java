//   Evaluate Reverse Polish Notation
// Evaluate the value of an arithmetic expression in Reverse Polish Notation.

// Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

// Note that division between two integers should truncate toward zero.

// It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.

 
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<tokens.length;++i){
            String str=tokens[i];
            if(isOp(str))
            {
                int b=st.pop();
                int a=st.pop();
                if(str.equals("+")) st.push(a+b);
                if(str.equals("-")) st.push(a-b);
                if(str.equals("*")) st.push(a*b);
                if(str.equals("/")) st.push(a/b);
                
            }
            else {
                st.push(Integer.valueOf(str));
            }
        }
        return st.peek();
    }
    public static boolean isOp(String s){
       
        if(s.equals("+") || s.equals("-") || s.equals("*")|| s.equals("/")){
            return true;
        } 
        else return false;
    }
}


// Example 1:

// Input: tokens = ["2","1","+","3","*"]
// Output: 9
// Explanation: ((2 + 1) * 3) = 9
// Example 2:

// Input: tokens = ["4","13","5","/","+"]
// Output: 6
// Explanation: (4 + (13 / 5)) = 6


