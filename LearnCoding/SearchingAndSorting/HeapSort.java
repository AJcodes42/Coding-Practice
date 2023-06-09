//Problem: https://practice.geeksforgeeks.org/problems/heap-sort/1

class Solution
{
    //Function to build a Heap from array.
    // Time Complexity: O(n)
    void buildHeap(int arr[], int n)
    {
        int startIndex = n/2-1;
        
        for(int i=startIndex; i>=0; i--) {
            heapify(arr,n,i);
        }
    }
 
    //Heapify function to maintain heap property.
    // Time Complexity to heapify single node: O(logn)
    void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int lChild = 2*i+1;
        int rChild = 2*i+2;
        
        if(lChild<n && arr[lChild]>arr[largest]) {
            largest = lChild;
        }
        if(rChild<n && arr[rChild]>arr[largest]) {
            largest = rChild;
        }
        
        if(largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr,n,largest);
        }
    }
    
    //Function to sort an array using Heap Sort.
    //Time Complexity of heap sort: O(nlogn)
    public void heapSort(int arr[], int n)
    {
        buildHeap(arr,n);
        int temp;
        for(int i=n-1; i>0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr,i,0);
        }
    }
 }
