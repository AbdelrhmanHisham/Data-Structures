import java.util.Iterator;
public class App{


    public static void main(String[] args){
        LinkedList list = new LinkedList();
        Iterator it = list.iterator();

        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        list.addLast("d");
        list.addLast("e");
        list.addLast("f");

        // System.out.println(list.toString());   

        System.out.println(it.next());


    }
}