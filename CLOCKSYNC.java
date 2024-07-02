import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] linked = {
            {0,1,2},{3,7,9,11},{4,10,14,15},{0,4,5,6,7},{6,7,8,10,12},
            {0,2,14,15},{3,14,15},{4,5,7,14,15},{1,2,3,4,5},{3,4,5,9,13}
    };
    public static int[] clock;
    public static int Min;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            clock = new int[16];
            Min = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 16; j++){
                clock[j] = Integer.parseInt(st.nextToken());
            }
            count(0,0);
            if(Min != Integer.MAX_VALUE) {
                System.out.println(Min);
            }else{
                System.out.println("-1");
            }
        }
    }
    public static void count(int start, int push_cnt){
        if(start == 10){
            return;
        }
        count(start + 1, push_cnt);
        for(int i = 0; i < 4; i++){
            push_cnt++;
            if(switching(start)){
                Min = Math.min(push_cnt, Min);
            }
            count(start + 1, push_cnt);
        }
    }

    public static boolean switching(int num){
        for(int i = 0; i < linked[num].length; i++){
            int num_clock = linked[num][i];

            if(clock[num_clock] != 12){
                clock[num_clock] = clock[num_clock] + 3;
            }else {
                clock[num_clock] = 3;
            }
        }
        for(int i = 0; i < 16; i++){
            if(clock[i] != 12){
                return false;
            }
        }
        return true;
    }
}
