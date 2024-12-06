import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static int[] root;
    public static LinkedList<Edge> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            int cnt = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int val = Integer.parseInt(st.nextToken());
                if(val == 1){
                    graph.add(new Edge(i,cnt));
                }
                cnt++;
            }
        }

        root = new int [n+1];
        for(int i = 1; i <= n; i++){
            root[i] = i;
        }

        for(Edge e : graph){
            if(find(e.ver1) != find(e.ver2)){
                union(e.ver1, e.ver2);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens()){
            int temp = Integer.parseInt(st.nextToken());
            if(find(start) != find(temp)){
                System.out.println("NO");
                System.exit(0);
            }
            start = temp;
        }
        System.out.println("YES");
        System.exit(0);

    }
    public static int find(int x){
        if(root[x] == x){
            return x;
        }else{
            return root[x] = find(root[x]);
        }
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        root[y] = x;
    }
    public static class Edge{
        int ver1,ver2;

        public Edge(int v1,int v2){
            ver1 = v1;
            ver2 = v2;
        }

    }
}