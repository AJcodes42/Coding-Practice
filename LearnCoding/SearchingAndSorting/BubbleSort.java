//Problem: https://www.geeksforgeeks.org/bubble-sort/

public class Solution {
    //TimeComplexity: O(N^2)
    public void bubbleSort(int arr[], int n) {
        //Note: first make max element to end
        for(int i=0;i<n-1; i++) {
            for(int j=0; j<n-i-1; j++) {
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
