//Problem: https://practice.geeksforgeeks.org/problems/reverse-array-in-groups0255/1

class Reverse{
    
    // Function to reverse array in group of k 
    public static ArrayList<Integer> reverseInGroups(ArrayList<Integer> mv, int n, int k) {
       for(int i=0; i<n; i+=k){
           int j = Math.min(i+k-1,n-1);
           int m = i;
           while(m<j){
                int temp = mv.get(m);
                mv.set(m,mv.get(j));
                mv.set(j,temp);
                m++;
                j--;
           }
           
       }
        
       return mv; 
    }
    
    
}