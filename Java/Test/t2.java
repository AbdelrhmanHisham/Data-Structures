public class t2{
    public static int num;
    
    public static int get() {
        return num;
    }
    public t2 () {
        num++;
    }

    public void set(Object shikaa){
        shikaa = 5;
        shikaa = (int)shikaa + 10;
        System.out.println(shikaa);
    }
}