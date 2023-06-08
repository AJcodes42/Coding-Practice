//Problem: https://practice.geeksforgeeks.org/problems/rotate-array-by-n-elements-1587115621/1

//Using juggling algorithm
class Solution
{
    //Function to rotate an array by d elements in counter-clockwise direction. 
    static void rotateArr(int arr[], int d, int n)
    {
        d = d%n;
        int gcd = gcd(d,n);
        int temp,j,k;
        for(int i=0; i<gcd; i++) {
            j = i;
            temp = arr[i];
            while(true) {
                k = j+d;
                if(k>=n) {
                    k = k -n;
                }
                if(k == i) {
                    break;
                }
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }
    
    static int gcd(int d, int n) {
        if(d==0) {
            return n;
        }
        return gcd(n%d,d);
    }