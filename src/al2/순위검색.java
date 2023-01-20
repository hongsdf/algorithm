package al2;

public class 순위검색 {
	public static void main(String[] args) {
		SolutionK6 m = new SolutionK6();
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		int answer[] = m.solution(info, query);
		for(int num :answer) {
			System.out.print(num+" ");
		}
	
	}
}
class SolutionK6 {
	int answer[];
	public int[] solution(String[] info, String[] query) {
		answer = new int[query.length];
		
		for(int i = 0; i < query.length; i++) {
			String qu = query[i].replaceAll(" and "," ");
			String test[] = qu.split(" ");
			
			
			for(String in :info) {
				String str[] = in.split(" ");
				// str[4] = 코딩테스트 점수가 될것이다.
				boolean flag = check(test,str);
				if(flag) {
					boolean flag2 = testcode(Integer.valueOf(test[4]),Integer.valueOf(str[4])); // 코딩 테스트 점수 확인
					if(flag2) {
						answer[i]++;						
					}
				}
				
			}
		}
		
		return answer;
		
	}
	
	private boolean testcode(Integer test, Integer str) {
		if(test <= str) return true;
		return false;
		
		
	}

	private boolean check(String[] test, String[] str) {
		for(int i = 0; i <4; i++) {
			if(test[i].equals("-")) continue;
			if(!test[i].equals(str[i])) {
				return false;
			}
		}
		return true;
		
	}
	
}