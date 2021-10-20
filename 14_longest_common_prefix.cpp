//  using divide and conquer strategy  nlogn 
/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 
*/
class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string ans="";
        
        return solver(strs,0,strs.size()-1);
    }
    
    string solver(vector<string> &strs, int l,int r){
        if(l==r) return strs[l];
        
        else{
            int m=(l+r)/2;
            string lcpleft=solver(strs,l,m);
            string lcpright=solver(strs,m+1,r);
            
            return common(lcpleft,lcpright);
        }
        
    }
    
    string common(string left,string right){
        int lmin=min(left.size(), right.size());
        for(int i=0;i<lmin;i++){
            if(left[i]!=right[i]){
                return left.substr(0,i); 
            }
        }
        return left.substr(0,lmin);
    }
};

