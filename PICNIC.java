import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr;
	public static boolean[] check;
	public static int cnt = 0;
	
	public static void main(String args[])throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int c = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i = 0; i < c; i++) {
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			settingArray(n);
			
			String friendship = br.readLine();
			insertFriendship(friendship);
			
			search(n, n/2);
			
			System.out.println(cnt);
		}
	}
	public static void settingArray(int size) {
		arr = new int[size][size];
		for(int x = 0; x < size; x++) {
			for(int y = 0; y < size; y++) {
				arr[x][y] = 0;
			}
		}
		check = new boolean[size];
	}
	
	public static void insertFriendship(String s) {
		StringTokenizer token = new StringTokenizer(s);
		
		while(token.hasMoreTokens()) {
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
	}
	
	public static void search(int size, int pair) {
		if(pair == 0) {
			cnt++;
			return;
		}
		
		int k = 0;
		for(int i = 0; i < size; i++) {
			if(!check[i]) {
				k = i;
				break;
			}
		}
		
		for(int i = 0; i < size; i++) {
			if(check[i] == false && arr[k][i] == 1) {
				check[i] = true;
				check[k] = true;
				pair--;
				search(size, pair);
				check[i] = false;
				check[k] = false;
				pair++;
			}
		}
		
	}
	
}


 
