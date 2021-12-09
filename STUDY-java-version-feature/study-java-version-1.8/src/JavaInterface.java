
public interface JavaInterface {
	static public String interfaceStaticMethod() {
		return "interfaceStaticMethod";
	}
	
	default public String defaultInterfaceMethod() {
		return "defaultInterfaceMethod";
	}
}
