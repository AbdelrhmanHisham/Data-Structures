public class LinkedList<T> implements Iterable<T>{
  public int size;
  private node<T> head = null;
  private node<T> tail = null;


  public LinkedList(){
   
  }

  static class node<T> {
    T data;

    private node<T> prev;
    private node<T> next;

    public node(T data, node<T> prev, node<T> next) {
      this.data = data;
      this.prev = prev;
      this.next = next;
    }
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return (size() == 0);
  }

  public void clear() {
    node<T> trav = head;
    node<T> next = null;
    while (trav != null) {
      next = trav.next;

      trav.prev = trav.next = null;
      trav.data = null;
      trav = next;
    }

    head = tail = trav = null;
    size = 0;
  }

  public void addFirst(T elm) {
    if (isEmpty()) {
      head = tail = new node(elm, null, null);
    } else {
      head.prev = new node(elm, null, head);
      head = head.prev;
    }
    size++;
  }

  public void addLast(T elm) {
    if (isEmpty()) {
      head = tail = new node(elm, null, null);
    } else {
      tail.next = new node(elm, tail, null);
      tail = tail.next;
    }
    size++;
  }

  public T peekFirst() {
    return head.data;
  }

  public T peekLast() {
    return tail.data;
  }


  public T removeFirst(){
      if (isEmpty()) throw new RuntimeException("Empty list");

      T data = head.data;
      head.data = null;

      head = head.next;
      size--;
      if (isEmpty()){
          tail = null;
      }else {
          head.prev = null;
      }
      return data;
  }
  public T removeLast(){
    // if (isEmpty()) throw new RuntimeException("Empty list");
    T data = tail.data;
    tail.data = null;

    tail = tail.prev;
    size--;
    if(isEmpty()){
        head = null;
    }else{
        tail.next = null;
    }
    return data; 
  }


  public void print(LinkedList<T> list){
    node<T> trav = head;
    node<T> next = null;
    int counter = 0;
    while(trav != null){
        next = trav.next;
        System.out.println(trav.data);
        trav = next;
        counter++;
    }
    System.out.println("LinkedList of Size : "+counter);
  }


  private T remove (node<T> Node){

    if (Node.prev == null){
      return removeFirst();
    }

    if (Node.next == null){
      return removeLast();
    }

    Node.prev.next = Node.next;
    Node.next.prev = Node.prev;

    T data = Node.data;
    Node.data = null;
    Node.prev = Node.next = null;
    return data;
  }

  public T removeAt(int index){
    if (index < 0 || index >= size ){
      throw new IllegalArgumentException();
    }

    node<T> trav = null;
    if (index <= size/2){
      trav = head;
      for(int i = 0 ; i != index ; i++){
        trav = trav.next;
    } 
    }else{
      trav = tail;
      for(int i = size-1; i != index ; i--){
        trav = trav.prev;

    } 
    }

    return remove(trav);
  }

  public int indexOf(Object Data){

    node<T> trav = head;
    if (Data == null){
      for (int i = 0 ; i < size ;i++){

        if (trav.data == null){
          return i;
        }
        trav = trav.next;
      }
    }else {
      for (int i = 0 ; i < size ;i++){

        if (Data.equals(trav.data)){
          return i;
        }
        trav = trav.next;

    }
    
  }
  return -1;
 


}
 public boolean remove(Object obj){
   int index = indexOf(obj);
   if (index == -1){
     return false;
   }else{
     removeAt(index);
     return true;
   }
 } 
 public boolean contains(Object obj){

  return indexOf(obj) != -1;
 }


@Override
public java.util.Iterator<T> iterator() {
  return new java.util.Iterator<T>() {
    int counter = 0;
    private node<T> trav = head;

    @Override
    public T next(){
      if (counter==0){
        trav = head;
        counter++;
      }else{
        counter++;
      }
      T data = trav.data;
      trav = trav.next;
      return data;
    }

    @Override
    public boolean hasNext(){
      if (counter==0){
        trav = head;
        counter++;
      }else{
        counter++;
      }

      if (trav != null){
        return true;
      }else{
        return false;
      }
    }


    @Override
    public void remove(){
      throw new UnsupportedOperationException();
    }

  };
}

@Override
  public String toString() {
    node<T> trav = head;
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for(int i =0 ; i < size ; i++){
      sb.append(trav.data);
      trav = trav.next;
      if (i < (size-1)){
      sb.append(",");}
    }
    sb.append("]");
    return sb.toString();

  }
}