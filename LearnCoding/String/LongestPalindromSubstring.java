//Problem: https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1

class Solution{

    //Check DP solution also with Time Complexity:O(N^2)  and Space Complexity: O(N^2)

    // Time Complexity:O(N^2)  and Space Complexity: O(1)
    static String longestPalin(String S){
        int start= 0, maxLength = 1,left,right,n=S.length();

        for(int i=1; i<n; i++) {
            //Check for even
            left = i-1;
            right = i;
            while(left>=0 && right<n && S.charAt(left) == S.charAt(right)) {
                if(right-left+1 > maxLength) {
                    start = left;
                    maxLength = right-left+1;
                }
                left--;
                right++;
            }

            //Check for odd
            left = i-1;
            right = i+1;
            while(left>=0 && right<n && S.charAt(left) == S.charAt(right)) {
                if(right-left+1 > maxLength) {
                    start = left;
                    maxLength = right-left+1;
                }
                left--;
                right++;
            }

        }

        return S.substring(start, start+maxLength);
        
    }
}
