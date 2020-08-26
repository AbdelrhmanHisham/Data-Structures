import java.util.Iterator;
public class App {

  public static void main(String[] args){

    DynamicArrays list = new DynamicArrays();
    list.add("A");
    list.add(2);
    list.add(3);
    list.add(1.5);
    list.add("B");
    Iterator it = list.iterator();
    System.out.println(list.toString());
    System.out.println(it.next());
    System.out.println(it.next());
    System.out.println(it.next());
    System.out.println(it.next());
  }
}
