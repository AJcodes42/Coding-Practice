//Problem: https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
// above question is little different but one part of that solution can require to find pivot in rotated sorted array

public class Solution {
    static int findPivot(int arr[], int low, int high) {
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(mid<high && arr[mid]>arr[mid+1]) {
                return mid;
            } else if(low<mid && arr[mid]<arr[mid-1]) {
                return mid-1;
            } else if(arr[mid]>=arr[low]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }

        static int findPivotWithDuplicates(int arr[], int low, int high) {
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(mid<high && arr[mid]>arr[mid+1]) {
                return mid;
            } else if(low<mid && arr[mid]<arr[mid-1]) {
                return mid-1;
            }
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // check whether end is pivot
                if (arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            } else if(arr[mid]>=arr[low]) { // validate
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
