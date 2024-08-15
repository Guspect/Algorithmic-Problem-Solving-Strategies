import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String args[])throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Long> queue = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++) {
			queue.add(Long.parseLong(br.readLine()));
		}
		
		long temp = 0;
		while(queue.size() > 1) {
			long num1 = queue.poll();
			long num2 = queue.poll();
			
			temp += num1 + num2;
			queue.add(num1+num2);
		}
		
		System.out.println(temp);
		
	}
}
