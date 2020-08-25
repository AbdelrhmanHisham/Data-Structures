import java.util.LinkedList;
import java.util.Iterator;
import java.util.Arrays;

public class test2{

 
    
    public static void main(String[] args)
    {

         LinkedList list = new LinkedList();

            list.add("Shikaa");
            list.add("hema");
            list.add("abdo");
            list.add("Asmmaa");
            list.add("shefo");
            System.out.println(list);
            // list.pop();
            list.push("A");
            list.pop();

            Object[] namearry = new Object[5]; 
            namearry = list.toArray();
            
       System.out.println(list);
       System.out.println(Arrays.toString(namearry));

 
    }
}