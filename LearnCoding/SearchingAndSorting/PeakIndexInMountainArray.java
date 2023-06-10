//Problem: https://leetcode.com/problems/peak-index-in-a-mountain-array/

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0; high = arr.length-1,mid;

        while(low<high) { // = equals to not used so that it will have two elements low and high while running last time loop and we won't have to check for if (n+1) is not out of range.
            mid = low + (high-low)/2;
            if(arr[mid]<arr[mid+1]) {
                low = mid+1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
