import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static String[] arr;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            arr = new String[10000];

            BFS(num,target);
            sb.append(arr[target]+"\n");
        }
        System.out.println(sb);
    }
    public static void BFS(int n, int t){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        arr[n] = "";

        while (!queue.isEmpty() && arr[t] == null){
            int temp = queue.poll();

            int d = D(temp);

            if(arr[d] == null){
                arr[d] = arr[temp]+"D";
                queue.add(d);
            }

            d = S(temp);
            if(arr[d] == null){
                arr[d] = arr[temp]+"S";
                queue.add(d);
            }

            d = L(temp);
            if(arr[d] == null){
                arr[d] = arr[temp]+"L";
                queue.add(d);
            }

            d = R(temp);
            if(arr[d] == null){
                arr[d] = arr[temp]+"R";
                queue.add(d);
            }

        }

    }

    public static int D(int n){
        int res = 2*n;

        if(res >= 10000){
            res = res %10000;
        }
        return res;
    }
    public static int S(int n){
        int res = n-1;

        if(res < 0){
            res = 10000 + res;
        } else if (res >= 10000) {
            res = res - 10000;
        }

        return res;
    }
    public static int L(int d){
        String s = toString(d);
        char c = s.charAt(0);

        String res = s.substring(1,4) + c;
        return Integer.parseInt(res);
    }

    public static int R(int d){
        String s = toString(d);
        char c = s.charAt(3);

        String res = c + s.substring(0,3);
        return Integer.parseInt(res);
    }

    public static String toString(int d){
        String s = d+"";
        String res;
        if(s.length() == 4){
            return s;
        }else if (s.length() == 3){
            res = "0"+s;
        }else if (s.length() == 2) {
            res = "00"+s;
        }else {
            res = "000"+s;
        }
        return res;
    }

}
