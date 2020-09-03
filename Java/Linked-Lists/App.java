import java.util.Iterator;
public class App{


    public static void main(String[] args){
        LinkedList<String> list = new LinkedList();
        Iterator<String> it = list.iterator();

        list.addLast("a");

        list.addLast("b ");

        list.addLast("c");

        list.addLast("d");
        list.addLast("e");
        list.addLast("f");
 
       System.out.println(it.next());
       System.out.println(it.hasNext());

       System.out.println(it.next());
       System.out.println(it.hasNext());

       System.out.println(it.next());
       System.out.println(it.hasNext());

       System.out.println(it.next());
       System.out.println(it.hasNext());
      
       System.out.println(it.next());
       System.out.println(it.hasNext());

       System.out.println(it.next());
       System.out.println(it.hasNext());

    //    System.out.println(it.next());

    }
}