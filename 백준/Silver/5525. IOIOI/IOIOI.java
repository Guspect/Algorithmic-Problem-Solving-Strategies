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
        int idx = 0;
        while(s.length() - idx >= t.length()){
            if(s.charAt(idx) == 'I'){
                String temp = s.substring(idx, idx + t.length());
                if(temp.equals(t)){
                    cnt++;
                    while(true){
                        try {
                            if (s.substring(idx + t.length(), idx + t.length() + 2).equals("OI")) {
                                cnt++;
                                idx += 2;

                            } else {
                                idx = idx + t.length();
                                break;
                            }
                        }catch (StringIndexOutOfBoundsException e){
                            idx++;
                            break;
                        }
                    }
                }else {
                    idx += diff_idx(temp,t);
                }
            }else{
                idx++;
            }
        }
        return cnt;
    }

    public static int diff_idx(String s, String t){
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                return i;
            }
        }
        return 0;
    }


}
