import java.util.List;
@SuppressWarnings("unchecked")
public class DynamicArrays<T> implements Iterable<T>{
  T[] Darr;
  int len = 0; // user-lenght
  private int capacity; // Acual capacity of the Dynamic array

  public int get_capacity() {
    return this.capacity;
  }

  public DynamicArrays() {
    this(10);
  }

  public DynamicArrays(int capacity) {
    //check if the user enter a wrong capacity (must be > 0)
    if (capacity < 0) throw new IllegalArgumentException(
      "Illegal Capacity : " + capacity
    );

    this.capacity = capacity;
    Darr = (T[]) new Object[capacity]; //create the array
  }

  public int size() {
    return len;
  }

  
  public T get(int index) {
    if (index < 0 || index >= len) throw new IndexOutOfBoundsException();
    return Darr[index];
  }

  
  public void clear() {
    for (int i = 0; i < len; i++) {
      Darr[i] = null;
    }
    len = 0;
  }

  
  
  public boolean isEmpty() {
    if (len == 0) {
      return true;
    } else {
      return false;
    }
  }


  public void set(int index, T element) {
    if (index < 0 || index >= len) throw new IndexOutOfBoundsException();
    Darr[index] = element;
  }

  
  
  public void add(T element) {
    if (len + 1 >= capacity) {
      if (capacity == 0) {
        capacity = 1;
      } else {
        capacity *= 2;
      }
      T[] new_Darr = (T[]) new Object[capacity]; //create a new one with double size
      for (int i = 0; i < len; i++) {
        new_Darr[i] = Darr[i];
      }

      Darr = new_Darr;
    }

    Darr[len++] = element;
  }

  
  
  public T removeAt(int index) {
    if (index < 0 || index >= len) throw new IndexOutOfBoundsException();

    T temp = Darr[index];
    T[] new_Darr = (T[]) new Object[len - 1];
    int j = 0;
    for (int i = 0; i < len; i++) {
      if (i == index) {
        j--;
      } else {
        new_Darr[j] = Darr[i];
        j++;
      }
    }
    len--;
    capacity = len;
    Darr = new_Darr;
    return temp;
  }



  public boolean remove(Object obj) {
    int index = indexOf(obj);
    boolean return_value;
    if (index != -1) {
      removeAt(index);

      return_value = true;
    } else {
      return_value = false;
    }

    return return_value;
  }

  
  public int indexOf(Object obj) {
    int index;
    for (int i = 0; i < len; i++) {
      if (Darr[i].equals(obj)) {
        index = i;
        return index;
      }
    }

    return -1;
  }


  public boolean contains(Object obj) {
    return indexOf(obj) != -1;
  }



  public void print() {
    for (int i = 0; i < len; i++) {
      System.out.println(Darr[i]);
    }
  }


  @Override
  public java.util.Iterator<T> iterator() {
    return new java.util.Iterator<T>() {
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < len;
      }

      @Override
      public T next() {
        return Darr[index++];
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }

  @Override
  public String toString() {
    if (len == 0) return "[]";
    else {
      StringBuilder sb = new StringBuilder(len).append("[");
      for (int i = 0; i < len - 1; i++) sb.append(Darr[i] + ", ");
      return sb.append(Darr[len - 1] + "]").toString();
    }
  }
}
