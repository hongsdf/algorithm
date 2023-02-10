package algorithm;

public class 단어변환3 {
	public static void main(String[] args) {
		SolutionT1 m = new SolutionT1();
		String begin = "hit";
		String target = "cog";
	    String[] words = {"hot", "dot", "dog", "lot", "log"};
		// String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		int answer = m.solution(begin,target,words);
		System.out.println(answer);
	}
}
class SolutionT1 {
	public int answer = 9999;
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, 0, visited);
        return answer == 9999? 0:answer;
        
    }
    private void dfs(String begin, String target, String[] words, int count, boolean[] visited) {
        if (begin.equals(target)) {
        	answer = Math.min(answer, count);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }
            int check = 0; // 같은 스펠링이 몇개인지 세기
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    check++;
                }
            }
            if (check == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, count + 1, visited);
                visited[i] = false;
            }
        }
        
    }
}