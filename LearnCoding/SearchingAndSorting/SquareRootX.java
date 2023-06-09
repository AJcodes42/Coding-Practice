//Problem: https://practice.geeksforgeeks.org/problems/square-root/1

class Solution
{
    // Time Complexity: O(logN)
    long floorSqrt(long x)
	{
	    if(x == 0 || x == 1) {
	        return 1;
	    }
		long low = 1, high = x/2;
        long mid;
        while(low<=high) {
            mid = low + (high-low)/2;
            if(mid*mid == x) {
                return mid;
            } else if(mid*mid>x) {
                high = mid-1;
            } else {
                low =  mid+1;
            }
        }

        return high;
	}
}