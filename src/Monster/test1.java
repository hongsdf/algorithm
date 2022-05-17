package Monster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 4 3 4 3 3 2
// O(N + N^2)
public class test1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> q = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		while(N -- > 0) {
			q.add(Integer.parseInt(st.nextToken()));
		}
		LinkedList<Integer> q2 = new LinkedList<>();
		while(!q.isEmpty()) {
			q2.add(q.poll());
			for(int i = 0; i<q2.size(); i+=1) {
				System.out.print(q2.get(i)+" ");
			}
			System.out.println();
		}
	}
}
