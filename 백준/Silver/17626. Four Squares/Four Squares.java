import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static Integer[] dp;
    public static int MAX_VAL = Integer.MIN_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());



        dp = new Integer[n+1];
        for(int i = 0; i*i <= n; i++){
            dp[i*i] = 1;
        }

        for(int i = 1; i <= n; i++) {
            if(dp[i] == null){
                find(i);
            }
        }

        System.out.println(dp[n]);
    }
    public static void find(int n){

        for(int i = 1; i*i <= n; i++){
            if(dp[n] == null){
                dp[n] = dp[i*i] + dp[n-i*i];
            }else {
                dp[n] = Math.min(dp[n], dp[i * i] + dp[n - i * i]);
            }
        }
    }
}
