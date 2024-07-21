import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static boolean visited[][][];
    public static int arr[][][];
    public static boolean flag = true;
    public static Queue<Point> queue;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        visited = new boolean[h][m][n];
        arr = new int[h][m][n];
        queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    int t = Integer.parseInt(st.nextToken());
                    arr[i][j][k] = t;
                    if (t == 0) {
                        flag = false;
                    } else if (t == 1) {
                        queue.add(new Point(k, j, i));
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        if (flag) {
            System.out.println(0);
            System.exit(0);
        }

        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        int day = 0;
        while (!queue.isEmpty()) {
            Point t = queue.poll();

            for (int i = 0; i < 6; i++) {
                int x = t.x + dx[i];
                int y = t.y + dy[i];
                int z = t.z + dz[i];

                if (x > -1 && x < n && y > -1 && y < m && z > -1 && z < h) {
                    if (!visited[z][y][x] && arr[z][y][x] != -1){
                        queue.add(new Point(x,y,z));
                        visited[z][y][x] = true;
                        arr[z][y][x] = arr[t.z][t.y][t.x] + 1;
                        if(day < arr[z][y][x]){
                            day = arr[z][y][x];
                        }
                    }
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[i][j][k] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(day-1);
    }


    public static class Point{
        int x,y,z;

        public Point(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }

    }

}
