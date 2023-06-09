//Problem: https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1

class Solution {
    //Time Complexity: O(logn) Space Complexity: O(1)
    int count(int[] arr, int n, int x) {
        int firstIndex = firstIndex(arr,n,x);
        int lastIndex = lastIndex(arr,n,x);
        if(firstIndex == -1) {
            return 0;
        } else return lastIndex-firstIndex+1;
    }

    int firstIndex(int[] arr, int n, int x) {
        int low =0, high = n-1;
        while(low<=high) {
            int mid = low+(high-low)/2;

            // if((mid==0 && arr[mid] == x) || (arr[mid] == x && arr[mid-1] != x)) {
            //     return mid;
            // } else if(arr[mid]>x || (mid != 0 && arr[mid-1] == x)) {
            //     high = mid-1;
            // } else {
            //     low = mid+1;
            // }

            //Above logic can be optimised a little by putting conditions in this way
            if((mid==0 || arr[mid-1] < x) && arr[mid] == x) {
                return mid;
            } else if(arr[mid]<x) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;  
    }

    int lastIndex(int[] arr, int n, int x) {
        int low =0, high = n-1;
        while(low<=high) {
            int mid = low+(high-low)/2;

            // if((mid==n-1 && arr[mid] == x) || (arr[mid] == x && arr[mid+1] != x)) {
            //     return mid;
            // } else if(arr[mid]<x || (mid != n-1 && arr[mid+1] == x)) {
            //     low = mid+1;
            // } else {
            //     high = mid-1;
            // }

            //Above logic can be optimised a little by putting conditions in this way
            if((mid==n-1 || arr[mid+1]>x) && arr[mid] == x) {
                return mid;
            } else if(arr[mid]>x) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;  
    }
}
