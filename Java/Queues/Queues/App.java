import java.util.Iterator;
public class App{
    public static void main(String[] args) {
        Queues qu = new Queues();
        Iterator it = qu.iterator();

        qu.enqueue(5);
        qu.enqueue("shikaa");
        qu.enqueue("abdoo");
        qu.enqueue("hemaa");
        qu.enqueue(5.555);
        qu.enqueue('A');

        System.out.println(qu.dequeue());        
        System.out.println(qu.dequeue());
        System.out.println(qu.dequeue());
        System.out.println(qu.dequeue());
        System.out.println(qu.dequeue());
        System.out.println(qu.dequeue());

    }
}