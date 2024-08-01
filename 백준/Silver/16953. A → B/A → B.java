import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static Map<Long,Long> map;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long base = Integer.parseInt(st.nextToken());
        long des = Integer.parseInt(st.nextToken());

        map = new HashMap<>();

        BFS(base,des);
        if(map.get(des) == null){
            System.out.println("-1");
        }else{
            System.out.println(map.get(des));
        }
    }
    public static void BFS(long base, long des) {
        Queue<Long> queue = new LinkedList<>();
        queue.add(base);
        map.put(base,(long)1);

        while (!queue.isEmpty()) {
            long n = queue.poll();

            if(n > des){
                continue;
            }

            for(int i = 0; i <= 1; i++){
                long l;
                if(i == 0){
                    l = n*10+1;
                }else{
                    l = n*2;
                }

                if(l > des){
                    continue;
                }

                if(map.containsKey(l)){
                    if(map.get(l) > map.get(n)+1){
                        map.remove(l);
                        map.put(l,map.get(n)+1);
                        queue.add(l);
                    }
                }else{
                    map.put(l,map.get(n)+1);
                    queue.add(l);
                }

            }
        }
    }
}