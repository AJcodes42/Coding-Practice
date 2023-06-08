//Problem: https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1


class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        int i = n-1,j = 0;
        long temp;
        while(i>=0 && j<m) {
            if(arr1[i]>arr2[j]) {
                temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
