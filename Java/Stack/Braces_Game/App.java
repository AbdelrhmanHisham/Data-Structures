import java.util.Scanner;
import java.util.Stack;

public class App{

static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        int curly_braces = 0;
        int valid = 1;
        Stack stacks = new Stack<>();

        String in = input.nextLine();
        System.out.println(in);

        for (int i =0 ; i < in.length(); i++){
            if(check_Left_dir(in.charAt(i))){
            stacks.push(in.charAt(i));
        }else{
            if (!stacks.empty()){
           if( check_similarity(in.charAt(i) , (char)stacks.peek())){
            stacks.pop();
            valid = 1;
           }else{
               valid = 0;
           }
        }
    }
        }
        if (valid == 1 && stacks.empty() ){
        System.out.println("VALID");
        }else{
        System.out.println("NOT_VALID");

        }

    }


    public static boolean check_Left_dir(char brac){
        if (brac == '{' |  brac =='[' | brac == '(' ){
            return true;
        }else{
            return false;
        }
    }



    public static boolean check_similarity(char brac , char top){
        if (brac == ']'){
            brac = '[';
        }else if(brac == '}'){
            brac = '{';
        }else{
            brac = '(';
        }
        if (brac == top){
            return true;
        }else{
            return false;
        }
        
    }
}