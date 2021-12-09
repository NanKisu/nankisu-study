import java.util.Optional;

public class StudyOptional {
	public static void main(String[] args) {
		Optional<String> optionalStr = Optional.empty();
		Optional<String> optionalStr = Optional.of("str");
		Optional<String> optionalStr = Optional.ofNullable("str");
		
		System.out.println(optionalStr.orElse("empty str"));
		
		String value = null;
		String result = "";
		try {
		    result = value.toUpperCase();
		} catch (NullPointerException exception) {
		    throw new Exception();
		}
		
		String value = null;
		Optional<String> valueOpt = Optional.ofNullable(value);
		String result = valueOpt.orElseThrow(Exception::new).toUpperCase();
	}
}
