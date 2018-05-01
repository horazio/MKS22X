import java.util.*;
public class Calculator{
    
    public static double eval(String data){
        String[] dataS = data.split(" ");
        LinkedList<String> stack = new LinkedList<String>();
        String holder;
        for(String e : dataS){
            if(e.equals("+")){
                stack.push("" + (Double.parseDouble(stack.pop()) + Double.parseDouble(stack.pop())));
            }else if(e.equals("-")){
                holder = stack.pop();
                stack.push("" + (Double.parseDouble(stack.pop()) - Double.parseDouble(holder)));
            }else if(e.equals("*")){
                stack.push("" + (Double.parseDouble(stack.pop()) * Double.parseDouble(stack.pop())));
            }else if(e.equals("/")){
                holder = stack.pop();
                stack.push("" + (Double.parseDouble(stack.pop()) / Double.parseDouble(holder)));
            }else if(e.equals("%")){
                holder = stack.pop();
                stack.push("" + (Double.parseDouble(stack.pop()) % Double.parseDouble(holder)));
            }else{
                stack.push(e);
            }
        }
        
        return Double.parseDouble(stack.pop());
    }
    
    
    public static void main(String[] args){
        System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    }
    
    
    
    
}
