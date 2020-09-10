import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;

public class BinaryMinHeap<T extends Comparable<T>> {
  //Root of the heap alawys equals to 0
  int Root = 0;
  //number of the elemnts in the heap
  int heapSize = 0;
  //A Dynamic array to holds the elments
  private List<T> heap = null;

  //***********Constructors****************** */

  public BinaryMinHeap() {
    this(1);
  }

  public BinaryMinHeap(int sz) {
    heap = new ArrayList<T>(sz);
  }

  // Priority queue construction, O(n)
  public BinaryMinHeap(T[] elemnts) {
    heapSize = elemnts.length;
    heap = new ArrayList<T>(heapSize);
    for (int i = 0; i < heapSize; i++) {
      //Adding elemnts to heap
      heap.add(elemnts[i]);
    }
    //Reconstruct the heap again to satisfy the heap invariant
    for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--) {
      //check every parent in the heap
      BubbleDown(i);
    }
  }

  // Priority queue construction, O(nlog(n))
  public BinaryMinHeap(Collection<T> elemnts) {
    this(elemnts.size());
    for (T elm : elemnts) {
      add(elm);
    }
  }

  
  //**********************Helper Private Functions************************************************** */
  //   return true if node at index i  is smaller than the one at j
  private boolean less(int i, int j) {
    T node_i = heap.get(i);
    T node_j = heap.get(j);

    return node_i.compareTo(node_j) <= 0;
  }

  //Swap the node at i with j
  private void swap(int i, int j) {
    T node_i = heap.get(i);
    T node_j = heap.get(j);

    heap.set(i, node_j);
    heap.set(j, node_i);
  }

  //take the parent node then satisfy the heap invariant
  private void BubbleDown(int parent) {
    while (true) {
      //get the index of the childs
      int right = 2 * parent + 2;
      int left = 2 * parent + 1;
      //let the left node is the smaller
      int smallest = left;
      //check if right node is outside the heap and if right is smaller than left
      if (right < heapSize && less(right, left)) smallest = right;
      //check if left is outside or parent smaller than the smallest child
      if (left >= heapSize || less(parent, smallest)) break;

      swap(parent, smallest);
      //Update the parent
      parent = smallest;
    }
  }

  //take the added node then satisfy the heap invariant
  private void BubbleUp(int insertionpoint) {
    while (true) {
      //Get the parent and it is Valid for left and right child.
      int parent = (insertionpoint - 1) / 2;
      if (insertionpoint > 0 && less(insertionpoint, parent)) {
        swap(parent, insertionpoint);
        insertionpoint = parent;
      } else {
        break;
      }
    }
  }

  /************************************* */

  public int size() {
    return heapSize;
  }

  public void clear() {
    heap.clear();
    heapSize = 0;
  }

  public T peek() {
    return heap.get(Root);
  }

  public T poll() {
    return removeAt(0);
  }

  public boolean isEmpty() {
    return size() <= 0;
  }

  public T removeAt(int index) {
    if (isEmpty()) return null;
    heapSize--;
    T removeData = heap.get(index);
    swap(index, heapSize);
    heap.remove(heapSize);
    // heap.set(heapSize, null);

    if (index == heapSize) return removeData;

    BubbleDown(index);

    if (heap.get(index).equals(removeData)) BubbleUp(index);

    return removeData;
  }

  public int remove(T elm) {
    for (int i = 0; i < heapSize; i++) {
      if (elm.equals(heap.get(i))) {
        removeAt(i);
        return i;
      }
    }
    return -1;
  }

  public void add(T elments) {
    if (elments == null) throw new IllegalArgumentException();

    heap.add(elments);
    BubbleUp(heapSize);
    heapSize++;
  }

  //check the heap invariant
  public boolean isMinHeap(int parent) {
    if (parent >= heapSize || isEmpty()) return true;
    int left = 2 * parent + 1;
    int right = 2 * parent + 2;

    if (left < heapSize && !less(parent, left)) return false;
    if (right < heapSize && !less(parent, right)) return false;

    return isMinHeap(left) && isMinHeap(right);
  }

  @Override
  public String toString() {
    return heap.toString();
  }
  //   public static void main(String[] args) {
  //     // int[] arr2 = { 10, 2, 3, 50, 100, 0, -1, 50000, -30 };
  //     Integer[] arr = { 10, 2, 3, 50, 100, 0, -1, 50000, -30 };
  //     BinaryMinHeap shikaa = new BinaryMinHeap(arr);
  //     PriorityQueue pq = new PriorityQueue();
  //     for (int i = 0; i < arr.length; i++) {
  //       pq.add(arr[i]);
  //     }

  //     // System.out.println(shikaa.toString() + "  Abdo");
  //     // System.out.println(pq.toString());
  //     shikaa.add(-500);

  //     shikaa.add(0);
  //     shikaa.add(-5000);
  //     shikaa.remove(-30);
  //     shikaa.remove(0);
  //     shikaa.remove(100);
  //     shikaa.remove(-1);
  //     shikaa.remove(50);
  //     shikaa.remove(2);
  //     shikaa.remove(10);
  //     shikaa.remove(50000);
  //     shikaa.remove(3);

  //     // pq.remove(-30);
  //     // pq.remove(0);
  //     // pq.remove(100);
  //     shikaa.clear();
  //     System.out.println(shikaa.toString() + "Abdo");
  //     System.out.println(shikaa.isEmpty());
  //     System.out.println(shikaa.isMinHeap(0));
  //     // System.out.println(pq.toString());
  //   }
}
