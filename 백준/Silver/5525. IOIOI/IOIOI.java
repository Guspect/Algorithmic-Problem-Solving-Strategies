import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        StringBuilder target = new StringBuilder();
        for(int i = 0; i < n; i++){
            target.append("IO");
        }
        target.append("I");

        String t = target.toString();

        System.out.println(find(s,t));
    }
    public static int find(String s, String t){
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.length() - i < t.length()){
                break;
            }
            if(s.charAt(i) == 'I'){
                String temp = s.substring(i,i+t.length());
                if(temp.equals(t)){
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
