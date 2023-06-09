//Problem: https://www.geeksforgeeks.org/insertion-sort/

public class Solution {
    //TimeComplexity: O(N^2)
    public void insertionSort(int arr[], int n) {
        int j,temp;
        for(int i=1; i<n; i++) {
            j=i-1;
            temp = arr[i];
            while(j>=0 && arr[j]>temp) {
                arr[j+1] =arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
}
