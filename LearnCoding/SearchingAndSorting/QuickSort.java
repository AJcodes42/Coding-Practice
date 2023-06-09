//Problem: https://practice.geeksforgeeks.org/problems/quick-sort/1

public class Solution {
    //Function to sort an array using quick sort algorithm.
    //Time Complexity: O(N^2) worst case
    static void quickSort(int arr[], int low, int high)
    {
        int p;
        // if(low<high) {
        //     p = partition(arr,low, high);
        //     quickSort(arr, low, p-1);
        //     quickSort(arr, p+1, high);
        // }

        //Tail Call Eliminationa and optimisation
        while(low<high) {
            p = partition(arr,low, high);
            if(p-low<high-p) {
                quickSort(arr, low, p-1);
                low = p+1;
            } else {
                quickSort(arr, p+1, high);
                high = p-1;
            }
            

        }

    }
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int index = low-1;
        int temp;

        for(int i=low; i<high; i++) {
            if(arr[i]<pivot) {
                index++;
                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
        temp = arr[index+1];
        arr[index+1] = pivot;
        arr[high] = temp;
        return index+1;

    } 
}
