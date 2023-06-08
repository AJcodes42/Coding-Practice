//Problem: https://practice.geeksforgeeks.org/problems/remove-duplicate-elements-from-sorted-array/1

class Solution {
    int remove_duplicate(int A[],int N){
        int resultLength =0;
        
        for(int i=0; i<A.length-1; i++) {
            if(A[i] != A[i+1]) {
                A[resultLength] = A[i];
                resultLength++;
            }
        }
        A[resultLength] = A[A.length-1];
        return resultLength+1;
    }

    int remove_duplicate2(int A[],int N){
        int index =1;
        for(int i=0; i<A.length - 1; i++) {
            if(A[i]!=A[i+1]) {
                A[index++] = A[i+1];
            }
        } 
        return index;
    }
}