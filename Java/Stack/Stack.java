public class Stack<T>implements Iterable<T>{

    private java.util.LinkedList<T> list = new java.util.LinkedList<T>(); 
    
    public Stack(T first_elm){
        push(first_elm);
    }
    public Stack(){
    
    }

    public int size(){
        return list.size();
    }

    public boolean empty() {
        return size() == 0;
    }

    public void push(T elm){
        list.offerFirst(elm); //add from head of the linkedlist      
    }

    public T pop(){
        if (empty()) throw new java.util.EmptyStackException();
        T data =list.removeFirst();
        return data;
    }

    public T peek() {
        if (empty()) throw new java.util.EmptyStackException();
        return list.peekFirst();
      }


public java.util.Iterator<T> iterator(){
return list.iterator();
}

}