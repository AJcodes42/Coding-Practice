//Problem: https://practice.geeksforgeeks.org/problems/peak-element/1


class Solution
{
	// Function to find the peak element
	// arr[]: input array
	// n: size of array a[]
	public int peakElement(int[] arr,int n)
    {
        //One easy solution is to check 0 and n-1 first and if these are not 
        //peak then traverse from 1 to n-2 to find peak element. It will 
        //take O(N) time complexity.

        //Another approach is using binary search in O(logN) time complexity.
        // The reason it works is because on whichever side there is element
        // greater than middle, there will be peak element on that side. If both
        // left and right side has element greater than middle then on any side peak
        // element will be there and we can choose any side as we want only one
        // peak element.


        int l=0, r=n-1,m = 0;

        while(l<=r) {
            m = l+(r-l)/2;
            //if((m==0 && m+1<n && arr[m]>=arr[m+1]) || (m==n-1 && m-1>=0 && arr[m]>=arr[m-1]) || (m!=0 && m!=n-1 && arr[m]>=arr[m-1] && arr[m]>=arr[m+1]) ) {
            //optimised if used below
            if((m == 0 || arr[m - 1] <= arr[m]) && (m == n - 1 || arr[m + 1] <= arr[m])) {
                return m;
            } else if(m-1>=0 && arr[m-1]>arr[m]) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        
        return m;
    }
}
