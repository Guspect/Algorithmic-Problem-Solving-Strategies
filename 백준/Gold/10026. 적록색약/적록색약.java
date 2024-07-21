import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    public static boolean visited[][];
    public static boolean visited_weak[][];
    public static char arr[][];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        visited = new boolean[n][n];
        visited_weak = new boolean[n][n];
        arr = new char[n][n];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    BFS(j,i);
                    cnt++;
                }
            }
        }

        int cnt_weak = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited_weak[i][j]){
                    BFS_weak(j,i);
                    cnt_weak++;
                }
            }
        }

        System.out.println(cnt +" "+ cnt_weak);

    }
    public static void BFS(int x, int y){
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        visited[y][x] = true;
        char c = arr[y][x];

        while(!queue.isEmpty()){
            Point t = queue.poll();

            for(int i = 0; i < 4; i++){
                int newx = t.x + dx[i];
                int newy = t.y + dy[i];

                if(newx > -1 && newx < arr.length && newy > -1 && newy < arr.length && !visited[newy][newx]){
                    if(arr[newy][newx] == c){
                        queue.add(new Point(newx,newy));
                        visited[newy][newx] = true;
                    }
                }
            }
        }
    }

    public static void BFS_weak(int x, int y){
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        visited_weak[y][x] = true;
        char c = arr[y][x];

        while(!queue.isEmpty()){
            Point t = queue.poll();

            for(int i = 0; i < 4; i++){
                int newx = t.x + dx[i];
                int newy = t.y + dy[i];

                if(newx > -1 && newx < arr.length && newy > -1 && newy < arr.length && !visited_weak[newy][newx]){
                    if(c == 'B'){
                        if(arr[newy][newx] == c){
                            queue.add(new Point(newx,newy));
                            visited_weak[newy][newx] = true;
                        }
                    }else{
                        if(arr[newy][newx] == 'R' || arr[newy][newx] == 'G'){
                            queue.add(new Point(newx,newy));
                            visited_weak[newy][newx] = true;
                        }
                    }
                }
            }
        }

    }


    public static class Point{
        int x,y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
}
