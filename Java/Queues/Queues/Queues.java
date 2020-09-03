public class Queues<T> implements Iterable<T>{

    private java.util.LinkedList<T> list = new java.util.LinkedList<T>(); 

public Queues(){

}
public Queues(T elm){
 list.add(elm);   
}

public int size(){
    return list.size();
}

public boolean empty(){
    return size()==0;
}

public void enqueue(T elm) {
    list.add(elm);
}

public T dequeue() {
    if (empty()) throw new RuntimeException("Queue Empty");
    T data = list.removeFirst();
    return data;
}

public T peek() {
    if (empty()) throw new RuntimeException("Queue Empty");
    return list.peekFirst();
}

@Override
public java.util.Iterator<T> iterator() {
  return list.iterator();
}

}