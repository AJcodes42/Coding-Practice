//Problem: Given the first 2 terms A and B of a Geometric Series. The task is to find the Nth term of the series.
/*
 * A = 1
B = 2
N = 5
Output: 16
Explanation: Common ratio = 2,
Hence second term is 1*(2)(5-1) = 24 = 16 .

 */

 class Solution {
    //Time Complexity: O(N) Space Complexity: O(1)
    public static double termOfGP(int A,int B,int N)
    {
        if(N==1) {
            return A;
        } else if(N == 2) {
            return B;
        } else {
            double R = (double)B/(double)A;
            return A*Math.pow(R, N-1);
        }
    }
}
