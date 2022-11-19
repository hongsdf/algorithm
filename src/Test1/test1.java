package Test1;

public class test1 {
	public static void main(String[] args) {
		
//		three() > five() > seven();
		// (three() > five()) and (five() > seven());
		//       F                 F
		
		if(test11() && test22() && test33() && test00()) {
			System.out.println("합격입니다.");
		}else System.out.println("불합격입니다.");
		
		// (test11() && test22())  and  (test22() && test33())
		//			F              and  뒤에 있는 것을 확인해 볼필요x
	}
	
	public static boolean test11() { System.out.print("코딩테스트 통과,"); return true;}
	public static boolean test22() {System.out.print("서류통과,");return false ;}
	public static boolean test33() {System.out.print("면접 통과 ");return true;}
	public static boolean test00() {System.out.println("모든 테스트 통과");return true;}
	
	
}
