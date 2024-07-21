import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;

    public static int[][][] tetro;
    public static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        tetro = new int[][][]{
                {{0,0},{1,0},{0,1},{1,1}},
                {{0,0},{0,1},{0,2},{0,3}},{{0,0},{1,0},{2,0},{3,0}},
                {{0,0},{0,-1},{-1,-1},{1,-1}},{{0,0},{0,1},{-1,1},{1,1}},{{0,0},{-1,0},{-1,1},{-1,-1}},{{0,0},{1,0},{1,1},{1,-1}},
                {{0,0},{0,-1},{0,-2},{1,-2}},{{0,0},{0,-1},{0,-2},{-1,-2}},{{0,0},{0,1},{0,2},{1,2}},{{0,0},{0,1},{0,2},{-1,2}},{{0,0},{0,-1},{1,-1},{2,-1}},{{0,0},{0,-1},{-1,-1},{-2,-1}},{{0,0},{0,1},{-1,1},{-2,1}},{{0,0},{0,1},{1,1},{2,1}},
                {{0,0},{0,1},{1,1},{1,2}},{{0,0},{1,0},{1,-1},{2,-1}},{{0,0},{0,-1},{1,-1},{1,-2}},{{0,0},{-1,0},{-1,-1},{-1,-2}},{{0,0},{-1,0},{-1,-1},{-2,-1}},
        };

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int [n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                Point_Checker(j,i);
            }
        }

        System.out.println(MAX);
    }
    public static void Point_Checker(int x, int y){
        for(int j = 0; j < 20; j++) {
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                int newx = x + tetro[j][i][0];
                int newy = y + tetro[j][i][1];
                if (newx > -1 && newx < arr[0].length && newy > -1 && newy < arr.length) {
                    sum += arr[newy][newx];
                }
            }
            MAX = Math.max(sum, MAX);
        }
    }

}
