public abstract class Abs{
 
   protected String name;
   protected int id;

   public Abs(){
    System.out.println("Abs constructor");
}

public abstract void set_name(String name);
public abstract void set_id(int id);
public abstract String get_name();
public abstract int get_id();
}