
public class StudyInterface {
	public static void main(String[] args) {
		System.out.println(JavaInterface.interfaceStaticMethod());
		//System.out.println(JavaInplementClass.interfaceStaticMethod());

		JavaInterface javaInterface = new JavaInplementClass();
		System.out.println(javaInterface.defaultInterfaceMethod());
	}
}
