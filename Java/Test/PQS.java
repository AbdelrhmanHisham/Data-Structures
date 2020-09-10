import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.PriorityQueue;
public class PQS<T extends Comparable<T>>{
    
    private int heapSize = 0;
    private int Root = 0;
    private int heapCapacity = 0;
    private List<T> heap = null;
    private Map<T,TreeSet<Integer> > map = new HashMap<>(); 

        public PQS(){
            this(1);
        }


        public PQS(int sz){
            heap = new ArrayList<T>(sz);
        }
        
        public PQS(T[] elements){
            heapCapacity=heapSize = elements.length;
            heap = new ArrayList<T>(heapCapacity);

            for (int i=0 ; i<elements.length ; i++){
                heap.add(elements[i]);
            }
            for(int parent = Math.max(0,(heapSize/2)-1) ; parent >= 0 ; parent--){
                BubbleDown(parent);
            }
        }

        public int size(){
            return heapSize;
        }
        public void clear() {
            for (int i = 0 ; i <heapSize ; i++){
                heap.set(i,null);
            }
            heapSize=0;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public T peek() {
            return heap.get(Root);
        }  

        public boolean contains(T elm){
            for(int i = 0 ; i < heapSize ; i++){
                if (heap.get(i).equals(elm)){
                    return true;
                }
            }
            return false;
        }

        public int linearSearch(T elm){
            for(int i = 0 ; i < heapSize ; i++){
                if (heap.get(i).equals(elm)){
                    return i;
                }
            }
            return -1;
        }
    


    public void add(T elem){
        if (elem == null) throw new IllegalArgumentException();
        
        heap.add(elem);
        BubbleUp(heapSize);
        heapSize++;
        // if (heapSize < heapCapacity) {
        //     heap.set(heapSize, elem);
        //   } else {
        //     heap.add(elem);
        //     heapCapacity++;
        //   }
      
        //   BubbleUp(heapSize);
        //   heapSize++;



    }


    private void BubbleUp(int InsertionPoint){
        while(true){
            int parent = (InsertionPoint-1)/2;

            if (InsertionPoint >0 && less(InsertionPoint , parent)){
                Swap(InsertionPoint,parent);
                InsertionPoint = parent; 
            }else{
                break;
            }
        }
    }
// public int remove( T elem){

//     int index = linearSearch(elem);
//     Swap(index,size()-1);

//     // heap.set(size()-1,null);
//     heap.remove(size()-1);
//     System.out.println(index + " :Index");
//     System.out.println(heapSize + " :heapsize");
//     if(index == (heapSize-1))return index;
//     BubbleDown(index);
//     if (heap.get(index).equals(elem))BubbleUp(index);

//     heapSize--;

//     return index;
// }
// public T removeAt( int index){

//     T data = heap.get(index);
//     remove(data);
//     return data;
// }




//********************************************* */
public boolean remove(T element) {
    if (element == null) return false;
    // Linear removal via search, O(n)
    for (int i = 0; i < heapSize; i++) {
      if (element.equals(heap.get(i))) {
        removeAt(i);
        return true;
      }
    }
    return false;
  }

  // Removes a node at particular index, O(log(n))
  private T removeAt(int i) {
    if (isEmpty()) return null;

    heapSize--;
    T removed_data = heap.get(i);
    Swap(i, heapSize);

    // clear the value
    heap.set(heapSize, null);

    // Check if the last element was removed
    if (i == heapSize) return removed_data;
    // T elem = heap.get(i);

    // Try sinking element
    BubbleDown(i);

    // If sinking did not work try swimming
    if (heap.get(i).equals(removed_data)) BubbleUp(i);
    return removed_data;
  }
/******************************************************** */
        private boolean less(int i,int j){
            T node1 = heap.get(i);
            T node2 = heap.get(j);

            return node1.compareTo(node2) <=0;
        } 


        private void Swap(int i,int j){
            T node1 = heap.get(i);
            T node2 = heap.get(j);

            heap.set(i,node2);
            heap.set(j,node1);
        } 

        
        private void BubbleDown(int parent_index){
            while(true){
                int right = 2*parent_index+1;
                int left = 2*parent_index+2;
                int smallest = left;
                if (right < heapSize && less(right,left)){
                    smallest =right;
                }
                if(left >= heapSize ||less(parent_index,smallest)){
                    break;
                }
                Swap(parent_index , smallest);
                parent_index = smallest;
            }
        }



        @Override
        public String toString(){
            return heap.toString();
        } 

    public static void main(String[] args) {
        Integer [] arr = {10,2,3,50,100 , 0 , -1 , 50000 , -30};
        int [] arr2 = {10,2,3,50,100 , 0 , -1 , 50000 , -30};
        PQS shikaa = new PQS(arr);
        PriorityQueue pq = new PriorityQueue();
        for(int i =0; i < arr.length ; i++){
            pq.add(arr[i]);
        }

        System.out.println(shikaa.toString() + "Abdo");
        System.out.println(pq.toString());

        shikaa.remove(-30);
        // shikaa.remove(0);
        shikaa.remove(100);
        // shikaa.remove(-1);
        shikaa.remove(50);
        shikaa.remove(2);
        shikaa.remove(10);
        shikaa.remove(50000);
        shikaa.remove(3);

        pq.remove(-30);
        pq.remove(0);
        pq.remove(100); 

        System.out.println(shikaa.toString()+ "Abdo");
        System.out.println(pq.toString());



    }
    
}