//Problem: https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/

//Time Complexity: O(logn) Space Complexity: O(1)
class Solution {
    int power(int x, int y) {
        int temp;
        if(y == 0) {
            return 1;
        }
        temp = power(x, y/2);
        if(y%2 == 0) {
            temp *=temp;
        } else {
            temp = temp*temp*x;
        }
        return temp;
    }

    //power for negative y and float x
    float power(float x, int y) {
        float temp;
        if(y == 0) {
            return 1;
        }
        temp = power(x,y/2);
        if(y%2 == 0) {
            temp *=temp;
        } else {
            if(y>0) {
                temp *=temp;
            } else {
                temp = (temp*temp)/x;
            }
        }
        return temp;
    }

    //iterative solution for power
    int powerIterative(int x , int y) {
        int temp = 1;
        while(y>0) {
            if(y%2 != 0) {
                temp *=x;
            }
            y /=2;
            x *=x;
        }
        return temp;
    }
}
