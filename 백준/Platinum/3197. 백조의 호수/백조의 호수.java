import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static char[][] arr;
    public static boolean[][] visited;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static Queue<Point> water;
    public static Queue<Point> nextArea;
    public static Point[] swan;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        swan = new Point[2];
        int cnt = 0;
        water = new LinkedList<>();
        visited = new boolean[r][c];

        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0 ; j < c; j++){
                arr[i][j] = s.charAt(j);
                if(s.charAt(j) != 'X'){
                    water.add(new Point(j,i));
                    if(s.charAt(j) == 'L'){
                        swan[cnt] = new Point(j,i);
                        cnt++;
                    }
                }
            }
        }
        nextArea = new LinkedList<>();
        nextArea.add(new Point(swan[0].x,swan[0].y));

        cnt = 1;
        while(true){
            BFS();
            if(isPossible()){
                break;
            }
            cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean isPossible() {
        Queue<Point> queue = new LinkedList<>();

        while (!nextArea.isEmpty()) {
            Point temp = nextArea.poll();

            for (int i = 0; i < 4; i++) {
                int newx = temp.x + dx[i];
                int newy = temp.y + dy[i];

                if (newx < 0 || newx >= arr[0].length || newy < 0 || newy >= arr.length || visited[newy][newx]){
                    continue;
                }
                visited[newy][newx] = true;

                if(newy == swan[1].y && newx == swan[1].x){
                    return true;
                } else if(arr[newy][newx] == '.'){
                    nextArea.add(new Point(newx, newy));
                }else if (arr[newy][newx] == 'X') {
                    queue.add(new Point(newx, newy));
                }
            }
        }
        nextArea = queue;
        return false;
    }
    public static void BFS(){
        Queue<Point> q = new LinkedList<>();
        while(!water.isEmpty()){
            Point temp = water.poll();

            for(int i = 0; i < 4; i++){
                int newx = temp.x + dx[i];
                int newy = temp.y + dy[i];

                if (newx >= 0 && newx < arr[0].length && newy >= 0 && newy < arr.length && arr[newy][newx] == 'X'){
                    arr[newy][newx] = '.';
                    q.add(new Point(newx,newy));
                }
            }
        }
        water = q;
    }
    
    public static class Point{
        int x;
        int y;
        
        public Point(int a, int b){
            x = a;
            y = b;
        }
    }
}