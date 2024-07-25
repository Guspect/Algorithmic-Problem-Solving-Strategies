import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static Integer[] ladder;
    public static Integer[] snake;
    public static boolean[] visited;
    public static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        ladder = new Integer[101];
        snake = new Integer[101];
        visited = new boolean[101];
        arr = new int[101];

        for(int i = 0; i < l; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladder[a] = b;
        }
        for(int i = 0; i < s; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            snake[a] = b;
        }

        BFS();
        System.out.println(arr[100]);
    }
    public static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        arr[1] = 0;

        while(!queue.isEmpty()){
            int a = queue.poll();
            if(ladder[a] != null || snake[a] != null){
                int t;
                if(ladder[a] == null){
                    t = snake[a];
                }else{
                    t = ladder[a];
                }

                if(!visited[t]){
                    arr[t] = arr[a];
                    visited[t] = true;
                    queue.add(t);
                }else{
                    if(arr[t] > arr[a]){
                        arr[t] = arr[a];
                        queue.add(t);
                    }
                }
            }else{
                for(int i = 0; i <= 6; i++){
                    if(a+i <= 100){
                        if(!visited[a+i]){
                            queue.add(a+i);
                            visited[a+i] = true;
                            arr[a+i] = arr[a]+1;
                        }else{
                            if(arr[a+i] > arr[a]+1){
                                arr[a+i] = arr[a]+1;
                                queue.add(a+i);
                            }
                        }
                    }
                }
            }

        }
    }
}