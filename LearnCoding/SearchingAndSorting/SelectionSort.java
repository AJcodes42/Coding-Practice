//Problem: https://www.geeksforgeeks.org/selection-sort/

public class Solution {
    //TimeComplexity: O(N^2)
    public void selectionSort(int arr[], int n) {
        //finds min index and move it to starting

        int min = 0,temp;
        for(int i=0; i<n-1; i++) {
            min = i;
            for(int j=i+1; j<n; j++) {
                if(arr[min]>arr[j]) {
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }    
}
