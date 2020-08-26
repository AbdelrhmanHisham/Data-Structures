@SuppressWarnings("unchecked")
public class DynamicArrays<T>{
    
    T [] Darr;
    int len =0;      // user-lenght 
    private int capacity; // Acual capacity of the Dynamic array


    public int get_capacity(){
        return this.capacity;
    }
    public DynamicArrays(){
        this(10);                 
    }


    public DynamicArrays(int capacity)
    {
        //check if the user enter a wrong capacity (must be > 0)
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity : " + capacity);

        this.capacity = capacity;
        Darr = (T[]) new Object[capacity];  //create the array 
    }


    public int size(){
        return len;
    }
    

    public T get(int index){
        return Darr[index];
    }
    
    public void clear(){
        for (int i =0 ; i< len ; i++){
            Darr[i] = null;
        }
        len = 0;
    }
    
    public boolean isEmpty(){
       if (len ==0){
           return true;
       }else{
           return false;
       }
       
    }

    public void set(int index , T element){
        if (index < 0 || index >= len)throw new IndexOutOfBoundsException();
        Darr[index] = element; 

    } 

    public void add(T element)
    {
        if (len+1 >= capacity){
            if (capacity ==0)
            {
                capacity=1;
            }else{
        capacity *=2;   
        T[] new_Darr = (T[])new Object[capacity]; //create a new one with double size
        for (int i =0 ; i < len ; i++){
            new_Darr[i] = Darr[i];
        }
        Darr = new_Darr;
    } 
        }
        Darr[len++] = element;
    }


    

}