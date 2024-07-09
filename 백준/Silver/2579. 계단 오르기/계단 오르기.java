import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] scores;
    public static Integer[] accumlate;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        scores = new int[n+1];
        accumlate = new Integer[n+1];
        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        accumlate[0] = scores[0];
        accumlate[1] = scores[1];

        if(n >= 2){
            accumlate[2] = scores[1] + scores[2];
        }

        System.out.println(up(n));
    }
    public static int up(int pos){
        if(accumlate[pos] == null){
            accumlate[pos] = Math.max(up(pos-2), up(pos -3)+scores[pos -1]) + scores[pos];
        }

        return accumlate[pos];
    }


}