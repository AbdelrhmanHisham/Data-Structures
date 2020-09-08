public class child1 extends Abs implements interfaceee  { 

    public child1(){
        System.out.println("Child1 constructor");
    }


@Override 
public void set_name(String name){
this.name = name;
}

@Override   
public void set_id(int id){
this.id = id;
}

@Override
public String get_name(){
return this.name;
}

@Override
public int get_id(){
return this.id;
}


public void shika(){

}


}