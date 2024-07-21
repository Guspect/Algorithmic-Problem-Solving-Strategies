import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> Heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > 0 && o2 >0) {
                    return o1 - o2;
                }else if(o1 < 0 && o2 < 0){
                    return (-1)*o1 - (-1)*o2;
                }else if(o1 < 0){
                    if((-1)*o1 - o2 == 0){
                        return -1;
                    }
                    return (-1)*o1 - o2;
                }else{
                    if((-1)*o1 - o2 == 0){
                        return 1;
                    }
                    return o1 - (-1)*o2;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int cmd = Integer.parseInt(br.readLine());
            if(cmd != 0){
                Heap.add(cmd);
            }else{
                if(Heap.isEmpty()){
                    sb.append("0\n");
                }else {
                    sb.append(Heap.poll()+"\n");
                }
            }
        }
        System.out.print(sb);
    }
}
