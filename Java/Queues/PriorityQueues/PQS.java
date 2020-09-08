import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;

public class PQS<T extends Comparable<T>>{
    
    private int heapSize = 0;
    private int heapCapacity = 0;
    private List<T> heap = null;
    private Map<T,TreeSet<Integer> > map = new HashMap<>(); 

    public PQS(){
        this(1);
    }

    public PQS(int sz){
        heap = new ArrayList<T>(sz);
    }
    
}