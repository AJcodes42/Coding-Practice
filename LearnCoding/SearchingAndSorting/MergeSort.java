//Problem: https://practice.geeksforgeeks.org/problems/merge-sort/1

class Solution
{
    //Time Complexity: O(nlogn) Space Complexity: O(n)
    void merge(int arr[], int l, int m, int r)
    {
        int p = m-l+1;
        int q = r-m;

        int a1[] = new int[p];
        int a2[] = new int[q];

        for(int i=0; i<p; i++) {
            a1[i] = arr[l+i];
        }

        for(int i=0; i<q; i++) {
            a2[i] = arr[m+1+i];
        }

        int i=0,j=0,k = l;

        while(i<p && j<q) {
            if(a1[i]<a2[j]) {
                arr[k] = a1[i];
                i++;
            } else {
                arr[k] = a2[j];
                j++;
            }
            k++;
        }

        while(i<p) {
            arr[k] = a1[i];
            i++;
            k++;
        }

        while(j<q) {
            arr[k] = a2[j];
            j++;
            k++;
        }

    }
    void mergeSort(int arr[], int l, int r)
    {
        if(l<r) {
            int m = l + (r-l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr,l,m,r);
        }
    }
}
