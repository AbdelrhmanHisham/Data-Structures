import java.util.Arrays;

public class App {

 
    
    public static void main(String[] args)
    {        
 
        // int [] arr = new int [5];
        // int [] new_arr = new int [10];
        // Arrays.fill(arr,5);
        // Arrays.fill(new_arr,10);

        // System.out.println(Arrays.toString(arr));
        // arr = new_arr;
        // System.out.println(Arrays.toString(arr));
    
        DynamicArrays list = new DynamicArrays();
        list.add("shikaa");
        // System.out.println(list.size()); 
        // System.out.println(list.get_capacity());
        // System.out.println(list.removeAt(0));
        // System.out.println(list.get_capacity()); 
        // System.out.println(list.size());
        list.add("A");
        list.add("V");
        list.add("B");
        list.remove("B");
        // System.out.println(list.get_capacity()); 
        // System.out.println(list.size());
        list.print();
    
    }




}



