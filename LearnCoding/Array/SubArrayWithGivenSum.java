//Problem: https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
//Note: Refer the following for arrays containing negative elements: https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/

class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int curr_sum = 0;
        int left = 0;
        int right = 0;
        for(; right<n; right++) {
            curr_sum += arr[right];
            if(curr_sum>s) {
                while(curr_sum>s && left<right) {
                    curr_sum -=arr[left];
                    left++;
                }
            }
            if(curr_sum == s) {
                break;
            }
        }
        
        if(right == n) {
            ans.add(-1);
        } else {
            ans.add(left+1);
            ans.add(right+1);
        }
        
        return ans;
    }
}