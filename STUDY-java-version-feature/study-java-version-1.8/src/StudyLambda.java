
public class StudyLambda {
	public static void main(String[] args) {
		StudyFuncInf studyFuncInf = (msg) -> {
			System.out.println(String.format("funcMethod - %s", msg));
		};
		
		studyFuncInf.funcMethod("안녕하세요~!");
	}
}
