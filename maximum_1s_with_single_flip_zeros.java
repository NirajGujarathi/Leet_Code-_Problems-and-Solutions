/* Given an array which only consists of 0s and 1s. 
Write a code to find the maximum number of consecutive 1s in an array, if we can flip at most one 0.
*/

import java.util.*;

class Solution {
    public int solve(String s) {
        int first = 0;
        int max1s = 0;
        int zeros = 0;
        for (int second = 0; second < s.length(); ++second) {
            if (s.charAt(second) == '0') {
                zeros++;
            }

            while (zeros > 1) { // change this based on how many 0s you can flip

                // as soon as I get 0s in first pointer position then reduces zeros count and window
                // is modified
                if (s.charAt(first) == '0') {
                    zeros--;
                }
                first++;
            }
            max1s = Math.max(max1s, (second - first + 1));
        }
        return max1s;
    }
}


/*
Intuition
Two pointers 'first' and 'second' are used two maintain window which fetches maximum numbers of 1s if we flip at most one zero to 1.
Here , prefix sum concept is used in order to maintain the count of zeros encountered so far.

Implementation
'first' - represents the start of window.

'second' - represents the end of window.

'zeros' - it is counter variable for counting total number of zeros encountered so far (zeros count till the end of window) - also this counter is useful to maintain at most one zero in the window so that we can flip it to make maximum possible 1s in the defined window of string.

'max1s' - it stores the maximum 1s in substring so far; that can be formed after the flip of at-most one zero.

Time Complexity
O(n) - (one pass with 2 pointers concept) solution is computed in single traversal of String

Space Complexity
O(1) - No additional memory required (constant space)

*/
