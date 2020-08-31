public class LinkedList<T> {
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

}
