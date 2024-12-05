import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<String> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '['){
                String temp = ""+c;
                stack.push(temp);
            }else if(c == ')'){
                if(stack.isEmpty()){
                    System.out.println("0");
                    System.exit(0);
                }
                if(stack.peek().equals("(")){
                    stack.pop();
                    stack.push("2");
                }else{
                    int sum = 0;
                    while(!stack.isEmpty() && !stack.peek().equals("(") && !stack.peek().equals("[")){
                        sum += Integer.parseInt(stack.pop());
                    }
                    if(sum == 0||stack.isEmpty()||stack.peek().equals("[")){
                        System.out.println("0");
                        System.exit(0);
                    }
                    stack.pop();
                    stack.push(Integer.toString(sum*2));
                }
            }else{
                if(stack.isEmpty()){
                    System.out.println("0");
                    System.exit(0);
                }
                if(stack.peek().equals("[")){
                    stack.pop();
                    stack.push("3");
                }else{
                    int sum = 0;
                    while(!stack.isEmpty() && !stack.peek().equals("[") && !stack.peek().equals("(")){
                        sum += Integer.parseInt(stack.pop());
                    }
                    if(sum == 0 || stack.isEmpty()||stack.peek().equals("(")){
                        System.out.println("0");
                        System.exit(0);
                    }
                    stack.pop();
                    stack.push(Integer.toString(sum*3));
                }
            }
        }
        int ans = 0;
        for(String t : stack){
            try {
                ans += Integer.parseInt(t);
            }catch (NumberFormatException e){
                System.out.println("0");
                System.exit(0);
            }
        }

        System.out.println(ans);
    }
}