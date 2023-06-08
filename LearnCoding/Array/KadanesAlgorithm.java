/*
 * Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.
 * N = 5
Arr[] = {1,2,3,-2,5}
Output:
9
Explanation:
Max subarray sum is 9
of elements (1, 2, 3, -2, 5) which 
is a contiguous subarray.
 */

class Solution
{
    long maxSubarraySum(int arr[], int n){
        //1st Approach
        // int start = 0,s=0, end = 0,max_sum = arr[0],max_ending_here = arr[0];

        // for(int i=1;i<n; i++) {
        //     max_ending_here += arr[i];
        //     if(max_sum<max_ending_here) {
        //         max_sum = max_ending_here;
        //         start = s;
        //         end = i;
        //     }
        //     if(max_ending_here<0) {
        //         max_ending_here = 0;
        //         s = i+1;
        //     }
        // }
        // return max_sum;


        //2nd Approach
        int currSum = arr[0];
        int maxSum = arr[0];
        int start = 0;
        int end = 0;
        
        for(int i=1; i<n; i++) {
            currSum = Math.max(arr[i], currSum+arr[i]); // comparison between arr element and (currSum + array element)
            //maxSum = Math.max(maxSum,currSum);
            if(currSum>maxSum) {
                maxSum = currSum;
                end = i;
            }
        }

        start = endIndex;
        int globalMax = maxSum;
 
        while (start >= 0) {
            globalMax -= arr[start];
            if (globalMax == 0)
                break;
            startIndex--;
        }
        
        return maxSum;
    }

}