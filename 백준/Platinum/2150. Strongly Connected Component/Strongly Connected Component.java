import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> graph;
    public static ArrayList<ArrayList<Integer>> reverse;
    public static ArrayList<ArrayList<Integer>> ans;

    public static boolean[] isvisited;
    public static Stack<Integer> stack;
    public static int v;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        reverse = new ArrayList<>();
        ans = new ArrayList<>();

        for(int i = 0; i <= v; i++){
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
            ans.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph.get(v1).add(v2);
            reverse.get(v2).add(v1);
        }

        isvisited = new boolean[v+1];
        stack = new Stack<>();

        for(int i = 1; i <= v; i++){
            if(!isvisited[i]){
                DFS(i);
            }
        }

        isvisited = new boolean[v+1];
        int cnt = 0;
        while(!stack.isEmpty()){
            int now = stack.pop();

            if(!isvisited[now]){
                DFS_reverse(now, cnt);
                cnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cnt+"\n");

        LinkedList<Integer> idx = new LinkedList<>();
        int num = 0;
        for(ArrayList<Integer> arr : ans){
            if(arr.isEmpty()){
                idx.add(num);
            }
            num++;
        }

        num = 0;
        while(!idx.isEmpty()){
            int temp = idx.pop();
            ans.remove(temp-num);
            num++;
        }
        for (int i = 0; i < cnt; i++) {
            Collections.sort(ans.get(i));
        }

        Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0)-o2.get(0);
            }
        });

        for(ArrayList<Integer> arr : ans){
            if(arr.isEmpty()){
                continue;
            }
            for(int t : arr){
                sb.append(t+" ");
            }
            sb.append("-1\n");
        }
        System.out.println(sb);
    }
    public static void DFS(int now) {
        isvisited[now] = true;

        for(int t : graph.get(now)){
            if(!isvisited[t]){
                DFS(t);
            }
        }
        stack.push(now);
    }
    public static void DFS_reverse(int now, int group){
        isvisited[now] = true;
        ans.get(group).add(now);

        for(int t : reverse.get(now)){
            if(!isvisited[t]){
                DFS_reverse(t, group);
            }
        }
    }

}