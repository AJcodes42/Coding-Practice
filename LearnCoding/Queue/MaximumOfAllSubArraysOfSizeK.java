//Problem: https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1

class solve{
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Deque<Integer> queue =  new LinkedList<Integer>();
        int i;
        for(i=0; i<k; i++){
            while(!queue.isEmpty() && arr[i]>=arr[queue.peekLast()]){
                queue.removeLast();
            }
            queue.addLast(i);
        }
        
        for(;i<n;i++){
            result.add(arr[queue.peek()]);
            
            while(!queue.isEmpty() && i-k>=queue.peekFirst()){
                queue.removeFirst();
            }
            while(!queue.isEmpty() && arr[i]>=arr[queue.peekLast()]){
                queue.removeLast();
            }
            
            queue.addLast(i);
            
        }
        result.add(arr[queue.peek()]);
        return result;
    }
}
