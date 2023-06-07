//Problem: https://practice.geeksforgeeks.org/problems/smallest-divisible-number/1

class Solution {
    //Time Complexity: O(N) Space Complexity: O(1)
    public static long getSmallestDivNum(int n){
        long ans = 1;
        for(long i=1; i<=n; i++) {
            ans = (i*ans)/gcd(i,ans);
        }
        return ans;
    }

    public static long gcd(long a, long b) {
        if(a == 0) {
            return b;
        }

        return gcd(b%a,a);
    }
}