import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static boolean visited[];
    public static int arr[];
    public static boolean flag = false;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if(n == m) {
            System.out.println(0);
            System.exit(0);
        }

        visited = new boolean[100002];
        arr = new int [100001];

        BFS(n,m);

        System.out.println(arr[m]);

    }

    public static void BFS(int pos, int target){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(pos);
        visited[pos] = true;
        int cnt = 1;
        while(!queue.isEmpty()){
            int t = queue.poll();
            if(move(t+1, arr[t] + 1, target)){
                queue.add(t+1);
            }
            if(move(t-1, arr[t] + 1, target)){
                queue.add(t-1);
            }
            if(move(t*2, arr[t] + 1, target)){
                queue.add(t*2);
            }

            if(flag){
                return;
            }
        }
    }
    public static boolean move(int pos, int cnt, int target){
        if(pos > -1 && pos < 100001){
            if (!visited[pos]) {
                visited[pos] = true;
                arr[pos] = cnt;
                if (pos == target) {
                    flag = true;
                }
                return true;
            }
        }

        return false;
    }

}
