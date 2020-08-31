public class App{


    public static void main(String[] args){
        LinkedList list = new LinkedList();

        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        list.addLast("d");
        list.addLast("e");
        list.addLast("f");
        // list.print(list);
        // list.addFirst("shikaa");
        // list.print(list);
        list.removeLast();
        list.print(list);   

        System.out.println(list.peekFirst());
        System.out.println(list.peekLast());

    }
}