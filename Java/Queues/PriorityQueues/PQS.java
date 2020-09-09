import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;

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


    public void BubbleUp(int InsertionPoint){
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
        PQS shikaa = new PQS(arr);
        System.out.println(shikaa.toString());
        // shikaa.clear();
        // System.out.println(shikaa.toString());
        shikaa.add(5);
        shikaa.add(-100);
        shikaa.add(1000000);
        shikaa.add(-300);
        shikaa.add(3);
        shikaa.add(0);

        System.out.println(shikaa.toString());

    }
    
}