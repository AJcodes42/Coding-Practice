//Problem: https://practice.geeksforgeeks.org/problems/wave-array-1587115621/1

class Solution {
    public static void convertToWave(int n, int[] a) {
        //for sorted arrays
        // for(int i=0; i<n-1; i +=2){
        //     int temp = arr[i];
        //     arr[i] = arr[i+1];
        //     arr[i+1] = temp;
        // }

        // for unsorted arrays
        int temp;
        for(int i=0; i<n; i+=2) {
            if(i>0 && a[i-1]>a[i]) {
                temp = a[i];
                a[i] = a[i-1];
                a[i-1] = temp;
            }
            if(i<n-1 && a[i]<a[i+1]) {
                temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
            
        }
    }
}