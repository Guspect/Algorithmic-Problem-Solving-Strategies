import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static StringBuilder sb;
    public static TreeMap<Integer, Integer> tree;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            tree = new TreeMap<>();

            for(int j = 0; j < k; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                char c = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                Manipulate(c,num);
            }
            if(tree.isEmpty()){
                sb.append("EMPTY\n");
            }else{
                sb.append(tree.lastKey()+" "+tree.firstKey()+"\n");
            }
        }
        System.out.println(sb);
    }
    public static void Manipulate(char cmd, int num){
        if(cmd == 'I'){
            if(tree.containsKey(num)){
                int val = tree.get(num);
                tree.remove(num);
                tree.put(num,val+1);
            }else{
                tree.put(num,1);
            }
        }else{
            if(tree.isEmpty()){
                return;
            }else{
                if(num == -1){
                    int k = tree.firstKey();
                    if(tree.get(k) == 1){
                        tree.remove(k);
                    }else{
                        int val = tree.get(k);
                        tree.remove(k);
                        tree.put(k,val-1);
                    }
                }else{
                    int k = tree.lastKey();
                    if(tree.get(k) == 1){
                        tree.remove(k);
                    }else{
                        int val = tree.get(k);
                        tree.remove(k);
                        tree.put(k,val-1);
                    }
                }
            }
        }

    }

}
