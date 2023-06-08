//Problem: https://practice.geeksforgeeks.org/problems/smallest-positive-missing-number-1587115621/1

//Approach 1: By segregation 
//Time Complexity: O(N) Space Complexity: O(1)
class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        int value;
        int index = segregate(arr,size);
        for(int i=index; i<size; i++) {
            value = Math.abs(arr[i]);
            if(value+index-1<size && arr[value+index-1]>0) { // don't forget to add this part( && arr[value+index-1]) to handle duplicates so that the number don't get multiplied twice and become positive. If 2 comes twice then it will get multipled twice with -1 if this check is not there.
                arr[value+index-1] *= -1;
            }
        }
        for(int i=index; i<size; i++) {
            if(arr[i]>0) {
                return i-index+1;
            }
        }
        return size-index+1;
    }

    static int segregate(int arr[], int size) {
        int index = 0;
        int temp;
        for(int i=0 ;i<size; i++) {
            if(arr[i]<=0) {
                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                index++;
            }
        }
        return index;
    }
}


//Approach 2: Marking the index by making values greater than size
//Time Complexity: O(N) Space Complexity: O(1)
class Solution2{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size) {
        int i=0;
        for(i=0;i<size; i++) {
            if(arr[i] == 1)
                break;
        }
        if(i == size) {
            return 1;
        }
        for(i=0; i<size; i++) {
            if(arr[i]<=0 || arr[i]>size) {
                arr[i] = 1;
            }
        }
        for(i=0;i<size; i++) {
            arr[(arr[i]-1)%size] += size;
        }
        for(i=0; i<size; i++) {
            if(arr[i]<size+1) {
                return i+1;
            }
        }
        return size+1;
    }
}
