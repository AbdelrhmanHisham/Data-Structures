import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class App {

  public static void main(String[] args){

    // List list = new LinkedList();
    DynamicArrays list = new DynamicArrays();
    list.add("shikaa");
    list.add(5);
    list.add(10);
    list.add(1.033);
    list.add("hema");
    Iterator it = list.iterator();
    System.out.println(list.toString());
    System.out.println(it.next());
    System.out.println(it.next());
    System.out.println(it.next());
    System.out.println(it.next());
  }
}
